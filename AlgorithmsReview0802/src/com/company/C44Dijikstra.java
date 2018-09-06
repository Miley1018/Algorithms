package com.company;

import java.util.*;

/**
 * Created by mileygao on 8/17/17.
 */
public class C44Dijikstra {
    private C43IndexMinPQ pq;
    private double[] disTo;
    private C44WeightedDiEdge[] edgeTo;
    public C44Dijikstra(C44WeightedDiGraph g, int s){
        pq = new C43IndexMinPQ(g.V());
        disTo = new double[g.V()];
        edgeTo = new C44WeightedDiEdge[g.V()];
        for (int i = 0; i<g.V();i++){
            disTo[i] = Double.POSITIVE_INFINITY;
        }
        pq.insert(s,0.0);
        disTo[s] = 0.0;
        while (!pq.isEmpty()){
            help(g,pq.delMin());
        }
    }
    private void help(C44WeightedDiGraph g, int v){
        for (C44WeightedDiEdge e:g.adj(v)){
            int w = e.to();
            if (disTo[w]>disTo[v]+e.weight()){
                disTo[w] = disTo[v]+e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)){
                    pq.change(w,disTo[w]);
                }else {
                    pq.insert(w,disTo[w]);
                }
            }
        }
    }
    public boolean hasPthTo(int v){
        return disTo[v]<Double.POSITIVE_INFINITY;
    }
    public List<C44WeightedDiEdge> pathTo(int v){
        List<C44WeightedDiEdge> list = new ArrayList<>();
        for (C44WeightedDiEdge e = edgeTo[v]; e!=null;e = edgeTo[e.from()]){
            list.add(e);
        }
        return list;
    }
    public double disTo(int v){
        return disTo[v];
    }
    public String longestPalindrome(String s) {
        // Write your solution here
        if (s == null || s.length() <= 1) {
            return s;
        }
        int n = s.length();
        int index = 0;
        boolean isCenter = false;
        int L = 0;
        for (int i = 0; i < n; i ++) {
            int iAsCenter = longestAt(s, i - 1, i + 1) + 1;
            int iNotCenter = longestAt(s, i, i + 1);
            int longestCur = Math.max(iAsCenter, iNotCenter);
            if (longestCur > L) {
                if (iAsCenter > iNotCenter) {
                    isCenter = true;
                } else {
                    isCenter = false;
                }
                index = i;
                L = longestCur;
            }
            if (longestCur == n) {
                break;
            }
        }
        int startIndex = (isCenter ? (index - (L - 1)/ 2) : (index + 1 - L / 2));
        return s.substring(startIndex, startIndex + L);
    }
    private int longestAt(String s, int i, int j) {
        int n = 0;
        while (i >=0 && j < s.length()) {
            if (s.charAt(i --) == s.charAt(j ++)) {
                n ++;
            }
        }
        return 2 * n;
    }
    public static void main(String[] args) {
        String a = "8 15 4 5 0.35 5 4 0.35 4 7 0.37 5 7 0.28 7 5 0.28 5 1 0.32 0 4 0.38 0 2 0.26 7 3 0.39 1 3 0.29 2 7 0.34 6 2 0.40 3 6 0.52 6 0 0.58 6 4 0.93";
        String[] aa  = a.split(" ");
        C44WeightedDiGraph graph = new C44WeightedDiGraph(aa);
        C44Dijikstra dijikstra = new C44Dijikstra(graph,0);
        System.out.println(dijikstra.hasPthTo(3)+"："+dijikstra.pathTo(3)+":"+dijikstra.disTo(3));
    }


}
