package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 4/18/17.
 */
public class UnionFindQuickFind {
    private int[] id;
    private int count;
    public UnionFindQuickFind(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }
    public int find(int p){
        return id[p];
    }
    public boolean connected(int p, int q){
      return find(p) == find(q);
    }
    public void union(int p, int q){
        if (find(p)==find(q)){
            return;
        }
        int root = find(p);
        for (int i = 0; i< id.length; i++){
            if(id[i] == root){
                id[i] = find(q);
            }
        }
        for (int i = 0; i< id.length; i++){
            System.out.println(i+": "+id[i]);
        }
        count--;
    }
    public int getCount(){
        return count;
    }
    public static void main(String[] args){
        UnionFindQuickFind uf = new UnionFindQuickFind(10);
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
            System.out.println(uf.getCount());
        }

    }
}
