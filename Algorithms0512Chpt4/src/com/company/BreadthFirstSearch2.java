package com.company;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/15/17.
 */
public class BreadthFirstSearch2 {
    private int V;
    private int E;
    private final int s;
    private boolean[] marked;
    private int[] edgeTo;
    Queue<Integer> queue;
    public BreadthFirstSearch2(Graph2 graph2, int s){
        this.s = s;
        V = graph2.V();
        E = graph2.E();
        edgeTo = new int[V];
        marked = new boolean[V];
        queue  = new Queue<>();
        bfs(graph2,s);
    }
    public void bfs(Graph2 graph, int v){
        marked[v] = true;
        for (int w: graph.adj(v)){
            if (!marked[w]){
                marked[w] = true;
                edgeTo[w] = v;
                queue.enqueue(w);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.dequeue();
            bfs(graph, now);
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
        for (int i= v; i != s; i = edgeTo[i]){
            list.add(i);
        }
        list.add(s);
        return list;
    }

    public static void main(String[] args){
        Graph2 graph2 = new Graph2(new In(args[0]));
        BreadthFirstSearch2 bfp2 = new BreadthFirstSearch2(graph2, 0);
        System.out.println(bfp2.pathTo(4));
    }
}
