package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/28/17.
 */
public class DDChapt4DIGraphCycle {
    private boolean has = false;
    private List<Integer> onstack;
    private boolean[] marked;
    private List<Integer> cycle;
    public DDChapt4DIGraphCycle(DDChapt4DiGraph graph){
        onstack = new ArrayList<>();
        marked = new boolean[graph.V()];
        cycle = new ArrayList<>();
        for (int i = 0; i<graph.V();i++){
            if (!marked[i]){
                onstack.add(i);
                dfs(graph,i);
            }
        }
    }
    private void  dfs(DDChapt4DiGraph graph, int v){
        marked[v] = true;
        for (int w:graph.adj(v)){
            if(has){
                return;
            }
            if (!marked[w]){
                onstack.add(w);
                dfs(graph,w);
            }else if (onstack.contains(w)){
                has = true;
                int t = v;
                int index = 0;
                while(t!=w){
                    int m = onstack.get(onstack.size()-1-index);
                    index++;
                    cycle.add(m);
                    t = onstack.get(onstack.size()-1-index);
                }
                cycle.add(w);
                break;
            }
        }
        onstack.remove(onstack.size()-1);
    }
    public boolean hasCycle(){
        return has;
    }
    public List<Integer> cycle(){
        return cycle;
    }
    public static void main(String[] args){
        String s="13 22 4 2 2 3 3 2 6 0 0 1 2 0 11 12 12 9 9 10 9 11 8 9 10 12 11 4 4 3 3 5 7 8 8 7 5 4 0 5 6 4 6 9 7 6 ";
        String[] a = s.split(" ");
        DDChapt4DiGraph graph = new DDChapt4DiGraph(a);
        DDChapt4DIGraphCycle dfs = new DDChapt4DIGraphCycle(graph);
        System.out.println(dfs.cycle());
    }
}
