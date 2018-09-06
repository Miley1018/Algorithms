package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/29/17.
 */
public class DDChapt4NonWeightedMSTKruskal {
    private Chapt2MaxPQ3<DDChapt4NonWeightedEdge> pq;
    private List<DDChapt4NonWeightedEdge> mst;
    public DDChapt4NonWeightedMSTKruskal(DDChapt4NonWeightedGraph graph){
        pq = new Chapt2MaxPQ3<>(graph.E()+1);
        mst = new ArrayList<>();
        for (DDChapt4NonWeightedEdge e:graph.edges()){
            pq.insert(e);
        }
        int i = 1;
        Chapt1UF2 uf = new Chapt1UF2(graph.V());
        while (i<graph.V()){
            DDChapt4NonWeightedEdge min = pq.delMin();
            int one = min.one();
            int other = min.theOther(one);
            if (uf.connected(one,other)){
                continue;
            }
            mst.add(min);
            uf.union(one,other);
            i++;
        }
    }
    public List<DDChapt4NonWeightedEdge> mst(){
        return mst;
    }
    public double weight(){
        double w = 0.0;
        for (DDChapt4NonWeightedEdge e:mst){
            w+=e.weight();
        }
        return w;
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
        DDChapt4NonWeightedMSTKruskal primLazy = new DDChapt4NonWeightedMSTKruskal(graph);
        System.out.println(primLazy.weight());
    }
}
