package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 7/6/17.
 */
public class Chapt1UFQuickUnion3{
    private int[] id;
    private int N;
    public Chapt1UFQuickUnion3(int N){
        this.N = N;
        id = new int[N];
        for (int i = 0; i<N;i++){
            id[i] = i;
        }
    }
    public void union(int i, int j){
        int p = find(i);
        int q = find(j);
        if (p == q){
            return;
        }
        N--;
        id[p] = q;
    }
    public int find(int i ){
        while (i!=id[i]){
            i = id[i];
        }
        return i;
    }
    public boolean connected(int i, int j){
        int p = find(i);
        int q = find(j);
        return p == q;
    }
    public int count(){
        return N;
    }
    public static void main(String[] args){
        Chapt1UFQuickUnion3 uf = new Chapt1UFQuickUnion3(10);
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
