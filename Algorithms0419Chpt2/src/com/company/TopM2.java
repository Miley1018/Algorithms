package com.company;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by mileygao on 4/28/17.
 */
public class TopM2<Key extends Comparable<Key>> {
    private Key[] a;
    private int N = 0;
    public TopM2(int MaxN){
        a = (Key[]) new Comparable[MaxN+2];
    }

    public void insert(Key key){             //-----------------------------why  static  就不行？
        if (N>=a.length){
            resize(N*2);
        }
        a[++N] = key;
        swim(N);
    }

    public void swim(int N){
        while (N>1 &&less(a[N], a[N / 2])) {
            exch(N, N / 2);
            N = N/2;
        }
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public boolean less(Key a, Key b){
        return a.compareTo(b)<0;
    }
    public void resize(int max){
        Key[] b = (Key[]) new Comparable[max];
        for (int i = 0; i<N; i++){
            b[i] = a[i];
        }
        a = b;
    }
    public void sink(int N){
        while (N <= this.N/2) {
            int j = 2 * N;
            if (j<this.N && less(a[j + 1], a[j])) {
                j = j + 1;
            }
            /*if (!less(a[j],a[N])){
                break;
            }
            */
            exch(j,N);
            N = j;
        }
        swim(N);
    }
    public void show(){
        for (int i = 0; i <=N; i++){
            System.out.print(a[i]);
        }
        System.out.println("\n------");
    }
    public Key delMin(){
        Key min = a[1];
        exch(1,N--);
        sink(1);
        a[N+1] = null;
        if (N == a.length/4){
            resize(a.length/2);
        }
        return min;
    }
    public void exch(int i, int j){
        Key temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args){
        int N = 5;
        TopM2<String> pq = new TopM2<>(N);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <2*N; i++){
            pq.insert(sc.next());
            if (pq.size()>N){
                System.out.println(pq.delMin());
            }
        }
        LinkedList<String> list = new LinkedList<>();
        while (!pq.isEmpty()){
            list.push(pq.delMin());
        }
        for (String s: list) {
            System.out.println(s);
        }
    }
}
