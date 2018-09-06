package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 7/12/17.
 */
public class Chapt1UF4 {
    private class UF{
        private int N;
        private int[] id;
        private int[] size;
        private UF(int n){
            this.N = n;
            id = new int[n];
            for (int i = 0; i<n;i++){
                id[i] = i;
            }
            size = new int[n];
        }
        private void union(int i, int j){
            int p = find(i);
            int q = find(j);
            if (p==q){
                return;
            }
            N--;
            if (size[p]<size[q]){
                id[p] = q;
                size[q]+=size[p];
            }else {
                id[q] = p;
                size[p]+=size[q];
            }
        }
        private int find(int i){
            int p = i;
            while (id[i]!=i){
                i = id[i];
            }
            int res= i;
            i = p;
            int tmp;
            while (id[i]!=i){
                tmp = id[i];
                id[i] = res;
                i = id[i];
            }
            return res;
        }
        private int count(){
            return N;
        }
        private boolean connected(int i, int j){
            int p = find(i);
            int q = find(j);
            if (p==q){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args){
        Chapt1UF4 uff = new Chapt1UF4();
        Chapt1UF4.UF uf = uff.new UF(10);
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
