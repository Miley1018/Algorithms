package com.company;

import edu.princeton.cs.algs4.In;

import java.util.Stack;

/**
 * Created by mileygao on 5/12/17.
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    private int[] edgeTo;
    private final int s;
    public DepthFirstSearch(Graph graph, int V, int s){
        marked = new boolean[V];
        edgeTo = new int[V];
        count = 0;
        this.s = s;
        dfs(graph,s);
    }
    public void dfs(Graph graph, int v){
        marked[v] = true;
        count++;
        for (int w: graph.adj(v)){
            if (!marked(w)){
                edgeTo[w]= v;
                dfs(graph,w);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Stack<Integer> pathTo(int v){
        if (!marked(v)){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]){
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }
    public boolean marked(int v){
        return marked[v];
    }
    public static void main(String[] args){
        Graph graph = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch dfs = new DepthFirstSearch(graph, graph.V(),s);
        System.out.println(dfs.pathTo(4));
        System.out.println(dfs.hasPathTo(3)+" "+dfs.count);
    }
}
