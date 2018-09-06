package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mileygao on 6/23/17.
 */
public class Chapt4DiGraphShortestPath {
    private final int start;
    private boolean[] marked;
    private int[] edgeTo;
    public Chapt4DiGraphShortestPath(Chapt4DiGraph graph,int s){
        start = s;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        marked[s] = true;
        edgeTo[s] = s;
        bfs(graph,s);

    }
    private void bfs(Chapt4DiGraph graph,int v){
        List<Integer> queue = new ArrayList<>();
        queue.add(v);
        while (!queue.isEmpty()){
            int now = queue.get(0);
            queue.remove(0);
            for (int w:graph.adj(now)){
                if (!marked[w]){

                    marked[w] = true;
                    edgeTo[w] = now;
                    System.out.println(w+" "+v);
                    queue.add(w);
                }
            }
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
        for (int i = v; i!=start;i=edgeTo[i]){
            list.add(i);
        }
        list.add(start);
        return list;
    }
    public static void main(String[] args){
        String s ="13 22 4 2 2 3 3 2 6 0 0 1 2 0 11 12 12 9 9 10 9 11 8 9 10 12 11 4 4 3 3 5 7 8 8 7 5 4 0 5 6 4 6 9 7 6 ";
        String[] a = s.split(" ");
        Chapt4DiGraph graph = new Chapt4DiGraph(a);
        Chapt4DiGraphShortestPath dfs = new Chapt4DiGraphShortestPath(graph,6);
        System.out.println(dfs.pathTo(2));
    }
}
