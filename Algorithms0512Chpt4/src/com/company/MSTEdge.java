package com.company;

/**
 * Created by mileygao on 5/17/17.
 */
public class MSTEdge implements Comparable<MSTEdge>{
    private int v;
    private int w;
    private double weight;
    public MSTEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;

    }
    public double weight(){
        return weight;
    }
    public int either(){
        return v;
    }
    public int other(int one){
        if (one == v){
            return w;
        }else {
            return v;
        }
    }
    @Override
    public int compareTo(MSTEdge o) {
        if (this.weight()>o.weight()){
            return 1;
        }
        if (this.weight()<o.weight()){
            return -1;
        }else {
            return 0;
        }
    }
    public String toString(){
        return v+" "+ w+" " +weight;
    }
}
