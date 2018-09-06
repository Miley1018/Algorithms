package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/28/17.
 */
public class DDChapt4DiGraph {
    private int V;
    private int E;
    private List<Integer>[] adj;
    public DDChapt4DiGraph(String[] s){
        V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        adj = new List[V];
        for (int i = 0; i<V; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 2; i<s.length;i++){
            int v = Integer.parseInt(s[i]);
            int w = Integer.parseInt(s[i+1]);
            addEdge(v,w);
            i = i+1;
        }
    }
    public DDChapt4DiGraph(int v){
        V = v;
        adj = new List[V];
        for (int i = 0; i<V; i++){
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
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public String toString(){
        String s = "";
        for (int i = 0; i<V;i++){
            s+=i+":";
            for (int w:adj(i)){
                s+=w+" ";
            }
            s+="\n";
        }
        return s;
    }
    public DDChapt4DiGraph reverse(DDChapt4DiGraph graph){
        DDChapt4DiGraph reverse = new DDChapt4DiGraph(graph.V());
        for (int i = 0; i<graph.V();i++){
            for (int w:graph.adj(i)){
                reverse.addEdge(w,i);
            }
        }
        return reverse;
    }
}
