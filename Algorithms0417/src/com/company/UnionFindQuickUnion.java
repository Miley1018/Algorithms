package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 4/20/17.
 */
public class UnionFindQuickUnion {
    private int[] id;
    private int cnt;
    public UnionFindQuickUnion(int N){
        cnt = N;
        id = new int[N];
        for (int i =0; i<N;i++){
            id[i] = i;
        }
    }

    public int find(int p){
        int x = p;
        while (id[p] != p){
            p = id[p];
        }
        int root = p;
        p = x;
        while (id[p] != p){
            int op = p;
            p = id[p];
            id[op] = root;
        }
        return root;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        id[pRoot] = qRoot;
        cnt--;
    }
    public int getCnt(){
        return cnt;
    }
    public static void main(String[] args){
        UnionFindQuickUnion uf = new UnionFindQuickUnion(10);
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
