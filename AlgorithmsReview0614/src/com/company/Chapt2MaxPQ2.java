package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt2MaxPQ2 <Item extends Comparable<Item>>{
    private int n;
    private Item[] pq;
    public Chapt2MaxPQ2(int N){
        pq = (Item[])new Comparable[N+2];
    }
    public void insert(Item item){
        pq[++n] = item;
        swim(n);
    }
    public int size(){
        return n;
    }
    public Item delMax(){
        Item max = pq[1];
        exch(1,n);
        n--;
        pq[n+1] = null;
        sink(1);
        return max;
    }
    private void sink(int k){
        while (k<=n/2) {
            int j = 2 * k;
            if (j<n&&less(j, j + 1)) {
                j = j + 1;
            }
            if (!less(k,j)){
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    private void swim(int k){
        while (k>1){
            if (less(k/2,k)){
                exch(k/2,k);
            }
            k = k/2;
        }
    }
    private void exch(int i, int j){
        Item tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }
    public static void main(String[] args){
        Chapt2MaxPQ2 maxPQ = new Chapt2MaxPQ2(5);
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
