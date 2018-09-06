package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/28/17.
 */
public class DDChapt4DiGraphDFS {
    private boolean[] marked;
    private int[] pathTo;
    private final int s;
    public DDChapt4DiGraphDFS(DDChapt4DiGraph graph, int v){
        s = v;
        marked = new boolean[graph.V()];
        pathTo = new int[graph.V()];
        dfs(graph,v);
    }
    private void dfs(DDChapt4DiGraph graph, int v){
        marked[v] = true;
        for (int w: graph.adj(v)){
            if(!marked[w]){
                pathTo[w] = v;
                dfs(graph,w);
            }
        }
    }
    public boolean connected(int v){
        return marked[v];
    }
    public List<Integer> pathTo(int v){
        if (!connected(v)){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i = v; i!=s;i = pathTo[i]){
            list.add(i);
        }
        list.add(s);
        return list;
    }
    public static void main(String[] args){
        String s ="13 22 4 2 2 3 3 2 6 0 0 1 2 0 11 12 12 9 9 10 9 11 8 9 10 12 11 4 4 3 3 5 7 8 8 7 5 4 0 5 6 4 6 9 7 6";
        String[] a = s.split(" ");
        DDChapt4DiGraph graph = new DDChapt4DiGraph(a);
        DDChapt4DiGraphDFS dfs = new DDChapt4DiGraphDFS(graph,12);
        System.out.println(dfs.pathTo(3));
    }
}
