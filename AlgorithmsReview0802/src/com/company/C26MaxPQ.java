package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mileygao on 8/4/17.
 */
public class C26MaxPQ <Item extends Comparable<Item>>{
    private int N;
    private Item[] pq;
    public C26MaxPQ(int M){
        pq = (Item[])new Comparable[M+2];
    }
    public void insert(Item a){
        pq[++N] = a;
        swim(N);
    }
    private void swim(int k){
        while (k>1&&less(pq[k],pq[k/2])){
            exch(k,k/2,pq);
            k=k/2;
        }
    }
    public int size (){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public Item delMin(){
        Item v = pq[1];
        exch(1,N--,pq);
        pq[N+1] = null;
        sink(1);
        return v;
    }
    private void sink(int k){
        while (k<=N/2){
            int j = 2*k;
            if (j<N&&less(pq[j+1],pq[j])){
                j = j+1;
            }
            if (!less(pq[j],pq[k])){
                break;
            }
            exch(k,j,pq);
            k = j;
        }
    }
    public boolean less(Item a, Item b){
        return a.compareTo(b)<0;
    }
    public void exch(int i, int j, Item[] a){
        Item t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public void show(Item[] a){
        for (int i = 0; i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
    public static void main(String[] args){
        C26MaxPQ<String> sort = new C26MaxPQ(5);
        int M = 5;
        Scanner sc = new Scanner(System.in);
       for (int i = 0; i <= 10; i++){
           String a = sc.next();
           sort.insert(a);
           if (sort.size()>M){
               sort.delMin();
           }
       }
       Stack<String> stack = new Stack();
       while (!sort.isEmpty()){
           stack.push(sort.delMin());
       }
       while (!stack.isEmpty()){
           System.out.println(stack.pop());
       }
    }
}
