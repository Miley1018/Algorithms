package com.company;

import edu.princeton.cs.algs4.In;

import java.util.Stack;


/**
 * Created by mileygao on 5/17/17.
 */
public class DirectedStronglyCC {
    private int count;
    private DiGraph reverseG;
    private boolean[] marked;
    private int[] id;
    public DirectedStronglyCC(DiGraph diGraph){
        reverseG= diGraph.reverse();
        marked = new boolean[diGraph.V()];
        id = new int[diGraph.V()];
        DirectedCycleAndTopo order = new DirectedCycleAndTopo(reverseG);
        Stack<Integer> n = order.topo();
        //System.out.println(n);
        while (!n.isEmpty()){
            int i =n.pop();
            if (!marked[i]){
                count++;
                System.out.println("start:"+count);
                dfs(diGraph,i);
            }
        }
    }
    public void dfs(DiGraph diGraph, int v){
        System.out.println("v:"+v);
        marked[v] = true;
        id[v] = count;
        for (int w: diGraph.adj(v)){
            //System.out.println(w+" "+v);
            if (!marked[w]){
                dfs(diGraph,w);
            }
        }
    }
    public boolean stronglyCC(int v, int w){
        return id[v] == id[w];
    }
    public int getCount(){
        for(int i:id){
            System.out.println(i);
        }
        return count;
    }
    public static void main(String[] args){
        DiGraph diGraph = new DiGraph(new In(args[0]));
        DirectedStronglyCC diCC = new DirectedStronglyCC(diGraph);
        System.out.println(diCC.stronglyCC(9,12)+"how many cc: " +diCC.getCount());
    }
}
