package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mileygao on 6/29/17.
 */
public class Chapt2MaxPQ3<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    public Chapt2MaxPQ3(int M){
        pq =(Key[]) new Comparable[M+1];
    }
    private void sink(int k){
        while (k<=N/2){
            int j = 2*k;
            if (j<N&&less(j+1,j)){
                j=j+1;
            }
            if (!less(j,k)){
                break;
            }
            exch(k,j);
            k = j;
        }
    }
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }
    private void exch(int i, int j){
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
    private void swim(int k){
        while (k>1){
            if (less(k,k/2)){
                exch(k/2,k);
            }
            k = k/2;
        }
    }
    public void insert(Key key){
        pq[++N] = key;
        swim(N);
    }
    public int size(){
        return N;
    }
    public Key delMin(){
        Key min = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        return min;
    }
    public Key min(){
        return pq[1];
    }
    public static void main(String[] args){
        Chapt2MaxPQ3 maxPQ = new Chapt2MaxPQ3(6);
        Scanner sc = new Scanner(System.in);
        Comparable key = sc.next();
        while (!key.equals("-")){
            maxPQ.insert(key);
            if (maxPQ.size()>5){
                maxPQ.delMin();
            }
            key = sc.next();
        }
        Stack<Comparable> stack = new Stack<>();
        System.out.println(maxPQ.size());
        while(maxPQ.size()>0){
            stack.push(maxPQ.delMin());
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
