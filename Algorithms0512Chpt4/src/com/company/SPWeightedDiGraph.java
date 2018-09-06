package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/19/17.
 */
public class SPWeightedDiGraph {
    private int V;
    private int E;
    private List<SPWeightedDiEdge>[] adj;
    public SPWeightedDiGraph(In in){
        this.V = in.readInt();
        int E = in.readInt();
        adj = new ArrayList[V];
        for (int i = 0; i <V; i ++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i<E; i ++){
            int v = in.readInt();
            int w = in.readInt();
            double weight  = in.readDouble();
            SPWeightedDiEdge e = new SPWeightedDiEdge(v,w,weight);
            addEdge(e);
        }
    }
    public SPWeightedDiGraph(int V){
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i <V; i++){
            adj[i] = new ArrayList<>();
        }
    }
    public void addEdge(SPWeightedDiEdge e){
        adj[e.from()].add(e);
        E++;
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public List<SPWeightedDiEdge> adj(int v){
        return adj[v];
    }
    public List<SPWeightedDiEdge> edges(){
        List<SPWeightedDiEdge> list = new ArrayList<>();
        for (int i = 0; i <V; i ++){
            for (SPWeightedDiEdge e: adj[i]){
                list.add(e);
            }
        }
        return list;
    }
}
