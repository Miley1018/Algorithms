package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/19/17.
 */
public class SPDijkstra {
    private SPWeightedDiEdge[] edgeTo;
    private double[] distTo;
    private MSTIndexPQ<Double> pq;
    public SPDijkstra(SPWeightedDiGraph graph){
        edgeTo = new SPWeightedDiEdge[graph.V()];
        distTo = new double[graph.V()];
        for (int i = 0; i <graph.V(); i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[5] = 0.0;
        pq = new MSTIndexPQ(graph.E());
        pq.insert(5,0.0);
        while (!pq.isEmpty()){
            relax(graph,pq.delMin());
        }
    }
    public void relax(SPWeightedDiGraph graph, int v){
        for (SPWeightedDiEdge e:graph.adj(v)){
            int w = e.to();
            if (e.getWeight()+distTo[v]<distTo[w]){
                distTo[w] = e.getWeight()+distTo[v];
                edgeTo[w] = e;
                if (pq.contains(w)){
                    pq.change(w,distTo[w]);
                }else{
                    pq.insert(w,distTo[w]);
                }
            }

        }
    }
    public boolean hasPathTo(int v){
        return distTo[v]< Double.POSITIVE_INFINITY;
    }
    public List<SPWeightedDiEdge> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        List<SPWeightedDiEdge> list = new ArrayList<>();
        for (int i = v; i!=5; i = edgeTo[i].from()){
            list.add(edgeTo[i]);
        }
        return list;
    }

    public static void main(String[] args){
        SPWeightedDiGraph graph = new SPWeightedDiGraph(new In(args[0]));
        SPDijkstra sp = new SPDijkstra(graph);
        System.out.println(sp.hasPathTo(5)+" " +sp.pathTo(2));
    }
}
