package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt1UF2 {
    private int[] id;
    private int cnt;
    private int N;
    private int[] size;
    public Chapt1UF2(int N){
        this.N = N;
        cnt = N;
        id = new int[N];
        for (int i = 0; i<N;i++){
            id[i] = i;
        }
        size = new int[N];
        for (int i = 0; i <N;i++){
            size[i] = 1;
        }
    }
    public void union(int i, int j){
        int p = find(i);
        int q = find(j);
        if (p == q){
            return;
        }
        if (size[p]<size[q]){
            id[p] = q;
            size[q] += size[p];
        }else {
            id[q] = p;
            size[p]+=size[q];
        }
        cnt--;
    }
    private int find(int i){
        int p = i;
        while (i != id[i]){
            i = id[i];
        }
        int root = i;
        int tmp;
        while (p!=id[p]){
            tmp = id[p];
            id[p] = root;
            p = tmp;
        }
        return i;
    }
    public boolean connected(int i, int j){
        int p = find(i);
        int q = find(j);
        if (p == q){
            return true;
        }
        return false;
    }
    public int count(){
        return cnt;
    }
    public static void main(String[] args){
        Chapt1UF2 uf = new Chapt1UF2(10);
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
