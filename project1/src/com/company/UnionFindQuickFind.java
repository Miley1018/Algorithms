package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 3/31/17.
 */
public class UnionFindQuickFind {
    public static void main(String[] args){
        UnionFindQuickFind uf = new UnionFindQuickFind(10);
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        sc.nextLine();
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
    int[] id;
    private int count;
    public UnionFindQuickFind(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i<N;i++){
            id[i] = i;
        }
    }

    public int find(int p){
        return id[p];
    }

    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        for (int i = 0; i <id.length;i++){
            if (id[i]==pId){
                id[i] = qId;
            }
        }
        count--;
    }
}
