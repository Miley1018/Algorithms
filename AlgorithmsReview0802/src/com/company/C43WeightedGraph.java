package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/15/17.
 */
public class C43WeightedGraph {
    private int V;
    private int E;
    private List<C43WeightedEdge>[] adj;
    public C43WeightedGraph(String[] a){
        V = Integer.parseInt(a[0]);
        int E = Integer.parseInt(a[1]);
        adj =new ArrayList[V];
        for (int i = 0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 2; i<a.length;i=i+3){
            int v = Integer.parseInt(a[i]);
            int w = Integer.parseInt(a[i+1]);
            double wei = Double.parseDouble(a[i+2]);
          //  System.out.println("v:"+v+"w:"+w+"weight:"+wei);
            addEdge(new C43WeightedEdge(v,w,wei));
        }
    }
    public C43WeightedGraph(int v){
        this.V = v;
        adj =new ArrayList[V];
        for (int i = 0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public void addEdge(C43WeightedEdge e){
        int v = e.one();
        int w = e.theother(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    public List<C43WeightedEdge> adj(int v){
        return adj[v];
    }
    public String toString(){
        String s = "";
        for (C43WeightedEdge e:edges()){
            int v = e.one();
            s+=v+"-"+e.theother(v)+": "+e.weight()+"\n";
        }
        return s;
    }
    public List<C43WeightedEdge> edges(){
        List<C43WeightedEdge> list = new ArrayList<>();
        for (int i = 0; i<V;i++){
            for (C43WeightedEdge e:adj[i]){
                int w = e.theother(i);
                if (w>i){
                    list.add(e);
                }
            }
        }
        return list;
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
}
