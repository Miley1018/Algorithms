package com.company;

/**
 * Created by mileygao on 8/16/17.
 */
public class C43UF {
    private int[] id;
    private int[] size;
    public C43UF(int n){
        id = new int[n];
        size = new int[n];
        for (int i = 0; i<n;i++){
            id[i] = i;
        }
    }
    public void union(int p,int q){
        int i = find(p);
        int j = find(q);
        if (i==j){
            return;
        }
        if (size[i]>size[j]){
            id[j] = i;
            size[i] += size[j];
        }else {
            id[i] = j;
            size[j]+=size[i];
        }
    }
    public int find(int p){
        int t = p;
        while (p!=id[p]){
            p=  id[p];
        }
        int rot = p;
        p = t;
        while(p!=id[p]){
            int m = id[p];
            id[p] = rot;
            p = m;
        }
        return rot;
    }
    public boolean connected(int p, int q){
        int i = find(p);
        int j = find(q);
        return i==j;
    }
}
