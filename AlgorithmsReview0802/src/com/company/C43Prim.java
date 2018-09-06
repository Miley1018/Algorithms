package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/16/17.
 */
public class C43Prim {
    private C43IndexMinPQ<Double> pq;
    private double[] disTo;
    private C43WeightedEdge[] edgeTo;
    private boolean[] marked;
    private double wei = 0.0;
    public C43Prim(C43WeightedGraph g){
        pq = new C43IndexMinPQ<>(g.V()+1);
        edgeTo = new C43WeightedEdge[g.V()];
        marked = new boolean[g.V()];
        disTo = new double[g.V()];
        for (int i = 0; i<g.V();i++){
            disTo[i] = Double.POSITIVE_INFINITY;
        }
        disTo[0] = 0.0;
        pq.insert(0,0.0);
        while (!pq.isEmpty()){
            help(g,pq.delMin());
        }
    }
    private void help(C43WeightedGraph g, int v){
        marked[v] = true;
        for (C43WeightedEdge e:g.adj(v)){
            if (marked[e.theother(v)]){
                continue;
            }
            int w = e.theother(v);
            if (disTo[w]>e.weight()){
                disTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)){
                    pq.change(w,disTo[w]);
                }else {
                    pq.insert(w,disTo[w]);
                }
            }
        }
    }
    public List<C43WeightedEdge> edges(){
        List<C43WeightedEdge> list = new ArrayList<>();
       for (C43WeightedEdge e:edgeTo){
           if (e==null){
               continue;
           }
           list.add(e);
           this.wei= this.wei+e.weight();
       }
        return list;
    }
    public double weight(){
      double a = 0.0;
      for (double e:disTo){
          a+=e;
      }
      return a;
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
        C43Prim mst = new C43Prim(g);
        // System.out.println(g);
        System.out.println(mst.weight()+":"+"\n"+mst.edges());
    }
}
