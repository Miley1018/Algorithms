package com.company;

import java.util.Stack;

/**
 * Created by mileygao on 5/22/17.
 */
public class SPWeightedDiGraphTopo {
    private Stack<Integer> topo;
    private boolean[] marked;
    public SPWeightedDiGraphTopo(SPWeightedDiGraph graph){
        topo = new Stack<>();
        marked = new boolean[graph.V()];
        for (int i = 0; i <graph.V(); i ++){
            if (!marked[i]){
                dfs(graph,i);
            }
        }
    }
    public void dfs(SPWeightedDiGraph graph, int v){
        marked[v] = true;
        for (SPWeightedDiEdge e: graph.adj(v)){
            int w = e.to();
            if (!marked[w]){
                dfs(graph,w);
            }
        }
        topo.add(v);
    }
    public Stack<Integer> topoOrder(){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        tmp.addAll(topo);
        while(!tmp.isEmpty()){
            stack.add(tmp.pop());
        }

        return stack;
    }
}
