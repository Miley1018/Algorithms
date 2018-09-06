package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 3/31/17.
 */
public class UnionFindQuickUnion {
    public static void main(String[] args){
        UnionFindQuickUnion uf = new UnionFindQuickUnion(10);
        Scanner sc = new Scanner(System.in);
        int x = 8;
        while (x>0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            x = x-1;
            uf.union(m,n);
            System.out.println(m+"  "+n);
        }
        System.out.println("count:"+uf.count);
    }
    private int count;
    private int[] id;
    public UnionFindQuickUnion(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i<N; i++){
            id[i] = i;
        }
    }

    public int find(int p){
        while (id[p]!=p){
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        id[pId] = qId;
        count--;
    }
}
