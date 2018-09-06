package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/22/17.
 */
public class Chapt4NonGraphBFS {
    private final int s;
    private Integer[] edgeTo;
    private boolean[] marked;
    public Chapt4NonGraphBFS(Chapt4NonGraph graph,int s){
        this.s = s;
        edgeTo = new Integer[graph.V()];
        marked = new boolean[graph.V()];
        marked[s] = true;
        edgeTo[s] = s;
        bfs(graph,s,s);
    }
    private void bfs(Chapt4NonGraph graph,int v, int before){
        boolean canbreak = true;
        for (int w:graph.adj(v)){
            if (!marked[w]) {
                marked[w] = true;
                edgeTo[w] = before;
                canbreak = false;
            }
        }
        if (canbreak){
            return;
        }
        for (int w:graph.adj(v)) {
            bfs(graph, w, w);
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public List<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i = edgeTo[v];i!=s;i=edgeTo[i]){
            list.add(i);
        }
        list.add(s);
        System.out.println(list);
        return list;
    }
    public static void  main(String[] args){
        String g = "13 13 0 5 4 3 0 1 9 12 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        Chapt4NonGraph graph = new Chapt4NonGraph(a);
        Chapt4NonGraphBFS search = new Chapt4NonGraphBFS(graph,0);
        System.out.println(search.pathTo(4));
    }
}
