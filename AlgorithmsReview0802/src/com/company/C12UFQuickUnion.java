package com.company;

import java.util.Scanner;

public class C12UFQuickUnion {
    private int[] id;
    private int N;
    public C12UFQuickUnion(int N){
        this.N = N;
        id = new int[N];
        for (int i = 0; i<N;i++){
            id[i] = i;
        }
    }
    public int find(int i){
        while (id[i]!=i){
            i = id[i];
        }
        return i;
    }
    public void union(int i, int j){
        if (!connected(i,j)){
            id[i] = j;
            N--;
        }
    }
    public boolean connected(int i, int j){
        int x = find(i);
        int y = find(j);
        if (x == y){
            return true;
        }
        return false;
    }
    public int count(){
        return N;
    }
    public static void main(String[] args){
        C12UFQuickUnion uf = new C12UFQuickUnion(10);
        int n = 10;
        Scanner sc = new Scanner(System.in);
        while (n>0){
            System.out.println(n);
            int i = sc.nextInt();
            int j = sc.nextInt();
            uf.union(i,j);

            n--;
        }
        System.out.println(uf.connected(6,0));
    }
}
