package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/29/17.
 */
public class DDChapt4DiWeightedGraph {
    private int V;
    private int E;
    private List<DDChapt4DiWeightedEdge>[] adj;
    public DDChapt4DiWeightedGraph(String[] s ){
        V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        adj = new List[V];
        for (int i = 0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 2; i<s.length;i++){
            int v = Integer.parseInt(s[i]);
            int w = Integer.parseInt(s[i+1]);
            double weight =Double.valueOf(s[i+2]);
            addEdge(new DDChapt4DiWeightedEdge(v,w,weight));
            i+=2;
        }
    }
    public DDChapt4DiWeightedGraph(int V){
        this.V = V;
        adj = new List[V];
        for (int i = 0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public String toString(){
        String s = "";
        for (int i = 0; i<V;i++){
            s+=i+":";
            for (DDChapt4DiWeightedEdge e:adj(i)){
                s+=e+" ";
            }
            s+="\n";
        }
        return s;
    }
    public void addEdge(DDChapt4DiWeightedEdge edge){
        int from = edge.from();
        adj[from].add(edge);
        E++;
    }
    public List<DDChapt4DiWeightedEdge> edges(){
        List<DDChapt4DiWeightedEdge> list = new ArrayList<>();
        for (int i = 0; i<V;i++){
            for (DDChapt4DiWeightedEdge e:adj(i)){
               list.add(e);
            }
        }
        return list;
    }
    public List<DDChapt4DiWeightedEdge> adj(int v){
        return adj[v];
    }
    public int E(){
        return E;
    }
    public int V(){
        return V;
    }
}
