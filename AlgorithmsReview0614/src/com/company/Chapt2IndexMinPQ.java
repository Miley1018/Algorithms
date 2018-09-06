package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mileygao on 6/20/17.
 */
public class Chapt2IndexMinPQ<Key extends Comparable<Key>> {
    //------------错误！需重写
    private Key[] pq;
    private int N = 0;
    private Map<Key, Integer> map;
    public Chapt2IndexMinPQ(int N){
        pq = (Key[])new Comparable[N+1];
        map = new HashMap();
    }
    public static void merge(Integer[][] streams){
        Chapt2IndexMinPQ<Integer> pq = new Chapt2IndexMinPQ<Integer>(streams.length+1);
        int[] forward = new int[streams.length];
        for (int i = 0; i<streams.length;i++){
            if (forward[i]<=streams[i].length-1){
                System.out.println("insert:"+streams[i][forward[i]]);
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
                System.out.println("insert:"+streams[index][forward[index]]);
                forward[index]++;
            }
        }
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void insert(int index, Key key){
        pq[++N] = key;
        map.put(key,index);
        swim(N);
    }
    public void delMin(){
        Key max = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        map.remove(max);
    }
    public Key min(){
        return pq[1];
    }
    public int minIndex(){
        System.out.println("wgg"+map);
        System.out.println("ttt"+pq[1]);
        return map.get(pq[1]);
    }
    private void sink(int n){
        while(n<=N/2){
            int j = 2*n;
            if (n*2<N &&less(2*n,2*n+1)){
                j = 2*n+1;
            }
            if (!less(n,j)){
                break;
            }
            exch(n,j);
            n = j;
        }
    }
    private void swim(int n){
        while (n>1&&less(n/2,n)){
            exch(n,n/2);
            n = n/2;
        }
    }
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }
    public static void main(String[] args){
        Integer[][] streams = {{1,2,10,12},{0,2,3,4},{0,5,7,10},{1,6,8,11}};
        merge(streams);
    }
}
