package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 6/14/17.
 */
public class Chapt1UFQuickFind {
    private int cnt;
    private int[] id;
    private int N;
    private Chapt1UFQuickFind(int N){
        this.cnt = N;
        this.N = N;
        id = new int[N];
        for (int i = 0; i<N;i++){
            id[i] = i;
        }
    }
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if (i==j){return;}
        for (int k= 0; k<N;k++){
            if (id[k] == i){
                id[k] = j;
            }
        }
        cnt--;
    }
    public int find(int p){
        return id[p];
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int count(){
        return cnt;
    }
    public static void main(String[] args){
        Chapt1UFQuickFind uf = new Chapt1UFQuickFind(10);
        int n = 10;
        Scanner sc = new Scanner(System.in);
        while (n>0){
            int i = sc.nextInt();
            int j = sc.nextInt();
            uf.union(i,j);
            n--;
        }
        System.out.println(uf.count());
    }
}
