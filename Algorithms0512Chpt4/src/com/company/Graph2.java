package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/15/17.
 */
public class Graph2 {
    private List<Integer>[] adj;
    private int E;
    public int V;
    public Graph2(In in){
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i <E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }

    }
    public Graph2(int V){
        this.V = V;
        adj = new List[V];
        for (int i =0; i < V; i ++){
            adj[i] = new ArrayList();
        }
        E = 0;
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
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
    @Override
    public String toString() {
        String s = V + " vertices" + E + " edges \n";
        for (int i = 0; i<V; i++){
            s += i + ": " ;
            for (int w: adj(i)){
                s+= w + " ";
            }
            s += "\n";
        }
        return s;
    }
    public int maxDegree(){
        int max = 0;
        for (int i = 0; i < V; i++){
            if (degree(i)>max){
                max = degree(i);
            }
        }
        return max;
    }
    public int avgDegree(){
        return E*2/V;
    }
    public int degree(int v){
        int degree = 0;
        for (int w: adj(v)){
            degree++;
        }
        return degree;
    }
    public int numsOfSelfLoops(){
        int num = 0;
        for (int i = 0; i <V; i ++){
            for (int w: adj(i)){
                if (w == i){
                    num++;
                }
            }
        }
        return num/2;
    }

    public static void main(String[] args){
        Graph2 graph2 = new Graph2(6);
        graph2.addEdge(0,1);
        graph2.addEdge(0,2);
        graph2.addEdge(0,3);
        graph2.addEdge(0,4);
        graph2.addEdge(2,5);
        graph2.addEdge(3,5);
        graph2.addEdge(3,4);
        System.out.println(graph2.maxDegree()+ " "+ graph2.avgDegree() + " " + graph2.degree(3) + " " + graph2.numsOfSelfLoops());
        System.out.println(graph2.adj(2)+ " " + " \n" + graph2);
        Graph2 graph21 = new Graph2(new In(args[0]));
        System.out.println(graph21);
    }
}
