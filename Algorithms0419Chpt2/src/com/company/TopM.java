package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mileygao on 4/28/17.
 */
public class TopM<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;
    public TopM(int maxN){
        pq = (Key[])new Comparable[maxN+1];
        }
    public void insert(Key v){
        if (N == pq.length){
            resize(2*N);
        }
        pq[++N] = v;
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        if (N == pq.length/4 && N>0){
            resize(pq.length/2);
        }
        return max;
    }
    public void resize(int M){
        Key[] temp = (Key[]) new Comparable[M];
        for (int i = 0; i <M; i++){
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void swim(int N){
        while (N>1 && less(N/2,N)) {
            exch(N / 2, N);
            N = N/2;
        }
    }


    public void sink(int k){
        while (k<=N/2){
            int j = 2*k;
            if (j < N && less(j,j+1)){
                j++;
            }
            if (!less(k,j)){
                break;
            }
            exch(j,k);
            k = j;
        }
    }

    public boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }
    public void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    public static void main(String[] args){
        int M = 5;
        TopM<String> pq = new TopM<String>(M+1);
        Scanner sc = new Scanner(System.in);
        int k = 1;
        while (k<=10){
            pq.insert(sc.next());
            if (pq.size()>M){
                pq.delMax();
            }
            k++;
        }
        Stack<String> stack = new Stack<>();
        while (!pq.isEmpty()){
            stack.push(pq.delMax());
        }
        for (String s : stack){
            System.out.println(s);
        }
    }
}
