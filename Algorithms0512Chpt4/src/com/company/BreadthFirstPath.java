package com.company;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

import java.util.Stack;

/**
 * Created by mileygao on 5/12/17.
 */
public class BreadthFirstPath {
    private Queue<Integer> queue;
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public BreadthFirstPath(Graph graph, int s){
        marked = new boolean[graph.V()];
        queue = new Queue<>();
        edgeTo = new int[graph.V()];
        this.s =s;
        bfs(graph,s);
    }
    public void bfs(Graph graph, int s){
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w: graph.adj(v)){
                if (!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v){
       if (!marked[v]){
           return null;
       }
        Stack<Integer> stack = new Stack();
       for (int x = v; x!=s; x = edgeTo[x]){
           stack.push(x);
       }
       stack.push(s);
        return stack;
    }
    public static void main(String[] args){
        Graph graph = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        BreadthFirstPath bfp = new BreadthFirstPath(graph,s);
        System.out.println(bfp.pathTo(5)+" "+ bfp.hasPathTo(4));
    }
}
