package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/16/17.
 */
public class DiGraph {
    private int V;
    private int E;
    private List<Integer>[] adj;
    public DiGraph(In in){
        V = in.readInt();
        int E = in.readInt();
        adj = new ArrayList[V];
        for (int i =0; i <V; i ++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i <E; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }
    public DiGraph(int V){
        this.V = V;
        adj = new ArrayList[V];
        for (int i =0; i <V; i ++){
            adj[i] = new ArrayList<>();
        }

    }
    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }
    public List<Integer> adj(int v){
        return adj[v];
    }
    public String toString(){
        String s = "V:" + V + " E:" + E+"\n";
        for (int i=0; i<V; i++){
            s+=i+": ";
            for (int w: adj[i]){
                s+=w+" ";
            }
            s+="\n";
        }
        return s;
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public DiGraph reverse(){
        DiGraph diGraphReverse = new DiGraph(V);
        for (int i = 0; i < V; i++){
            for (int w: adj[i]){
                diGraphReverse.adj[w].add(i);           //----------no diGraph?
                diGraphReverse.E++;
            }
        }
        return diGraphReverse;
    }
    public static void main(String[] args){
        DiGraph diGraph = new DiGraph(new In(args[0]));
        System.out.println(diGraph);
        System.out.println(diGraph.reverse());
    }
}
