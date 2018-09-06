package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 7/6/17.
 */
public class Chapt1UF3 {
    private int N;
    private int[] id;
    private int[] size;
    public Chapt1UF3(int N){
        this.N = N;
        id = new int[N];
        for (int i = 0; i<N;i++){
            id[i] = i;
        }
        size = new int[N];
        for (int i = 0; i<N;i++){
            size[i] = 1;
        }
    }
    public int count(){
        return N;
    }
    public void union(int p , int q){
       int i = find(p);
       int j = find(q);
       if (i == j){
           return;
       }
       N--;
       if (size[i]<size[j]){
           id[i] = j;
       }else {
           id[j] = i;
       }
    }
    public int find(int p){
        int t = p;
        while (p!=id[p]){
            p = id[p];
        }
        int r = p;
        p = t;
        while (p!=id[p]){
            int e = p;
            p = id[p];
            id[e] = r;
        }
        return r;
    }
    public boolean connected(int p , int q){
        int i = find(p);
        int j = find(q);
        return i==j;
    }
    public static void main(String[] args){
        Chapt1UF3 uf = new Chapt1UF3(10);
        int n = 0;
        int[] test = {9,8,7,6,5,4,3,2,1,0,1,2,3,4,5,4,6,7,8,9};
        while (n<test.length){
            int i =test[n];
            int j =test[n+1];
            uf.union(i,j);
            n = n+2;
        }
        System.out.println("aaa"+uf.count());
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        System.out.println(uf.connected(i,j));
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(uf.connected(a,b));
        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(uf.connected(c,d));
    }
}
