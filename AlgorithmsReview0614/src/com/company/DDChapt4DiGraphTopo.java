package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/28/17.
 */
public class DDChapt4DiGraphTopo {
    private boolean[] marked;
    private List<Integer> list;
    public DDChapt4DiGraphTopo(DDChapt4DiGraph graph){
        DDChapt4DIGraphCycle cy = new DDChapt4DIGraphCycle(graph);
        if (cy.hasCycle()){
            return;
        }
        list = new ArrayList<>();
        marked = new boolean[graph.V()];
        for (int i = 0; i<graph.V();i++){
            if (!marked[i]){
                dfs(graph,i);
            }
        }
    }
    private void dfs(DDChapt4DiGraph graph, int v){
        marked[v] = true;
        for (int w:graph.adj(v)){
            if (!marked[w]){
                dfs(graph,w);
            }
        }
        list.add(v);
    }
    public List<Integer> topoOrder(){
        return list;
    }
    public static void main(String[] args){
        String s ="13 22 4 2 3 2 6 0 0 1 11 12 9 10 9 11 8 9 10 12 11 4 4 3 8 7 5 4 0 5 6 4 6 9 7 6 ";
        String[] a = s.split(" ");
        DDChapt4DiGraph graph = new DDChapt4DiGraph(a);
        DDChapt4DiGraphTopo dfs = new DDChapt4DiGraphTopo(graph);
        System.out.println(dfs.topoOrder());
    }
}
