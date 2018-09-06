package com.company;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/24/17.
 */
public class SPFloyd {
    double[][] distTo;
    int[][] pathTo;

    public SPFloyd(SPWeightedDiGraph graph){
        int V = graph.V();
        distTo = new double[V][V];
        pathTo = new int[V][V];
        for (int i = 0; i <V; i ++){
            for (int j = 0; j <V; j ++) {
                distTo[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        for (int i =0; i<V; i ++){
            distTo[i][i] =0;
        }
        for (int i = 0; i <V; i ++){
            for (SPWeightedDiEdge e: graph.adj(i)){
                distTo[e.from()][e.to()] = e.getWeight();
            }
        }
        for (int i = 0; i <V; i ++) {
            for (int j = 0; j < V; j++) {
                pathTo[i][j] = -1;
            }
        }
        for (int k = 0; k <V;k++){
            for (int i = 0; i <V; i++){
                for (int j = 0; j <V; j++){
                    if (distTo[i][j]>distTo[i][k]+distTo[k][j]){
                        distTo[i][j]=distTo[i][k]+distTo[k][j];
                        pathTo[i][j] = k;
                    }
                }
            }
        }
    }
    public boolean hasPathTo(int i, int j){
        return distTo[i][j]<Double.POSITIVE_INFINITY;
    }
    public List<Integer> pathTo(int i, int j){
        List<Integer> list = new ArrayList<>();
        if (!hasPathTo(i,j)){
            return null;
        }
        for (int k = pathTo[i][j];k!=-1;k = pathTo[i][k]){
            list.add(k);
        }
        return list;
    }
    public static void main(String[] args){
        SPWeightedDiGraph graph = new SPWeightedDiGraph(new In(args[0]));
        SPFloyd sp = new SPFloyd(graph);
        System.out.println(sp.hasPathTo(5,2)+" " +sp.pathTo(5,2));
    }
}
