package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/22/17.
 */
public class Chapt4NonGraph {
    private int V;
    private int E;
    private List<Integer>[] adj;
    public Chapt4NonGraph(int V){
        this.V = V;
        adj = new List[V];
        for (int i = 0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public Chapt4NonGraph(String[] a){
        V = Integer.parseInt(a[0]);
        int E = Integer.parseInt(a[1]);
        adj = new List[V];
        for (int i = 0; i<V;i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 2; i<a.length;i=i+2){
            int v = Integer.parseInt(a[i]);
            int w = Integer.parseInt(a[i+1]);
            addedge(v,w);
        }
    }
    public int degree(int v){
        return adj[v].size();
    }
    public int avgDegree(){
        int sum = 0;
        for (int i=0; i<V;i++){
            sum+=adj[i].size();
        }
        return sum/V;
    }
    public int maxDegree(){
        int max = 0;
        for (int i = 0; i<V;i++){
            max=Math.max(max,degree(i));
        }
        return max;
    }
    public int selfloops(){
        int cnt = 0;
        for (int v = 0; v<V;v++){
            for (int w:adj(v)){
                if (v==w){
                    cnt++;
                }
            }
        }
        return cnt/2;
    }
    private void addedge(int v, int w){
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
    public List<Integer> adj(int v){
        return adj[v];
    }
    public String toString(){
        String s = "";
        for (int i = 0; i<V;i++){
            s = s+i+":";
            for (Integer w:adj[i]){
                s+=w+" ";
            }
            s+="\n";
        }
        return s;
    }
    public static void main(String[] args){
        String g = "13 13 0 5 4 3 0 1 9 12 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        Chapt4NonGraph graph = new Chapt4NonGraph(a);
        System.out.println(graph.avgDegree());
    }
}
/*
0:5 1 2 6
1:0
2:0
3:4 5
4:3 6 5
5:0 4 3
6:4 0
7:8
8:7
9:12 10 11
10:9
11:12 9
12:9 11

 */
