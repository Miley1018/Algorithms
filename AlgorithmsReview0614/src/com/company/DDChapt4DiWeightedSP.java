package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/29/17.
 */
public class DDChapt4DiWeightedSP {
    private final int s;
    private double[] distTo;
    private boolean[] marked;
    private int[] pathTo;
    public DDChapt4DiWeightedSP(DDChapt4DiWeightedGraph graph, int v){
        s = v;
        distTo= new double[graph.V()];
        for (int i = 0; i<graph.V();i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        pathTo = new int[graph.V()];
        marked = new boolean[graph.V()];
        distTo[v] = 0.0;
        pathTo[v] = v;
        helper(graph,v);
    }
    private void helper(DDChapt4DiWeightedGraph graph,int v){
        marked[v] = true;
        for (DDChapt4DiWeightedEdge e:graph.adj(v)){
            int to = e.to();
            if (distTo[to]> distTo[v]+e.weight()){
                distTo[to] =  distTo[v]+e.weight();
                pathTo[to] = v;
            }
            helper(graph, to);
        }
    }
    public double distTo(int v){
        return distTo[v];
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public List<Integer> pathTo(int v){
        List<Integer> list = new ArrayList<>();
        for (int i = v; i!=s;i = pathTo[i]){
            list.add(i);
        }
        list.add(s);
        return list;
    }
    public static void main(String[] args){
        String s = "8 " +
                "15 " +
                "4 5 0.35 " +
                "5 4 0.35 " +
                "4 7 0.37 " +
                "5 7 0.28 " +
                "7 5 0.28 " +
                "5 1 0.32 " +
                "0 4 0.38 " +
                "0 2 0.26 " +
                "7 3 0.39 " +
                "1 3 0.29 " +
                "2 7 0.34 " +
                "6 2 0.40 " +
                "3 6 0.52 " +
                "6 0 0.58 " +
                "6 4 0.93";
        String[] a = s.split(" ");
        DDChapt4DiWeightedGraph graph = new DDChapt4DiWeightedGraph(a);
        DDChapt4DiWeightedSP sp = new DDChapt4DiWeightedSP(graph,0);
        System.out.println(sp.distTo(7));
    }
}
