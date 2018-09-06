package com.company;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/14/17.
 */
public class C41Graph {
    private int V;
    private int E;
    private List<Integer>[] adj;
    public C41Graph(int v){
        this.V = v;
        adj = new ArrayList[V];
        for (int i = 0; i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public C41Graph(int[] a){
        this.V = a[0];
        int E = a[1];
        adj = new ArrayList[V];
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
    public void addEdge(int i, int j){
      //  System.out.println("ss"+i);
        adj[i].add(j);
        adj[j].add(i);
        E++;
    }
    public List<Integer> adj(int v){
        return adj[v];
    }
    public String toString(){
        String s = "";
        for (int i = 0; i<V;i++){
            s+=i+": ";
            for (int j:adj(i)){
                s+=j+" ";
            }
            s+="\n";
        }
        return s;
    }
}
