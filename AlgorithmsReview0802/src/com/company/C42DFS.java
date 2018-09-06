package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/14/17.
 */
public class C42DFS {
    private boolean[] marked;
    public C42DFS(C42DiGraph g, List<Integer> sources){
        marked = new boolean[g.V()];
        for (int i:sources){
            if (!marked[i]){
               dfs(g,i);
            }
        }
    }
    private void dfs(C42DiGraph g, int v){
        marked[v] = true;
        for (int i:g.adj(v)){
            if (!marked[i]){
                dfs(g,i);
            }
        }
    }
    public boolean marked(int v){
        return marked[v];
    }
    public static void main(String[] args){
        int[] a  = {13,22,4,2,2, 3,
                3, 2,
                6, 0,
                0, 1,
                2, 0,
                11, 12,
                12, 9,
                9 ,10,
                9 ,11,
                8 ,9,
                10 ,12,
                11 ,4,
                4 ,3,
                3 ,5,
                7 ,8,
                8 ,7,
                5 ,4,
                0 ,5,
                6 ,4,
                6 ,9,
                7 ,6};
        C42DiGraph dg = new C42DiGraph(a);
        List<Integer> aa = new ArrayList<>();
        aa.add(0);
        aa.add(6);
        C42DFS dfs = new C42DFS(dg,aa);  System.out.println(dg);
        System.out.println(dfs.marked(8));
    }
}
