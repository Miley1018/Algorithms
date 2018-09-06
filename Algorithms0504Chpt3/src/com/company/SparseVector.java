package com.company;

import edu.princeton.cs.algs4.In;

/**
 * Created by mileygao on 5/11/17.
 */
public class SparseVector {
    private LinearProbingHashST <Integer,Double> st;
    public SparseVector(){
        st = new LinearProbingHashST<>();
    }
    public int size(){
        return st.size();
    }
    public void put(int i, double j){
        st.put(i,j);
    }
    public double get(int i){
        if (!st.contain(i)){
            return 0.0;
        }
        return st.get(i);
    }
    public double dot(double[] that){
        double sum = 0.0;
        for (int i: st.keys()){
            sum += that[i]*st.get(i);
        }
        return sum;
    }
    public static void main(String[] args){
        SparseVector sp = new SparseVector();
        sp.put(0,9.0);
        sp.put(1,1.0);
        double[] that = {2.0,3.0};


        System.out.println(sp.dot(that));
    }
}

