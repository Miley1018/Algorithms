package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mileygao on 8/15/17.
 */
public class C42Topo {
    private Stack<Integer> stack;
    private boolean[] marked;
    private List<Integer> list = new ArrayList<>();
    public C42Topo(C42DiGraph g){
        C42HasCycle cy = new C42HasCycle(g);
        marked = new boolean[g.V()];
        stack = new Stack<>();
        if (!cy.hasCycle()){
            for (int i = 0; i<g.V();i++){
                if (!marked[i]){
                    dfs(g,i);
                }
            }
        }
    }
    private void dfs(C42DiGraph g, int v){
        if(marked[v]){
            return;
        }
        marked[v] = true;
        stack.push(v);
        for (int i:g.adj(v)){
            if (!marked[i]){
                dfs(g,i);
            }
        }
        list.add(stack.pop());
    }
    public List<Integer> topo(){
        return list;
    }
    public static void main(String[] args){
        int[] a  = {13,15,0,1,0,6,0,5,5,4,3,5,2,3,2,0,6,4,7,6,8,7,6,9,9,10,9,12,9,11,11,12};
        C42DiGraph dg = new C42DiGraph(a);
        C42Topo topo = new C42Topo(dg);
        List<Integer> aa = new ArrayList<>();
        String t = "ewew";
        String[] aaa= t.split("");
        String.join("",aaa);
        System.out.println(topo.topo());
    }
}
