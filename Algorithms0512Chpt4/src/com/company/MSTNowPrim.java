package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/18/17.
 */
public class MSTNowPrim {
    private MSTEdgeWeightedGraph graph;
    private double[] weights;
    private boolean[] marked;
    private MSTEdge[] edgeTo;
    private MSTIndexPQ<Double> pq;
    public MSTNowPrim(MSTEdgeWeightedGraph graph){
        this.graph = graph;
        pq = new MSTIndexPQ<>(graph.V());
        edgeTo = new MSTEdge[graph.V()];
        marked = new boolean[graph.V()];
        weights = new double[graph.V()];
        for (int i = 0; i <graph.V(); i++){
            weights[i] = 10000.0;
        }
        weights[0] = 0.0;
        pq.insert(0,0.0);
        while (!pq.isEmpty()){
            visit(graph,pq.delMin());
        }
    }
    public void visit(MSTEdgeWeightedGraph graph, int v){
        marked[v] = true;
        for (MSTEdge e: graph.adj(v)){
            int i = e.other(v);
            if (marked[i]){
                continue;
            }
            if (weights[i]>e.weight()){
                edgeTo[i] = e;
                weights[i] = e.weight();
                if (pq.contains(i)){
                    pq.change(i,weights[i]);
                }else {
                    pq.insert(i,weights[i]);
                }
            }
        }

    }
    public List<MSTEdge> edges(){
        List<MSTEdge> edges = new ArrayList<>();
        for (MSTEdge e: edgeTo){
            edges.add(e);
        }
        return edges;
    }
    public double weight(){
        double weight = 0;
        for (int i = 0; i <graph.V(); i++){
            weight+= weights[i];
        }
        return weight;
    }
    public static void main(String [] args){
        MSTEdgeWeightedGraph  graph = new MSTEdgeWeightedGraph(new In(args[0]));
        MSTNowPrim mstNowPrim = new MSTNowPrim(graph);
        System.out.println(mstNowPrim.edges());
        System.out.println(mstNowPrim.weight());
    }
}
