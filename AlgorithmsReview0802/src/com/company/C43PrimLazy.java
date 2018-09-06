package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/15/17.
 */
public class C43PrimLazy {
    private boolean[] marked;
    private C43DelMin pq;
    private List<C43WeightedEdge> mst;
    private double wei;
    public C43PrimLazy(C43WeightedGraph g){
        marked = new boolean[g.V()];
        pq = new C43DelMin(g.E());
        mst = new ArrayList<>();
        help(0,g);
        while (!pq.isEmpty()){
            C43WeightedEdge min =(C43WeightedEdge) pq.delMin();
            int v = min.one();
            int w = min.theother(v);
            if (marked[v]&&marked[w]){
                continue;
            }
            mst.add(min);
            wei+=min.weight();
            if (!marked[v]){
                help(v,g);
            }
            if (!marked[w]){
                help(w,g);
            }
        }
    }
    private void help(int v,C43WeightedGraph g){
        marked[v] = true;
        for (C43WeightedEdge e:g.adj(v)){
            if (!marked[e.theother(v)]) {
                pq.insert(e);
            }
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
        C43PrimLazy mst = new C43PrimLazy(g);
       // System.out.println(g);
        System.out.println(mst.weight()+":"+"\n"+mst.edges());
    }
}
