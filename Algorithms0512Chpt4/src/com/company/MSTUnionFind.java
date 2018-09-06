package com.company;

/**
 * Created by mileygao on 5/18/17.
 */
public class MSTUnionFind {
    private int[] id;
    private int[] size;
    private int cnt;
    public MSTUnionFind(int N){
        id = new int[N];
        for (int i = 0; i<N;i++){
            id[i] = i;
        }
        size = new int[N];
        for (int i = 0; i<N;i++){
            size[i] = 1;
        }
        cnt = N;

    }
    public void union(int i, int j){
        int iRoot = find(i);
        int jRoot = find(j);
        if (iRoot==jRoot){
            return;
        }
        if (size[iRoot]>=size[jRoot]){
            id[jRoot] = iRoot;
            size[iRoot]+=size[jRoot];
        }
        if (size[iRoot]<size[jRoot]){
            id[iRoot] = jRoot;
            size[jRoot]+=size[iRoot];
        }
        cnt--;
    }
    public int find(int i){
        while (i!=id[i]){
            i = id[i];
        }
        return i;
    }
    public boolean connected(int i , int j){
        return find(i) == find(j);
    }
    public int getCnt(){
        return cnt;
    }
}
