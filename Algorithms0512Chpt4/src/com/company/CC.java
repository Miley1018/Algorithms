package com.company;

import edu.princeton.cs.algs4.In;

/**
 * Created by mileygao on 5/12/17.
 */
public class CC {
    private int count;
    private int[] id;
    private boolean[] marked;
    private boolean hasCycle;
    private boolean isTwoColor;
    private boolean[] color;
    public CC(Graph graph, int N){
        hasCycle = false;
        isTwoColor = true;
        color = new boolean[graph.V()];
        marked = new boolean[graph.V()];
        count = 0;
        id = new int[N];
        for (int v = 0; v < graph.V(); v++){
            if (!marked[v]){
                count++;
                dfs(graph,v,v);
            }
        }
    }
    public void dfs(Graph graph, int v, int t){
        marked[v] = true;
        id[v] = count;
        for (int w: graph.adj(v)){
            if (!marked[w]){
                color[w]=!color[v];
                dfs(graph,w,v);
            }else {
                if (w != t) {
                    hasCycle = true;
                }
                if (color[w] == color[v]) {
                    isTwoColor = false;
                }
            }
        }
    }
    public boolean hasCycle(){
        return hasCycle;
    }
    public boolean connected(int v, int w){
        return id[v] == id[w];
    }
    public int getCount(){
        return count;
    }
    public static void main(String[] args){
        Graph graph = new Graph(new In(args[0]));
        CC cc = new CC(graph,graph.V());
        System.out.println(cc.count+" "+ cc.hasCycle+" "+cc.isTwoColor);
    }
}
