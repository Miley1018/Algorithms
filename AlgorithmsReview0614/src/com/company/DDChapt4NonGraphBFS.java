package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/27/17.
 */
public class DDChapt4NonGraphBFS {
    private final int s;
    private boolean[] marked;
    private int[] pathTo;
    public DDChapt4NonGraphBFS(DDChapt4NonGraph graph, int v){
        s = v;
        marked = new boolean[graph.V()];
        pathTo = new int[graph.V()];
        marked[v] = true;
        pathTo[v] = v;
        bfs(graph,v);
    }
    private void bfs(DDChapt4NonGraph graph, int v){
        List<Integer> list = new ArrayList<>();
        list.add(v);
        while (list.size()!=0) {
            int t = list.get(0);
            System.out.println(t);
            list.remove(0);
            for (int w : graph.adj(t)){
                if (!marked[w]) {
                    marked[w] = true;
                    pathTo[w] = t;
                    System.out.println(w+"---"+t);
                    list.add(w);
                }
            }
        }
    }
    public List<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = v; i!=s; i = pathTo[i]){
            list.add(i);
        }
        list.add(s);
        return list;
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public static void  main(String[] args){
        String g = "13 13 0 5 4 3 0 1 9 12 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        DDChapt4NonGraph graph = new DDChapt4NonGraph(a);
        DDChapt4NonGraphBFS search = new DDChapt4NonGraphBFS(graph,0);
        System.out.println(search.pathTo(3));
    }
}
