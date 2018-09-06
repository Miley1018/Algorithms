package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/15/17.
 */
public class CC2 {
    private boolean[] marked;
    private int V;
    private int E;
    private int count;
    private final int s;
    private int[] edgeTo;
    private int[] connected;
    private boolean[] color;
    private boolean hasCycle;
    private boolean isErfen;
    public CC2(Graph2 graph, int s){
        marked = new boolean[graph.V()];
        this.s = s;
        V = graph.V();
        E = graph.E();
        count = 0;
        edgeTo = new int[graph.V()];
        connected = new int[V];
        hasCycle = false;
        color = new boolean[V];
        for (int i =0; i < V; i ++){
            color[i] = false;
        }
        for (int i = 0; i < V; i++){
            if (!marked(i)){
                count++;
                dfs(graph,i,i);
            }
        }
    }
    public void dfs(Graph2 graph, int v, int pre){
        marked[v] = true;
        connected[v] = count;
        for (int w: graph.adj(v)){
            if (!marked[w]){
                edgeTo[w] = v;
                color[w] = !color[v];
                dfs(graph,w,v);
            }
            else {
                if (w!=pre){
                    hasCycle = true;
                }
                if(color[w] == color[v]){
                    isErfen = false;
                }
            }

        }
    }
    public boolean connected(int v, int w){
        return connected[v] == connected[w];
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
    public boolean hasCycle(){
        return hasCycle;
    }
    public static void main(String[] args){
        Graph2 graph2 = new Graph2(new In(args[0]));
        CC2 cc = new CC2(graph2, 0);
        System.out.println(cc.connected(2,5)+" "+cc.count() + " " + cc.hasCycle + " " + cc.isErfen);
    }
}
