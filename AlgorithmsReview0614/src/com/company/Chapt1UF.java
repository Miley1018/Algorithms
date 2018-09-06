package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 6/14/17.
 */
public class Chapt1UF {
    private int cnt;
    private int[] size;
    private int[] id;
    private int N;
    private Chapt1UF(int N){
        this.N = N;
        cnt = N;
        id = new int[N];
        for (int i = 0; i<N; i++){
            id[i] = i;
        }
        size = new int[N];
        for (int i = 0; i<N;i++){
            size[i] = 1;
        }
    }
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if (i == j){
            return;
        }
        if (size[i]<size[j]){
            id[i] = j;
            size[j]+=size[i];
        }else{
            id[j] = i;
            size[i]+=size[j];
        }
        cnt--;
    }
    public int find(int p){// 路经压缩
        int t = p;
        while(id[p]!=p){
            p = id[p];
        }
        int root = p;
        p = t;
        int tmp;
        while (id[p]!=p){
            tmp = id[p];
            id[p] = root;
            p = tmp;
        }
        return root;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int count(){
        return cnt;
    }
    public static void main(String[] args){
        Chapt1UF uf = new Chapt1UF(10);
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
}
