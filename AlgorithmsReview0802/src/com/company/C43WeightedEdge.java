package com.company;

/**
 * Created by mileygao on 8/15/17.
 */
public class C43WeightedEdge implements Comparable<C43WeightedEdge>{
    private double weight;
    private int v;
    private int w;
    public C43WeightedEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;this.weight = weight;
    }
    public int one(){
        return v;
    }
    public int theother(int vertex){
        if (vertex==v){
            return w;
        }
        else if (vertex == w){
            return v;
        }
        else {
            return -1;
        }
    }
    public double weight(){
        return weight;
    }
    public String toString(){
        String s = "";
        s+=v+" "+w +": "+weight;
        return s;
    }
    @Override
    public int compareTo(C43WeightedEdge o) {
        if (this.weight>o.weight){
            return 1;
        }else if (this.weight<o.weight){
            return -1;
        }else {
            return 0;
        }
    }
}
