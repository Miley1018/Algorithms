package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/14/17.
 */
public class C42DiGraph {
    private List<Integer>[] adj;
    private int V;
    private int E;
    public C42DiGraph(int v){
        V = v;
        adj = new List[v];
        for (int i = 0; i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public C42DiGraph(int[] a){
        V = a[0];
        int E = a[1];
        adj = new List[V];
        for (int i = 0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 2; i<a.length;i=i+2){
            int p = a[i];
            int q = a[i+1];
            addEdge(p,q);
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public List<Integer> adj(int v){
        return adj[v];
    }
    public void addEdge(int i, int j){
        adj[i].add(j);
        E++;
    }
    public C42DiGraph reverse(){
        C42DiGraph g = new C42DiGraph(V);
        for (int i = 0; i<V;i++){
            for (int j:adj[i]){
                g.addEdge(j,i);
            }
        }
        return g;
    }
    public String toString(){
        String s = "";
        for (int i = 0; i<V;i++){
            s+=i+": ";
            for (int j: adj[i]){
                s+=j+" ";
            }
            s+="\n";
        }
        return s;
    }
}
