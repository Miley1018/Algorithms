package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 6/14/17.
 */
public class Chapt1UFQuickUnion {
    private int N;
    private int[] id;
    private Chapt1UFQuickUnion(int N){
        this.N = N;
        id = new int[N];
        for (int i = 0; i<N; i++){
            id[i] = i;
        }
    }
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if (i==j){
            return;
        }
        N--;
        id[i] = j;
    }
    public int find(int p){
        while (p!=id[p]){
            p = id[p];
        }
        return id[p];
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int count(){
        return N;
    }
    public static void main(String[] args){
        Chapt1UFQuickUnion uf = new Chapt1UFQuickUnion(10);
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
/*
4 3
        3 8
        6 5
        9 4
        2 1
        5 0
        7 2
        6 1
        6 1
        6 1
*/
