package com.company;

import edu.princeton.cs.algs4.In;

/**
 * Created by mileygao on 5/22/17.
 */
public class SPJobs {
    public static void main(String[] args){
        In in = new In(args[0]);
        int N = in.readInt();
        in.readLine();
        SPWeightedDiGraph graph = new SPWeightedDiGraph(2*N+2);
        int s = 2*N;
        int t = 2*N+1;
        for (int i = 0; i<N; i++){
            String[] strings = in.readLine().split(" ");
            graph.addEdge(new SPWeightedDiEdge(s,i,0.0));
            graph.addEdge(new SPWeightedDiEdge(i,i+N,Double.valueOf(strings[0])));
            graph.addEdge(new SPWeightedDiEdge(i+N,t,0.0));
            for (int j = 1; j <strings.length; j++){
                int w = Integer.parseInt(strings[j]);
                graph.addEdge(new SPWeightedDiEdge(i+N,w,0.0));
            }
        }
        SPTopoNoCycle sp = new SPTopoNoCycle(graph,s);
        System.out.println(sp.dictTo(t));
    }
}
