package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by mileygao on 6/23/17.
 */
public class Chapt4DiGraph {
    private int E;
    private int V;
    private List<Integer>[] adj;
    public Chapt4DiGraph(int V){
        this.V= V;
        E = 0;
        adj = new List[V];
        for (int i = 0; i<V; i++){
            adj[i] = new ArrayList<>();
        }
    }
    public Chapt4DiGraph(String[] s){
        this.V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        adj = new List[V];
        for (int i = 0; i<V; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 2; i<s.length;i+=2){
            int v = Integer.parseInt(s[i]);
            int w = Integer.parseInt(s[i+1]);
            addEdge(v,w);
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
        String s ="";
        for (int i = 0; i<V;i++){
            s+=i+": ";
            for (int w:adj(i)){
                s+=w+" ";
            }
            s+="\n";
        }
        return s;
    }
    public Chapt4DiGraph reverse(){
        Chapt4DiGraph g = new Chapt4DiGraph(V);
        for (int i = 0; i<V;i++){
            for (int w:adj(i)){
                g.addEdge(i,w);
            }
        }
        return g;
    }
    public int E(){
        return E;
    }
    public int V(){
        return V;
    }
}
