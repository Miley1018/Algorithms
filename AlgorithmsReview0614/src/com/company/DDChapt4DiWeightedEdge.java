package com.company;

/**
 * Created by mileygao on 6/29/17.
 */
public class DDChapt4DiWeightedEdge implements Comparable<DDChapt4DiWeightedEdge> {
    private double weight;
    private int from;
    private int to;
    public DDChapt4DiWeightedEdge(int from, int to, double weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
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
    public int compareTo(DDChapt4DiWeightedEdge that){
        if (this.weight()>that.weight()){
            return 1;
        }else if (this.weight()<that.weight()){
            return -1;
        }else {
            return 0;
        }
    }
    public String toString(){
        String s  ="";
        s+=from+"-"+to+":"+weight;
        return s;
    }
}
