package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/16/17.
 */
public class C43Kruskal {
    private C43DelMin pq;
    private List<C43WeightedEdge> mst;
    private double wei;
    public C43Kruskal(C43WeightedGraph g){
        pq = new C43DelMin(g.E());
        C43UF uf = new C43UF(g.V());
        mst = new ArrayList<>();
        for (C43WeightedEdge e:g.edges()){
            if (e!=null) {
                System.out.println(e);
                pq.insert(e);
            }
        }
        while (!pq.isEmpty()&&mst.size()<g.V()-1) {
            C43WeightedEdge e = (C43WeightedEdge) pq.delMin();
            int v = e.one();
            int w = e.theother(v);
            if (uf.connected(v,w)){
                continue;
            }
            uf.union(v,w);
            mst.add(e);
            wei+=e.weight();
        }
    }
    public List<C43WeightedEdge> edges(){
        return mst;
    }
    public double weight(){
        return wei;
    }
    public static void main(String[] args){
        String a = "8 " +
                "16 " +
                "5 4 0.35 " +
                "4 7 0.37 " +
                "5 7 0.28 " + "0 7 0.16 "+
                "5 1 0.32 " +
                "4 0 0.38 " +  "2 3 0.17 "+  "1 7 0.19 "+
                "0 2 0.26 " +  "1 2 0.36 "+
                "1 3 0.29 " +
                "7 2 0.34 " +
                "6 2 0.40 " +
                "3 6 0.52 " +
                "6 0 0.58 " +
                "6 4 0.93";
        String[] b = a.split(" ");
        //System.out.println("b.leng50:"+b.length);
        C43WeightedGraph g = new C43WeightedGraph(b);
        C43Kruskal mst = new C43Kruskal(g);
        // System.out.println(g);
        System.out.println(mst.weight()+":"+"\n"+mst.edges());
    }
}
