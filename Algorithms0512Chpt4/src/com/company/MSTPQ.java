package com.company;

import java.util.List;

/**
 * Created by mileygao on 5/18/17.
 */
public class MSTPQ<Key extends Comparable<Key>> {
    private int N=0;
    private Key[] a;
    public MSTPQ(int maxN){
        a =(Key[]) new Comparable[maxN+1];
    }
    public MSTPQ(List<Key> list){
        int N = list.size();
        a = (Key[]) new Comparable[N+1];
        for (Key key: list){
            insert(key);
        }
    }
    public void insert(Key key){
        if (N>=a.length){
            resize(2*N);
        }
        a[++N]=key;
        swim(N);
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void swim(int k){
        while (k>1) {
            if (a[k / 2].compareTo(a[k]) > 0) {
                exch(k / 2, k);
            }
            k = k/2;
        }
    }
    public void sink(int k){
        while (k<=N/2) {
            int j = 2 * k;
            if (j<N && a[j].compareTo(a[j + 1]) > 0) {
                j = j + 1;
            }
            exch(k, j);
            k = j;
        }
        swim(k);
    }
    private void exch(int i, int j){
        Key temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private void resize(int k){
        Key[] b = (Key[]) new Comparable[k];
        for (int i = 1; i <=N; i++){
            b[i] = a[i];
        }
        a = b;
    }

    public Key delMin(){
        Key min = a[1];
        exch(1,N--);
        sink(1);
        a[N+1] = null;
        if (N==a.length/4){
            resize(a.length/2);
        }
        return min;
    }
}
