package com.company;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

import java.util.List;
import java.util.Stack;

/**
 * Created by mileygao on 5/16/17.
 */
public class DirectedCycleAndTopo {
    private boolean[] marked;
    private boolean[] onstack;
    private boolean hasCycle;
    private Stack<Integer> stack;
    private Stack<Integer> topoStack;
    private int[] edgeTo;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    public DirectedCycleAndTopo(DiGraph diGraph){
        marked = new boolean[diGraph.V()];
        edgeTo = new int[diGraph.V()];
        onstack = new boolean[diGraph.V()];
        stack= new Stack<>();
        topoStack = new Stack<>();
        pre = new Queue<>();
        post = new Queue<>();
        for(int i =0; i < diGraph.V(); i++){
            if (!marked[i]){
                dfs(diGraph,i);
            }
        }
    }
    public void dfs(DiGraph diGraph, int v){
        //System.out.println(v);
        marked[v] = true;
        onstack[v] = true;
        pre.enqueue(v);
        for (int w: diGraph.adj(v)){
            //if (hasCycle){
             //   return;
            //}
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(diGraph,w);
            }else if (onstack[w]){
                hasCycle = true;
                for (int i = v; i !=w; i = edgeTo[i]){
                    stack.push(i);
                }
                stack.push(w);
                stack.push(v);
            }
        }
        post.enqueue(v);
        topoStack.push(v);
        onstack[v] = false;
    }
    public List<Integer> cycle(){
        if (!hasCycle){
            return null;
        }
        return stack;
    }
    public Stack<Integer> topo(){
        if (hasCycle){
          return null;
        }
        //for (int i : topoStack){
         //       System.out.println(i);}
        return topoStack;
    }
    public static void main (String[] args){
        DiGraph diGraph = new DiGraph(new In(args[0]));
        DirectedCycleAndTopo directedCycle = new DirectedCycleAndTopo(diGraph);
        System.out.println(directedCycle.cycle());

        System.out.println(directedCycle.topo());
        Stack s = directedCycle.topo();
        while(!s.empty()){
            System.out.println(s.pop());
        }
        System.out.println(directedCycle.pre+"\n"+directedCycle.post);
    }
}
