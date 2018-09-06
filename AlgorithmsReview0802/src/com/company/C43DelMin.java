package com.company;

/**
 * Created by mileygao on 8/16/17.
 */
public class C43DelMin<Item extends Comparable<Item>> {
    private int N;
    private Item[] items;
    public C43DelMin(int n){
        items = (Item[])new Comparable[n+1];
    }
    public void insert(Item item){
        items[++N] = item;
        swim(N);
    }
    public Item delMin(){
        Item i = items[1];
        exch(1,N--);
        sink(1);
        items[N+1] = null;
        return i;
    }
    private void swim(int k){
        while (k>1){
            if (less(k,k/2)){
                exch(k,k/2);
            }
            k = k/2;
        }
    }
    private void sink(int k){
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
    private void exch(int i, int j){
        Item t = items[i];
        items[i] = items[j];
        items[j] = t;
    }
    private boolean less(int i, int j){
        return items[i].compareTo(items[j])<0;
    }
    public boolean isEmpty(){
        return N==0;
    }
}
