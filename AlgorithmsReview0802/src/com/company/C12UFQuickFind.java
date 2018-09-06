package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 8/2/17.
 */
public class C12UFQuickFind {
    private int[] id;
    private int N;
    public C12UFQuickFind(int n){
        N=n;
        id = new int[n];
        for (int i = 0; i<n; i++){
            id[i] = i;
        }
    }
    public int find(int i){
        return id[i];
    }
    public void union(int i, int j){
        if (connected(i,j)){
            return;
        }
        N--;
        int q = find(j);
        int p = find(i);
       for (int t = 0; t<id.length;t++){
           if (id[t]==p){
               id[t]=q;
           }
       }
    }
    public boolean connected(int i, int j){
        int t = find(i);
        int e = find(j);
        if (t==e){
            return true;
        }
        return false;
    }
    public int count(){
        return N;
    }
    public static void main(String[] args){
        C12UFQuickFind uf = new C12UFQuickFind(10);
        int n = 10;
        Scanner sc = new Scanner(System.in);
        while (n>0){
            System.out.println(n);
            int i = sc.nextInt();
            int j = sc.nextInt();
            uf.union(i,j);

            n--;
        }
        System.out.println(uf.count());
    }
}//1 2 3 4 5 6 7 8 9 0 2 3 4 5 7 8 9 0 9 0
