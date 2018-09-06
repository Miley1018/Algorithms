package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/28/17.
 */
public class DDChapt4DiGraphBFS {
    private final int s;
    private boolean[] marked;
    private int[] pathTo;
    public DDChapt4DiGraphBFS(DDChapt4DiGraph graph,int v){
        s = v;
        marked = new boolean[graph.V()];
        pathTo = new int[graph.V()];
        pathTo[v] = v;
        marked[v] =true;
        bfs(graph,v);
    }
    private void bfs(DDChapt4DiGraph graph, int v){
        List<Integer> list = new ArrayList<>();
        list.add(v);
        while (list.size()!=0){
            int t = list.get(0);
            list.remove(0);
            for (int w:graph.adj(t)){
                if (!marked[w]){
                    pathTo[w] = t;
                    marked[w] = true;
                    list.add(w);
                }
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public List<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = v; i!=s;i = pathTo[i]){
            list.add(i);
        }
        list.add(s);
        return list;
    }
    public static void main(String[] args){
        String s ="13 22 4 2 2 3 3 2 6 0 0 1 2 0 11 12 12 9 9 10 9 11 8 9 10 12 11 4 4 3 3 5 7 8 8 7 5 4 0 5 6 4 6 9 7 6";
        String[] a = s.split(" ");
        DDChapt4DiGraph graph = new DDChapt4DiGraph(a);
        DDChapt4DiGraphBFS dfs = new DDChapt4DiGraphBFS(graph,12);
        System.out.println(dfs.pathTo(0));
    }
}
