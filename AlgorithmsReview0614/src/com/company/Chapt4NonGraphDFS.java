package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/22/17.
 */
public class Chapt4NonGraphDFS {
    private int cnt;
    private boolean[] marked;
    private int[] pathTo;
    private final int s;
    public Chapt4NonGraphDFS(Chapt4NonGraph graph, int s){
        this.s = s;
        marked = new boolean[graph.V()];
        pathTo = new int[graph.V()];
        for (int i = 0; i<graph.V();i++){
            pathTo[i] = -1;
        }
        dfs(graph,s,s);
    }
    private void dfs(Chapt4NonGraph graph, int v,int before){
        if (marked[v]){
            return;
        }
        marked[v] = true;
        pathTo[v]=before;
        cnt++;
        for (int w: graph.adj(v)){
            dfs(graph,w,v);
        }
    }
    public int count(){
        return cnt;
    }
    public boolean hasPathTo(int v){
        return connected(v);
    }
    public List<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int vTo = pathTo[v];
        while (vTo!=s){
            list.add(vTo);

            vTo = pathTo[vTo];
        }
        list.add(vTo);
        return list;
    }
    public boolean connected(int v){
        return marked[v]!=false;
    }
    public static void  main(String[] args){
        String g = "13 13 0 5 4 3 0 1 9 12 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        Chapt4NonGraph graph = new Chapt4NonGraph(a);
        Chapt4NonGraphDFS search = new Chapt4NonGraphDFS(graph,0);
        System.out.println(search.count());
    }
}
