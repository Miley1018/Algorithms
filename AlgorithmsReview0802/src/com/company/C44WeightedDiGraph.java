package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/17/17.
 */
public class C44WeightedDiGraph {
    private int V;
    private int E;
    private List<C44WeightedDiEdge>[] adj;
    public C44WeightedDiGraph(String[] a){
        V = Integer.parseInt(a[0]);
        adj = new ArrayList[V];
        for (int i = 0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
        int E = Integer.parseInt(a[1]);
        for (int i = 2; i<a.length; i = i+3){
            int v = Integer.parseInt(a[i]);
            int w = Integer.parseInt(a[i+1]);
            double wei = Double.parseDouble(a[i+2]);
            addEdge(new C44WeightedDiEdge(v,w,wei));
        }
    }
    public void addEdge(C44WeightedDiEdge e){
        int v = e.from();
        adj[v].add(e);
        E++;
    }
    public List<C44WeightedDiEdge> adj(int v){
        return adj[v];
    }
    public String toString(){
        String s = "";
        for (int i = 0; i<V;i++){
            for (C44WeightedDiEdge e:adj[i]){
                int w = e.to();
                s+=i+"-"+w+":"+e.weight()+"\n";
            }
        }
        return s;
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public List<C44WeightedDiEdge> edges(){
        List<C44WeightedDiEdge> list = new ArrayList<>();
        for (int i  =0 ; i<V;i++){
            list.addAll(adj[i]);
        }
        return list;
    }
}
