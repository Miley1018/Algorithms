package com.company;

/**
 * Created by mileygao on 7/7/17.
 */
public class Chapt2IndexMinPQ3 <Item extends Comparable<Item>>{
    private Item[] items;  //index-item
    private int[] pq;     //i-index
    private int[] qp;     //index-i
    private int N;
    public Chapt2IndexMinPQ3(int n){
        items =(Item[]) new Comparable[n];
        pq = new int[n+1];
        qp = new int[n];
    }
    public void insert(int k, Item item){
        if (contains(k)) {//=====================
            change(k,item);
            return;
        }
        items[k] = item;
        pq[++N] = k;
        qp[k] = N;
        swim(N);
    }
    private void swim(int k){
        while (k>1){
            if (less(k,k/2)){
                exch(k,k/2);
            }
            k = k/2;
        }
    }
    private void sink(int k ){
        while (k<=N/2){
            int j = k*2;
            if (j<N&&less(j+1,j)){
                j = j+1;
            }
            if (!less(j,k)){
                break;
            }
            exch(j,k);
            k = j;
        }
    }
    private boolean less(int i, int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }
    private void exch(int i, int j){
        int t = pq[i];
        int tt= pq[j];
        pq[j] = t;
        pq[i] = tt;
        qp[t] = j;
        qp[tt] = i;
    }
    public void delete(int k){
        items[k] = null;
        int i = qp[k];
        qp[k] = -1;
        exch(i,N--);
        pq[N+1] = -1;
        sink(i);
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int minIndex(){
        return pq[1];
    }
    public int delMin(){
        int i = minIndex();
        delete(i);
        return i;
    }
    public Item min(){
        Item i = items[pq[1]];
        return i;
    }


    public Item get(int k){
        return items[k];
    }
    public boolean contains(int k){
        return items[k]!=null;
    }
    public void change(int k , Item item){
        delete(k);
        insert(k,item);
    }
    public static void merge(Integer[][] streams){
        Chapt2IndexMinPQ3 pq = new Chapt2IndexMinPQ3(streams.length);
        int[] t = new int[streams.length];
        for (int i = 0; i<streams.length;i++){
            pq.insert(i,streams[i][t[i]++]);
            pq.change(i,-1);
        }

        while (!pq.isEmpty()) {
            int index = pq.minIndex();
            System.out.println(pq.min());

            pq.delMin();
            if (t[index]>streams[index].length-1){
                continue;
            }
            pq.insert(index,streams[index][t[index]++]);
        }
    }
    public static void main(String[] args){
        Integer[][] streams = {{1,2,10,12},{0,2,3,4},{0,5,7,10},{1,6,8,11}};
        merge(streams);
    }
}
