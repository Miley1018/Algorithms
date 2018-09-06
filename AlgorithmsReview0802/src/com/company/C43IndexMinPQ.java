package com.company;

/**
 * Created by mileygao on 8/16/17.
 */
public class C43IndexMinPQ<Item extends Comparable<Item>> {
    private Item[] items;//index-item
    private int[] pq;//i-index;
    private int[] qp;//index-i
    private int N;
    public C43IndexMinPQ(int n){
        items =(Item[]) new Comparable[n];
        pq = new int[n+1];
        for (int i = 0; i<n+1;i++){
            pq[i] = -1;
        }
        qp = new int[n];
    }
    public void insert(int k, Item item){
        items[k] = item;
        pq[++N] = k;
        qp[k] = N;
        swim(N);
    }
    public int delMin(){
        int index = pq[1];
        exch(1,N--);
        items[index] = null;
        sink(1);
        return index;
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
    }
    private void swim(int k){
        while (k>1){
            if (less(k,k/2)){
                exch(k,k/2);
            }
            k = k/2;
        }
    }
    private void exch(int i, int j){
        int a = pq[i];
       int b = pq[j];
       pq[i] = b;
       pq[j] = a;
       qp[a] = j;
       qp[b] = i;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public boolean contains(int k){
        return items[k]!=null;
    }
    public void change(int k, Item item){
       delete(k);
       insert(k,item);
    }
    private void delete(int k){
        items[k] = null;
        int i = qp[k];
        exch(i,N--);
        pq[N+1] = -1;
        qp[k] = -1;
        sink(i);
    }
    private boolean less(int i, int j){
       return items[pq[i]].compareTo(items[pq[j]])<0;
    }
}
