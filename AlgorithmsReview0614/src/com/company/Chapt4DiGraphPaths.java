package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/23/17.
 */
public class Chapt4DiGraphPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int start;
    public Chapt4DiGraphPaths(Chapt4DiGraph graph, int s){
        start = s;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        dfs(graph,s);
    }
    private void dfs(Chapt4DiGraph graph,int v){
        marked[v] = true;
        for (int w : graph.adj(v)){
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(graph,w);
            }
        }
    }
    public List<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = v; i!=start;i = edgeTo[i]){
            list.add(i);
        }
        list.add(start);
        return list;
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public static void main(String[] args){
        String s ="13 22 4 2 2 3 3 2 6 0 0 1 2 0 11 12 12 9 9 10 9 11 8 9 10 12 11 4 4 3 3 5 7 8 8 7 5 4 0 5 6 4 6 9 7 6 ";
        String[] a = s.split(" ");
        Chapt4DiGraph graph = new Chapt4DiGraph(a);
        Chapt4DiGraphPaths dfs = new Chapt4DiGraphPaths(graph,6);
        System.out.println(dfs.pathTo(2));
    }
}
