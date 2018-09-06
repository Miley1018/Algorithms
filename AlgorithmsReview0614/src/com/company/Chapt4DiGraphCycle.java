package com.company;

import java.util.List;
import java.util.Stack;

/**
 * Created by mileygao on 6/23/17.
 */
public class Chapt4DiGraphCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onstack;
    public Chapt4DiGraphCycle(Chapt4DiGraph graph){
        cycle  = new Stack<>();
        marked = new boolean[graph.V()];
        onstack = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        for (int i = 0; i<graph.V();i++){
            if (!marked[i]){
                dfs(graph,i);
            }
        }
    }
    private void dfs(Chapt4DiGraph graph,int v){
        marked[v] = true;
        onstack[v] = true;
        for (int w:graph.adj(v)){
            if(hasCycle()){
                return;
            }
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onstack[w]){
                for (int i = v; i!=w;i = edgeTo[i]){
                    cycle.push(i);
                }
                cycle.push(w);
                return;
            }
        }
        onstack[v] = false;
    }
    public boolean hasCycle(){
        return cycle.size()!=0;
    }
    public List<Integer> cycle(){
        return cycle;
    }
    public static void main(String[] args){
        String t ="13 22 4 2 2 3 3 2 6 0 0 1 2 0 11 12 12 9 9 10 9 11 8 9 10 12 11 4 4 3 3 5 7 8 8 7 5 4 0 5 6 4 6 9 7 6 ";
        String s ="13 22 4 2 3 2 6 0 0 1 11 12 9 10 9 11 8 9 10 12 11 4 4 3 7 8 5 4 0 5 6 4 6 9 7 6";
        String[] a = s.split(" ");
        Chapt4DiGraph graph = new Chapt4DiGraph(a);
        Chapt4DiGraphCycle dfs = new Chapt4DiGraphCycle(graph);
        System.out.println(dfs.hasCycle());
    }
}
