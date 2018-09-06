package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;
    private int E;
    private List<Integer>[] adj;
    public Graph(int V){
        this.E = 0;
        this.V = V;
        adj = new ArrayList[V];
        for (int i =0; i <V; i ++){
            adj[i] = new ArrayList<>();
        }
    }
    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i <E; i ++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }
    int V(){
        return V;
    }
    int E(){
        return E;
    }
    void addEdge(int v, int w){
        adj(v).add(w);
        adj(w).add(v);
        E++;
    }
    List<Integer> adj(int v){
        return adj[v];
    }
    public String toString(){
        String s = V+" vertices " + E +" edges \n";
        for (int i = 0; i <V ; i++){
            s += i +":";
            for (int w: adj(i)){
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
    public static int degree(Graph graph,int v){
        int degree = 0;
        for (int i :graph.adj(v)){
            degree++;
        }
        return degree;
    }
    public static int maxDegree(Graph graph){
        int max = 0;
        int v = graph.V();
        for (int i = 0; i <v; i++){
            if (degree(graph,i)>max){
                max = degree(graph,i);
            }
        }
        return max;
    }
    public static int avgDegree(Graph graph){
        return graph.E()*2/graph.V();
    }
    public static int numberOfSelfLoops(Graph graph){
        int count = 0;
        for (int i =0; i < graph.V(); i++){
            for (int j : graph.adj(i)){
                if (j == i){
                    count++;
                }
            }
        }
        return count/2;
    }
    public static void main(String[] args) {
	// write your code here
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,0);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(2,5);
        System.out.println(graph.maxDegree(graph));
        System.out.println(graph.degree(graph,2));
        System.out.println(graph.avgDegree(graph));
        System.out.println(graph.numberOfSelfLoops(graph));
        System.out.println(graph);
    }
}
