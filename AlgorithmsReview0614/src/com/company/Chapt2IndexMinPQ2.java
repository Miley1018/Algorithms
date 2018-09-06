package com.company;

/**
 * Created by mileygao on 6/30/17.
 */
public class Chapt2IndexMinPQ2<Item extends Comparable<Item>> {
    private int N;
    private int[] pq; //pp位置---streams的index
    private Item[] items;//streams的index---item
    private int[] pp;//streams的index---在pp的位置
    private int ppy;//swim or sink to ppy position
    public Chapt2IndexMinPQ2(int M){
        pq = new int[M+1];
        items =(Item[]) new Comparable[M];
        pp = new int[M];
        for (int i = 0; i<M;i++){
            pq[i] = -1;
            pp[i] = -1;
        }
    }
    public void insert(int k, Item item){
        if (contains(k)){
            change(k,item);
            return;
        }
        items[k] = item;
        pq[++N] = k;
        swim(N);
        pp[k] = ppy;
    }
    public Item min(){
        if (isEmpty()){
            return null;
        }
        int index = pq[1];
        Item min = items[index];
        return min;
    }
    public int delMin(){
        int index = pq[1];
        delete(index);
        return index;
    }
    public int minIndex(){
        return pq[1];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void delete(int k){
        items[k] = null;
        int i = pp[k];
        pp[k] = -1;
        exch(i,N--);
        sink(i);
        pq[N+1] = -1;
    }
    public void change(int k, Item item){
        items[k] = item;
        int i = pp[k];
        swim(i);
        sink(ppy);
        pp[k] = ppy;
    }
    public boolean contains(int k){
        return items[k]!=null;
    }
    private void sink(int k){
        while (k<=N/2){
            int j = 2*k;
            if (j<N&&less(j+1,j)){
                j = j+1;
            }
            if (!less(j,k)){
                break;
            }
            exch(j,k);
            k = j;
        }
        ppy = k;
    }
    private void swim(int k){
        while (k>1){
            if (less(k,k/2)){
                exch(k,k/2);
            }else {
                break;
            }
            k = k/2;
        }
        ppy = k;
    }
    private void exch(int i, int j){
        int index1 = pq[i];
        int index2 = pq[j];
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
        pp[index1] = j;
        pp[index2] = i;
    }
    private boolean less(int i, int j){
        int index1 = pq[i];
        int index2 = pq[j];
        return items[index1].compareTo(items[index2])<0;
    }
    public static void merge(Integer[][] streams){
        Chapt2IndexMinPQ2<Integer> pq = new Chapt2IndexMinPQ2(streams.length+1);
        int[] forward = new int[streams.length];
        for (int i = 0; i<streams.length;i++){
            if (forward[i]<=streams[i].length-1){
            //  System.out.println("insert:"+streams[i][forward[i]]);
                pq.insert(i,streams[i][forward[i]]);
                forward[i]++;
            }
        }
        while(!pq.isEmpty()){
            System.out.println( pq.min());
            int index = pq.minIndex();
            pq.delMin();
            if (forward[index]<=streams[index].length-1){
                pq.insert(index,streams[index][forward[index]]);
               // System.out.println("insert:"+streams[index][forward[index]]);
                forward[index]++;
            }
        }

    }
    public static void main(String[] args){
        Integer[][] streams = {{1,2,10,12},{0,2,3,4},{0,5,7,10},{1,6,8,11}};
        merge(streams);
    }
}
