package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt1UFQuickFind2 {
    private int[] id;
    private int cnt;
    private int maxN;
    public Chapt1UFQuickFind2(int cp){
        id = new int[cp];
        cnt = cp;
        maxN = cp;
        for (int i = 0; i<cp;i++){
            id[i] = i;
        }
    }
    public void union(int i, int j){
        int p = find(i);
        int q = find(j);
        if (p == q){
            return;
        }
        cnt--;
        for (int t = 0;t<maxN;t++){
            if(id[t]==p){
                id[t] = q;
            }
        }
    }
    private int find(int i){
        return id[i];
    }
    public int count(){
        return cnt;
    }
    public boolean connected(int i, int j){
        int p = find(i);
        int q = find(j);
        if (p == q){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Chapt1UFQuickFind2 uf = new Chapt1UFQuickFind2(10);
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
