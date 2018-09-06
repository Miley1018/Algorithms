package com.company;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/16/17.
 */
public class DirectedBreadthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public DirectedBreadthFirstPath(DiGraph diGraph, int s){
        marked = new boolean[diGraph.V()];
        this.s = s;
        edgeTo = new int[diGraph.V()];
        bfs(diGraph,s);
    }
    public void bfs(DiGraph diGraph, int v){
        Queue<Integer> queue = new Queue<>();
        marked[v] = true;
        queue.enqueue(v);
        while(!queue.isEmpty()){
            int now = queue.dequeue();
            for (int w: diGraph.adj(now)){
                if (!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = now;
                    queue.enqueue(w);
                }
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v] == true;
    }
    public List<Integer> pathTo(int v){
        List<Integer> list = new ArrayList<>();
        for (int i = v; i !=s; i= edgeTo[i]){
            list.add(i);
        }
        list.add(s);
        return list;
    }
    public static void main(String[] args){
        DiGraph diGraph = new DiGraph(new In(args[0]));
        DirectedBreadthFirstPath bfsDi = new DirectedBreadthFirstPath(diGraph,0);
        System.out.println(bfsDi.pathTo(3));
    }
}
