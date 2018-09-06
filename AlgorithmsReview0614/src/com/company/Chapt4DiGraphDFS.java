package com.company;


/**
 * Created by mileygao on 6/23/17.
 */
public class Chapt4DiGraphDFS {
    private boolean[] marked;
    public Chapt4DiGraphDFS(Chapt4DiGraph graph, int s){
        marked = new boolean[graph.V()];
        dfs(graph,s);
    }
    public Chapt4DiGraphDFS(Chapt4DiGraph graph, int[] sources){
        marked = new boolean[graph.V()];
        for (int v:sources){
            if (!marked[v]){
                dfs(graph,v);
            }
        }
    }
    private void dfs(Chapt4DiGraph graph, int v){
        marked[v] = true;
        for (int w:graph.adj(v)){
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }
    public boolean connected(int v){
        return marked[v];
    }
    public static void main(String[] args){
        String s ="13 22 4 2 2 3 3 2 6 0 0 1 2 0 11 12 12 9 9 10 9 11 8 9 10 12 11 4 4 3 3 5 7 8 8 7 5 4 0 5 6 4 6 9 7 6 ";
        String[] a = s.split(" ");
        Chapt4DiGraph graph = new Chapt4DiGraph(a);
        Chapt4DiGraphDFS dfs = new Chapt4DiGraphDFS(graph,0);
        System.out.println(dfs.connected(3));
    }
}
