package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mileygao on 7/7/17.
 */
public class Chapt2MaxPQ4<Item extends Comparable<Item>> {
    private Item[] pq;
    private int N;
    public Chapt2MaxPQ4(int n){
        pq =(Item[]) new Comparable[n+1];
    }
    public Item delMin(){
        Item t = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        return t;
    }
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }
    private void exch(int i, int j){
        Item t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    public void insert(Item item){
        pq[++N] = item;
        swim(N);
    }
    public int size(){
        return N;
    }
    private void sink(int k){
        while (k<=N/2){
            int j = 2*k;
            if (j<N&&less(j,j+1)){
                j = j+1;
            }
            if (!less(k,j)){
                break;
            }
            exch(j,k);
            k = j;
        }
    }
    private void swim(int k){
        while (k>1){
            if (less(k/2,k)){
                exch(k/2,k);
            }else {
                break;
            }
            k = k/2;
        }
    }
    public static void main(String[] args){
        Chapt2MaxPQ4 maxPQ = new Chapt2MaxPQ4(6);
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
