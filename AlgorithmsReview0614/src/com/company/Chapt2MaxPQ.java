package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mileygao on 6/20/17.
 */
public class Chapt2MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    public Chapt2MaxPQ(){

    }
    public Chapt2MaxPQ(int maxN){
        pq = (Key[])new Comparable[maxN+1];
        N = 0;
    }
    public Chapt2MaxPQ(Key[] a){
        pq = (Key[])new Comparable[a.length];
    }
    public Key delMax(){
        Key max = null;
        if (N>0) {
            max = pq[1];
            exch(1,N--);
            sink(1);
            pq[N+1] = null;
        }
        return max;
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void insert(Key key){
        pq[++N] = key;
        swim(N);
    }
    public Key max(){
        Key max = pq[1];
        return max;
    }
    private void swim(int n){
        while (n>1&&less(n/2,n)){
            exch(n,n/2);
            n = n/2;
        }
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
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }
    public static void main(String[] args){
        Chapt2MaxPQ maxPQ = new Chapt2MaxPQ(6);
        Scanner sc = new Scanner(System.in);
        Comparable key = sc.next();
        while (!key.equals("-")){
            maxPQ.insert(key);
            if (maxPQ.size()>5){
                maxPQ.delMax();
            }
            key = sc.next();
        }
        Stack<Comparable> stack = new Stack<>();
        System.out.println(maxPQ.size());
        while(maxPQ.size()>0){
            stack.push(maxPQ.delMax());
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
