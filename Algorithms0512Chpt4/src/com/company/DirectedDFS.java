package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mileygao on 5/16/17.
 */
public class DirectedDFS {
    private boolean[] marked;
    private int V;
    private int E;
    private int[] edgeTo;
    private int s;
    private DirectedDFS[] all;
    private DiGraph diGraph;
    public DirectedDFS(DiGraph diGraph, int s){
        this.diGraph = diGraph;
        V= diGraph.V();
        E = diGraph.E();
        this.s = s;
        marked = new boolean[V];
        edgeTo = new int[V];
        all = new DirectedDFS[V];
        dfs(diGraph,s);
    }

    public DirectedDFS(DiGraph diGraph, int[] sources){
        V = diGraph.V();
        E = diGraph.E();
        marked = new boolean[V];
        edgeTo = new int[V];
        for (int i : sources){
            if (!marked(i)) {
                dfs(diGraph, i);
            }
        }
    }
    public boolean marked(int v){
        return marked[v];
    }
    public void dfs(DiGraph diGraph, int v){
        marked[v] = true;
        for (int w: diGraph.adj(v)){
            if (!marked(w)){
                edgeTo[w] = v;
                dfs(diGraph,w);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked(v);
    }
    public Stack<Integer> pathTo(int v){
        if (!hasPathTo(v)){
           return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]){
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }
    public boolean reachable(int v, int w){ //-----------------------任意两顶点间的可达性
        for (int i =0; i <V; i++){
            all[i] = new DirectedDFS(diGraph,i);
        }
        return all[v].marked[w];
    }

    public List<Integer> connectTo(DiGraph diGraph, int[] s){
        DirectedDFS directedDFS1 = new DirectedDFS(diGraph,s);
        List<Integer> list = new ArrayList<>();
        for (int i =0; i <V;i++){
            if (directedDFS1.marked(i)){
                list.add(i);
            }
        }
        return list;
    }
    public static void main(String[] args){
        DiGraph diGraph = new DiGraph(new In(args[0]));
        DirectedDFS directedDFS = new DirectedDFS(diGraph, 0);
        System.out.println(directedDFS.marked(6));
        int[] i = {0};
        System.out.println(directedDFS.hasPathTo(2)+" "+directedDFS.pathTo(3));
        System.out.println(directedDFS.connectTo(diGraph,i));
        System.out.println(directedDFS.reachable(1,0));
    }
}
