package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/29/17.
 */
public class DDChapt4NonWeightedGraph {
    private int V;
    private int E;
    private List<DDChapt4NonWeightedEdge>[] adj;
    public DDChapt4NonWeightedGraph(int V){
        this.V =V;
        adj = new List[V];
        for (int i = 0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public DDChapt4NonWeightedGraph(String[] s){
        V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        adj = new List[V];
        for (int i = 0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 2; i<s.length;i++){
            int v = Integer.parseInt(s[i]);
            int w = Integer.parseInt(s[i+1]);
            double weight = Double.valueOf(s[i+2]);
            addedge(new DDChapt4NonWeightedEdge(v,w,weight));
            i = i+2;
        }
    }
    public List<DDChapt4NonWeightedEdge> edges(){
        List<DDChapt4NonWeightedEdge> list = new ArrayList<>();
        for (int i = 0; i<V();i++){
            for (DDChapt4NonWeightedEdge e:adj(i)){
                int theother = e.theOther(i);
                if (theother>i){
                    list.add(e);
                }
            }
        }
        return list;
    }
    public String toString(){
        String s = "" ;
        for (int i = 0; i<V;i++){
            s+=i+":";
            for(DDChapt4NonWeightedEdge w:adj(i)){
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
    public List<DDChapt4NonWeightedEdge> adj(int v){
        return adj[v];
    }
    public void addedge(DDChapt4NonWeightedEdge e){
        int one = e.one();
        int theother = e.theOther(one);
        adj[one].add(e);
        adj[theother].add(e);
        E++;
    }
}
