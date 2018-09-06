package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 4/20/17.
 */
public class UnionFind {
    private int cnt;
    private int[] id;
    private int[] size;
    public UnionFind(int N){
        cnt = N;
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
        for (int i = 0; i < N; i++){
            size[i] = 1;
        }
    }

    public int find(int p){
        while (p != id[p]){
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int getCnt(){
        return cnt;
    }

    public void union(int p , int q){
        int pRoot = find(p);
        int qRoot = find(q);
        // if (pRoot == qRoot)             -------------------no need?
        if (size[p] < size[q]){
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        else{
            id[qRoot] = pRoot;
            size[pRoot]+=size[qRoot];
        }
        cnt--;
        for (int i = 0; i < 10; i++){
            System.out.print(size[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        UnionFind uf = new UnionFind(10);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int p = sc.nextInt();
            int q = sc.nextInt();
            sc.nextLine();
            if (uf.connected(p,q)){
                System.out.println("already connected");
                continue;
            }
            uf.union(p,q);
            System.out.println(p+"connected to"+q);
            System.out.println(uf.getCnt());
        }

    }
}
