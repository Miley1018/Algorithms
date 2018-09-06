package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/29/17.
 */
public class DDChapt4NonWeightedMSTPrimLazy {
    private List<DDChapt4NonWeightedEdge> mst;
    private boolean[] marked;
    private Chapt2MaxPQ3<DDChapt4NonWeightedEdge> pq;
    public DDChapt4NonWeightedMSTPrimLazy(DDChapt4NonWeightedGraph graph){
        mst = new ArrayList<>();
        pq = new Chapt2MaxPQ3<DDChapt4NonWeightedEdge>(graph.E()+1);
        marked = new boolean[graph.V()];
        for(int i = 0; i<graph.V();i++){
            if (!marked[i]){
                helper(graph,i);
            }
        }
    }
    private void helper(DDChapt4NonWeightedGraph graph, int v){
        marked[v] = true;
        for(DDChapt4NonWeightedEdge e:graph.adj(v)){
            pq.insert(e);
        }
        while (pq!=null) {
            if (mst.size()==graph.V()-1){
                break;
            }
            DDChapt4NonWeightedEdge ee = pq.delMin();
            int one = ee.one();
            int theOther = ee.theOther(one);
            if (marked[one] && marked[theOther]) {
                continue;
            }
            mst.add(ee);
            if (!marked[one]) {
                helper(graph, one);
            }
            if (!marked[theOther]) {
                helper(graph, theOther);
            }
        }
    }
    public List<DDChapt4NonWeightedEdge> mst(){
        return mst;
    }
    public double weight(){
        double res = 0.0;
        for (DDChapt4NonWeightedEdge e:mst){
            res += e.weight();
        }
        return res;
    }
    public static void main(String[] args){
        String s ="8 " +
                "16 " +
                "4 5 0.35 " +
                "4 7 0.37 " +
                "5 7 0.28 " +
                "0 7 0.16 " +
                "1 5 0.32 " +
                "0 4 0.38 " +
                "2 3 0.17 " +
                "1 7 0.19 " +
                "0 2 0.26 " +
                "1 2 0.36 " +
                "1 3 0.29 " +
                "2 7 0.34 " +
                "6 2 0.40 " +
                "3 6 0.52 " +
                "6 0 0.58 " +
                "6 4 0.93 ";
        String[] a = s.split(" ");
        DDChapt4NonWeightedGraph graph = new DDChapt4NonWeightedGraph(a);
        DDChapt4NonWeightedMSTPrimLazy primLazy = new DDChapt4NonWeightedMSTPrimLazy(graph);
        System.out.println(graph.edges());
    }
}
