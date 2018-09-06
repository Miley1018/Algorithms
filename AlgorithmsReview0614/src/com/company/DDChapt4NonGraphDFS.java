package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/27/17.
 */
public class DDChapt4NonGraphDFS {
    private boolean[] marked;
    private int[] pathTo;
    private final int s;
    public DDChapt4NonGraphDFS(DDChapt4NonGraph graph, int v){
        marked = new boolean[graph.V()];
        s = v;
        pathTo = new int[graph.V()];
       dfs(graph,v);
    }
    private void dfs(DDChapt4NonGraph graph,int v){
        marked[v] = true;
        for (int w:graph.adj(v)){
            if (!marked[w]){
                pathTo[w] = v;
                dfs(graph,w);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public List<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = v; i!=s; i = pathTo[i]){
            list.add(i);
        }
        list.add(s);
        return list;
    }
    public static void  main(String[] args){
        String g = "13 13 0 5 4 3 0 1 9 12 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        DDChapt4NonGraph graph = new DDChapt4NonGraph(a);
        DDChapt4NonGraphDFS search = new DDChapt4NonGraphDFS(graph,0);
        System.out.println(search.pathTo(9));
    }
}
