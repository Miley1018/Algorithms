package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/17/17.
 */
public class MSTEdgeWeightedGraph {
    private int V;
    private int E;
    private List<MSTEdge>[] adj;
    public MSTEdgeWeightedGraph(In in){
        V = in.readInt();
        int E = in.readInt();
        adj = new List[V];
        for (int i = 0; i <V; i ++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i <E; i ++){
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            MSTEdge edge = new MSTEdge(v,w,weight);
            addEdge(edge);
        }

    }
    public MSTEdgeWeightedGraph(int V){
        this.V = V;
        adj = new List[V];
        for (int i = 0; i <V; i ++){
            adj[i] = new ArrayList<>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(MSTEdge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
   public List<MSTEdge> adj(int v){
        return adj[v];
    }
    public List<MSTEdge> edges(){
       List<MSTEdge>  list = new ArrayList<>();
        for (int i =0; i <V; i++){
            for (MSTEdge e : adj[i]){
                int w = e.other(i);
                if (w>i){
                    list.add(e);
                }
            }
        }
        return list;
    }
    public String toString(){
        String s = "V:" +V +"E:"+E+"\n";
        for (MSTEdge e: edges()){
            int v = e.either();
            int w =e.other(v);
            s+=v+" "+ w+" "+e.weight()+"\n";
        }
        return s;
    }
}
