package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 6/27/17.
 */
public class Chapt3STSequentialArray2<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    public Chapt3STSequentialArray2(int n){
        keys = (Key[])new Comparable[n];
        values = (Value[])new Object[n];
    }
    public int rank(Key key, int lo, int hi){
        if (lo>hi){
            return lo;
        }
        int mid = lo+(hi-lo)/2;
        if (keys[mid].equals(key)){
            return mid;
        }else if (keys[mid].compareTo(key)>0){
            return rank(key,lo,mid-1);
        }else {
            return rank(key,mid+1,hi);
        }
    }
    public boolean contains(Key key){
        int j = rank(key,0,N-1);
        if (j<N&&keys[j].equals(key)){
            return true;
        }
        return false;
    }
    private void resize(int maxN){
        Key[] keys2 = (Key[])new Comparable[maxN];
        Value[] values2 = (Value[])new Object[maxN];
        for (int i = 0; i<N;i++){
            keys2[i] = keys[i];
            values2[i] = values[i];
        }
        keys = keys2;
        values = values2;
    }
    public void put(Key key, Value value){
        if (value==null){
            delete(key);
            return;
        }
        if (N>=keys.length){
            resize(2*keys.length);
        }
        int j = rank(key,0,N-1);
        if (j<N&&keys[j].equals(key)){
            values[j] = value;
            return;
        }
        N++;
        for (int i = N-1; i>j;i--) {
            keys[i] = keys[i-1];
            values[i]= values[i-1];
        }
        keys[j] = key;
        values[j] = value;
    }
    public void delete(Key key){
        int j = rank(key,0,N-1);
        if (j<N&&keys[j].equals(key)){
            for (int i = j;i<N-1;i++){
                keys[i] = keys[i+1];
                values[i]= values[i+1];
            }
        }
        N--;
        if (N<=keys.length/2){
            resize(keys.length/2);
        }
    }
    public Value get(Key key){
        int j = rank(key,0,N-1);
        if (j<N&&keys[j].equals(key)){
            return values[j];
        }
        return null;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i<N;i++){
            list.add(keys[i]);
        }
        return list;
    }
    public int size(){
        return N;
    }
    public static void main(String[] args){
        Chapt3STSequentialArray2<String,Integer> st = new Chapt3STSequentialArray2(5);
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        while (!key.equals("-")){
            if (st.contains(key)) {
                st.put(key, st.get(key)+1);
            }else{
                st.put(key, 1);
            }
            key = sc.next();
        }
        System.out.println(st.size());
        System.out.println(st.keys());
        //st.delete("a");
        System.out.println(st.keys());
        System.out.println(st.size());
        int max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }

        System.out.println(max);
    }
}
