package com.company;

/**
 * Created by mileygao on 8/17/17.
 */
public class C44WeightedDiEdge implements Comparable<C44WeightedDiEdge> {
    private double weight;
    private int from;
    private int to;
    public C44WeightedDiEdge(int from, int to, double wei){
        this.from = from;
        this.to = to;
        this.weight = wei;
    }

    public int from(){
        return from;
    }
    public int to(){
        return to;
    }
    public double weight(){
        return weight;
    }
    public String toString(){
        String s = "";
        s+=from+"-"+to+":"+weight;
        return s;
    }
    @Override
    public int compareTo(C44WeightedDiEdge o) {
        if (this.weight>o.weight) {
            return 1;
        }else if (this.weight<o.weight){
            return -1;
        }else {
            return 0;
        }
    }
}
