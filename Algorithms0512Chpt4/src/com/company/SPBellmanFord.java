package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/23/17.
 */
public class SPBellmanFord {
    private SPWeightedDiEdge[] edgeTo;
    private double[] distTo;
    private final int s;
    public SPBellmanFord(SPWeightedDiGraph graph,int s){
        edgeTo = new SPWeightedDiEdge[graph.V()];
        distTo = new double[graph.V()];
        this.s = s;
        for (int i = 0; i <graph.V();i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        for (int i = 0; i <graph.V();i++){
            for (int j = 0; j<graph.V();j++){
                for (SPWeightedDiEdge e: graph.adj(j)){
                    relax(e);
                }
            }
        }
    }
    public void relax(SPWeightedDiEdge edge){
        int v = edge.from();
        int w = edge.to();
        if (distTo[w]>distTo[v]+edge.getWeight() ){
            distTo[w]=distTo[v]+edge.getWeight();
            edgeTo[w] = edge;
        }
    }
    public boolean hasPathTo(int v){
        return distTo[v]<Double.POSITIVE_INFINITY;
    }
    public List<SPWeightedDiEdge> pathTo(int v){
        List<SPWeightedDiEdge> list = new ArrayList<>();
        for (int i = v; i!=s; i = edgeTo[i].from()){
            list.add(edgeTo[i]);
        }
        return list;
    }
    public static void main(String[] args){
        SPWeightedDiGraph graph = new SPWeightedDiGraph(new In(args[0]));
        SPBellmanFord sp = new SPBellmanFord(graph,0);
        System.out.println(sp.hasPathTo(5)+" " +sp.pathTo(6));
        int a = 5;
        System.out.println(~a);
        System.out.println(128&129);
    }
}
