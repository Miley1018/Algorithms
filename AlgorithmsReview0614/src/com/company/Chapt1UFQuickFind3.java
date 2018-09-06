package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 7/6/17.
 */
public class Chapt1UFQuickFind3 {
    private int[] id;
    private int N;
    public Chapt1UFQuickFind3(int N){
        this.N = N;
        id = new int[N];
        for (int i = 0; i<N;i++){
            id[i] = i;
        }
    }
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if (i == j){
            return;
        }
        N--;
        for (int t = 0; t<N;t++){
            if (id[t] == i){
                id[t] = j;
            }
        }
    }
    private int find(int p){
        return id[p];
    }
    public int count(){
        return N;
    }
    public boolean connected(int p, int q){
        int i = find(p);
        int j = find(q);
        return i == j;
    }

    public static void main(String[] args){
        Chapt1UFQuickFind3 uf = new Chapt1UFQuickFind3(10);
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
