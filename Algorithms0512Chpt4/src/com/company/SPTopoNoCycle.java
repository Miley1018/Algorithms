package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mileygao on 5/19/17.
 */
public class SPTopoNoCycle {
    private SPWeightedDiGraphTopo topo;
    private double[] distTo;
    private SPWeightedDiEdge[] edgeTo;
    private final int s;
    public SPTopoNoCycle(SPWeightedDiGraph graph, int s){
        topo = new SPWeightedDiGraphTopo(graph);
        this.s = s;
        distTo = new double[graph.V()];
        for (int i =0; i <graph.V();i ++){
            distTo[i] = Double.NEGATIVE_INFINITY;
        }
        edgeTo = new SPWeightedDiEdge[graph.V()];

        distTo[s] = 0.0;
        for (int i:topo.topoOrder()){
            relax(graph,i);
        }

    }
    public void relax(SPWeightedDiGraph graph, int v){
        for (SPWeightedDiEdge e: graph.adj(v)){
            int w = e.to();
            if (distTo[w]<distTo[v]+e.getWeight()){
                distTo[w]=distTo[v]+e.getWeight();
                edgeTo[w] = e;
            }
        }
    }

    public boolean hasPathTo(int v){
        return distTo[v] > Double.NEGATIVE_INFINITY;
    }
    public List<SPWeightedDiEdge> pathTo(int v){
        List<SPWeightedDiEdge>  list = new ArrayList<>();
        if (!hasPathTo(v)){
            return null;
        }
        for (int i = v; i!=s; i = edgeTo[i].from()){
            list.add(edgeTo[i]);
        }
        return list;
    }
    public double dictTo(int v){
        return distTo[v];
    }
    public Stack<Integer> topoPrint(){
        return topo.topoOrder();
    }
    public static void main(String[] args){
        SPWeightedDiGraph graph = new SPWeightedDiGraph(new In(args[0]));
        SPTopoNoCycle sp = new SPTopoNoCycle(graph,3);
        System.out.println(sp.hasPathTo(2)+" " +sp.pathTo(2)+" "+sp.dictTo(6)+"\n");
        System.out.println(sp.topoPrint());

    }
}
