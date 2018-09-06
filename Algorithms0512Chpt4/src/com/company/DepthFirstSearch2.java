package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/15/17.
 */
public class DepthFirstSearch2 {
    private boolean[] marked;
    private int V;
    private int E;
    private int count;
    private final int s;
    private int[] edgeTo;
    public DepthFirstSearch2(Graph2 graph, int s){
        marked = new boolean[graph.V()];
        this.s = s;
        V = graph.V();
        E = graph.E();
        count = 0;
        edgeTo = new int[graph.V()];
        dfs(graph,s);
    }
    public void dfs(Graph2 graph, int v){
        marked[v] = true;
        count++;
        for (int w: graph.adj(v)){
            if (!marked[w]){
                edgeTo[w] = v;
               dfs(graph,w);
            }

        }
    }
    public boolean marked(int v){
        return marked[v];
    }
    public int count(){
        return count;
    }
    public boolean hasPathTo(int v){
      return marked(v);
    }
    public List<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i =v; i!=s; i = edgeTo[i]){
            list.add(i);
        }
        list.add(s);
        return list;
    }
    public static void main(String[] args){
        Graph2 graph2 = new Graph2(new In(args[0]));
        DepthFirstSearch2 dfs2 = new DepthFirstSearch2(graph2, 0);
        System.out.println(dfs2.pathTo(2) );
         List<Integer> a = new ArrayList();
         a.add(0);
        a.add(1);
        List<Integer> b = new ArrayList(a);
        b.add(3);
        for (int i: a){
            System.out.println(i+"\n");
        }
        for (int j:b){
            System.out.println(j);
        }
    }
}
