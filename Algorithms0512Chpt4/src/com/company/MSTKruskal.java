package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/18/17.
 */
public class MSTKruskal {
    private MSTPQ<MSTEdge> pq;
    private MSTUnionFind uf;
    private List<MSTEdge> list;
    public MSTKruskal(MSTEdgeWeightedGraph graph){
        pq = new MSTPQ(graph.edges());
        list = new ArrayList<>();
        uf = new MSTUnionFind(graph.V());
        while (!pq.isEmpty()) {
            MSTEdge edge = pq.delMin();
            int v = edge.either();
            int w = edge.other(v);
            if (uf.connected(v,w)){
                continue;
            }
            uf.union(v,w);
            list.add(edge);
        }
    }
    public List<MSTEdge> edges(){
        return list;
    }
    public double weight(){
        double weight=0;
        for (MSTEdge edge:list){
            weight+=edge.weight();
        }
        return weight;
    }
    public static void main(String[] args){
        MSTEdgeWeightedGraph graph = new MSTEdgeWeightedGraph(new In(args[0]));
        MSTKruskal mst = new MSTKruskal(graph);
        System.out.println(mst.edges());
        System.out.println(mst.weight());
    }
}
