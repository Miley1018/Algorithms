package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/18/17.
 */
public class MSTLazyPrim {
    private List<MSTEdge> mstEdgeList;
    private MSTPQ<MSTEdge> pq;
    private boolean[] marked;
    private MSTEdgeWeightedGraph graph;
    public MSTLazyPrim(MSTEdgeWeightedGraph g){
        graph = g;
        mstEdgeList = new ArrayList<>();
        marked = new boolean[g.V()];
        marked[0] = true;
        pq = new MSTPQ<>(g.E());
        visit(g,0);
        while(!pq.isEmpty()){
            MSTEdge min = pq.delMin();
            int v = min.either();
            int w = min.other(v);
            if (marked[v]&&marked[w]){
                continue;
            }
            mstEdgeList.add(min);
            if (!marked[v]){
                visit(g,v);
            }if (!marked[w]){
                visit(g,w);
            }
        }
    }
    public void visit(MSTEdgeWeightedGraph g, int v){
        marked[v] = true;
        for (MSTEdge e: g.adj(v)){
            if (!marked[e.other(v)]){
                pq.insert(e);
            }
        }
    }
    public List<MSTEdge> edges(){
        return mstEdgeList;
    }
    public double weight(){
        double weight = 0;
        for (MSTEdge e:edges()){
            weight+=e.weight();
        }
        return weight;
    }
    public static void main(String[] args){
        MSTEdgeWeightedGraph graph = new MSTEdgeWeightedGraph(new In(args[0]));
        MSTLazyPrim mstLazyPrim = new MSTLazyPrim(graph);
        System.out.println(mstLazyPrim.edges());
        System.out.println(mstLazyPrim.weight());
    }
}
