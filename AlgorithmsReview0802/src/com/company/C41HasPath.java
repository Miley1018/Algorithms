package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/14/17.
 */
public class C41HasPath {
    private int[] pathTo;
    private boolean[] marked;
    private final int s;
    private C41HasPath(C41Graph g, int s){
        this.s = s;
        pathTo = new int[g.V()];
        marked = new boolean[g.V()];
        pathTo[s] = s;
        dfs(g,s);
    }
    private void dfs(C41Graph g, int v){
        for (int i:g.adj(v)) {
            if (!marked[i]) {
                marked[i] = true;
                pathTo[i] = v;
                dfs(g, i);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    private List<Integer> pathTo(int v){
        List<Integer> list = new ArrayList<>();
        if (hasPathTo(v)) {
            for (int i = v; i!=s; i = pathTo[i]){
                list.add(i);
            }
        }
        list.add(s);
        return list;
    }
    public static void main(String[] args){
        int[] a = {13,13,0,5,4,3,0,1,9,12,6,4,5,4,0,2,11,12,9,10,0,6,7,8,9,11,5,3};
        C41Graph g = new C41Graph(a);
        C41HasPath dfs = new C41HasPath(g,0);
        System.out.println(dfs.pathTo(3));
    }
}
