package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/17/17.
 */
public class C44Floyd {
    private double[][] disTo;
    private int[][] pathTo;
    public C44Floyd(C44WeightedDiGraph g){
        disTo = new double[g.V()][g.V()];
        pathTo = new int[g.V()][g.V()];
        for (int i = 0; i<g.V();i++){
            for (int j = 0; j<g.V();j++){
                disTo[i][j] = Double.POSITIVE_INFINITY;
                pathTo[i][j] = -1;
            }
        }
        for (int i = 0; i<g.V();i++){
            for (C44WeightedDiEdge e: g.adj(i)){
                disTo[i][e.to()] = e.weight();
            }
        }
        for (int k = 0; k<g.V();k++){
            for (int i = 0; i<g.V();i++){
                for (int j = 0; j<g.V();j++){
                    if (disTo[i][j]>disTo[i][k]+disTo[k][j]){
                        disTo[i][j] = disTo[i][k]+disTo[k][j];
                        pathTo[i][j] = k;
                    }
                }
            }
        }
    }
    public List<Integer> pathTo(int i, int j){
        List<Integer> list = new ArrayList<>();
        for (int k = pathTo[i][j];k!=-1;k = pathTo[i][k]){
            list.add(k);
        }
        return list;
    }
    public static void main(String[] args){
        String a = "8 " +
                "13 " +
                "5 4 0.35 " +
                "4 7 0.37 " +
                "5 7 0.28 " +
                "5 1 0.32 " +
                "4 0 0.38 " +
                "0 2 0.26 " +
                "3 7 0.39 " +
                "1 3 0.29 " +
                "7 2 0.34 " +
                "6 2 0.40 " +
                "3 6 0.52 " +
                "6 0 0.58 " +
                "6 4 0.93 ";
        String[] aa = a.split(" ");
        C44WeightedDiGraph g = new C44WeightedDiGraph(aa);
        C44Floyd sp = new C44Floyd(g);
        System.out.println(sp.pathTo(5,0));

    }
}
