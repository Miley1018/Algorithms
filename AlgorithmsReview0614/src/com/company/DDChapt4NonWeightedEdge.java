package com.company;

/**
 * Created by mileygao on 6/29/17.
 */
public class DDChapt4NonWeightedEdge implements Comparable<DDChapt4NonWeightedEdge>{
    private int one;
    private int theOther;
    private double weight;
    public DDChapt4NonWeightedEdge(int one, int other, double weight){
        this.one = one;
        this.theOther = other;
        this.weight = weight;
    }
    public int one(){
        return one;
    }
    public int theOther(int v){
        if (v == one) {
            return theOther;
        }else {
            return one;
        }
    }
    public double weight(){
        return weight;
    }

    @Override
    public int compareTo(DDChapt4NonWeightedEdge o) {
        if (this.weight()>o.weight()){
            return 1;
        }else if(this.weight()<o.weight()){
            return -1;
        }else {
            return 0;
        }
    }

    public String toString(){
        String s = "";
        return s+one+"-"+theOther+":"+weight();
    }
}
