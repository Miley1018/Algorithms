package com.company;

/**
 * Created by mileygao on 5/19/17.
 */
public class SPWeightedDiEdge implements Comparable<SPWeightedDiEdge> {
    private double weight;
    private int from;
    private int to;
    public SPWeightedDiEdge(int v, int w, double weight){
        this.from = v;
        this.to = w;
        this.weight = weight;
    }

    @Override
    public int compareTo(SPWeightedDiEdge o) {
        if (this.weight>o.weight){
            return 1;
        }
        if (this.weight<o.weight){
            return -1;
        }
        return 0;
    }

    public double getWeight(){
        return weight;
    }
    public int from(){
        return from;
    }
    public int to(){
        return to;
    }
    public String toString(){
        return from+" "+ to+" "+ weight;
    }
}
