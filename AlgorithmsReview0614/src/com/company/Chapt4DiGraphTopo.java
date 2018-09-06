package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mileygao on 6/23/17.
 */
public class Chapt4DiGraphTopo {
    private boolean[] marked;
    private Stack<Integer> stack;
    private boolean hasCycle;
    public Chapt4DiGraphTopo(Chapt4DiGraph graph){
        Chapt4DiGraphCycle cycle = new Chapt4DiGraphCycle(graph);
        if (cycle.hasCycle()){
            hasCycle = true;
            return;
        }
        stack = new Stack<>();
        marked = new boolean[graph.V()];
        for (int i = 0; i<graph.V();i++) {
            if (!marked[i]) {
                back(graph, i);
            }
        }
    }
    private void back(Chapt4DiGraph graph, int v){
        marked[v] = true;
        for (int w:graph.adj(v)){
            if (!marked[w]){
                back(graph,w);
            }
        }
        stack.push(v);
    }
    public boolean hasCycle(){
        return hasCycle;
    }
    public List<Integer> topoOrder(){
        List<Integer> list = new ArrayList<>();
        if (stack == null){
            return null;
        }
        for(int t:stack){
            System.out.println(t);
        }
        while (!stack.isEmpty()){
            int i = stack.pop();
            list.add(i);
        }
        return list;
    }
    public static void main(String[] args){
        String s ="13 22 4 2 3 2 6 0 0 1 11 12 9 10 9 11 8 9 10 12 11 4 4 3 8 7 5 4 0 5 6 4 6 9 7 6 ";
        String[] a = s.split(" ");
        Chapt4DiGraph graph = new Chapt4DiGraph(a);
        Chapt4DiGraphTopo dfs = new Chapt4DiGraphTopo(graph);
        System.out.println(dfs.topoOrder());
    }
}
