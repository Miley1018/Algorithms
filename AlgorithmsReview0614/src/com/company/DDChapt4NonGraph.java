package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/27/17.
 */
public class DDChapt4NonGraph {
    private int V;
    private int E;
    private List<Integer>[] adj;
    public DDChapt4NonGraph(int V){
        this.V= V;
        adj = new ArrayList[V];
        for (int i =0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public DDChapt4NonGraph(String[] a){
        this.V = Integer.parseInt(a[0]);
        int E = Integer.parseInt(a[1]);
        adj = new ArrayList[V];
        for (int i =0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
        int i = 2;
        while (i<a.length){
            int v = Integer.parseInt(a[i]);
            int w = Integer.parseInt(a[i+1]);
            i=i+2;
            add(v,w);
        }
    }
    public void add(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public List<Integer> adj (int v){
        return adj[v];
    }
    public String toString(){
        String s = "";
        for (int i = 0; i<V;i++){
            s+=i+":";
            for (int t:adj(i)){
                s+=t+" ";
            }
            s+="\n";
        }
        return s;
    }
    public int degree(int v){
        return adj[v].size();
    }
    public int maxdegree(){
        int max =0;
        for (int i = 0; i<V;i++){
            max = Math.max(max,adj[i].size());
        }
        return max;
    }
    public int avgdegree(){
        return E()*2/V;
    }
    public int selfloops(){
        int cnt = 0;
        for (int i = 0; i<V;i++){
            for (int v:adj(i)){
                if (v==i){
                    cnt++;
                }
            }
        }
        return cnt/2;
    }
    public static void main(String[] args){
        String g = "13 13 0 5 4 3 0 1 9 12 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        DDChapt4NonGraph graph = new DDChapt4NonGraph(a);
        System.out.println(graph.avgdegree());
    }
}
