package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 7/10/17.
 */
public class Chapt3STSequentialArray3 <Key extends Comparable<Key>,Value>{
    private int N;
    private Key[] keys;
    private Value[] values;
    public Chapt3STSequentialArray3(int n){
        keys =(Key[]) new Comparable[n];
        values = (Value[]) new Object[n];
    }
    private void resize(int maxN){
        Key[] keys1 =(Key[]) new Comparable[maxN];
        Value[] values1= (Value[]) new Object[maxN];
        for (int i = 0; i<N;i++){
            keys1[i] = keys[i];
            values1[i] = values[i];
        }
        keys = keys1;
        values = values1;
    }
    public int rank(Key key){
        return rank(key,0,N-1);
    }
    private int rank(Key key,int lo, int hi){
        if (lo>hi){
            return lo;
        }
        int mid = lo+(hi-lo)/2;
        if (keys[mid].equals(key)){
            return mid;
        }else if (less(key,keys[mid])){
            return rank(key,lo,mid-1);
        }else {
            return rank(key,mid+1,hi);
        }
    }
    private boolean less(Key i,Key j){
        return i.compareTo(j)<0;
    }
    public boolean contains(Key key){
        int k = rank(key);
        if (k<N&&key.equals(keys[k])){
            return true;
        }
        return false;
    }
    public int size(){
        return N;
    }
    public void put(Key key, Value value){
        int k = rank(key);
        if (k<N&&key.equals(keys[k])){
            values[k] = value;
            return;
        }
        if (N==keys.length){
            resize(keys.length*2);
        }
        N++;
        if (k==N-1){
            keys[k] = key;
            values[k] = value;
            return;
        }
        for (int i = N-1; i>k;i--){
            keys[i] = keys[i-1];
            values[i] = values[i-1];
        }
        keys[k] = key;
        values[k] = value;
    }
    public Value get(Key key){
       int k = rank(key);
       if (k<N&&key.equals(keys[k])){
           return values[k];
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
    public Key min(){
        return keys[0];
    }
    public Key max(){
        return keys[N-1];
    }
    public Key floor(Key key){
        int k = rank(key);
        return keys[k];
    }
    public Key ceiling(Key key){
        int k = rank(key);
        System.out.println("rank"+k);
        if (k<N&&key.equals(keys[k])){
            return key;
        }
        if (k >= N-1){
            return null;
        }
        return keys[k];
    }
    public Key select(int k){
        if (k>N){
            return null;
        }
        return keys[k-1];
    }
    public Value delete(Key key){
        int k = rank(key);
        if (!keys[k].equals(key)){
            return null;
        }
        Value v = values[k];
        for (int i = k; i<N-1;i++){
            keys[i] = keys[i+1];
            values[i] = values[i+1];
        }
        N--;
        return v;
    }
    public void deleteMin(){
        N--;
        for (int i = 0; i<N;i++){
            keys[i] = keys[i+1];
            values[i] = values[i+1];
        }
    }
    public void deleteMax(){
        N--;
        keys[N] = null;
        values[N] = null;
    }
    public int size(Key key1, Key key2){
        int i = rank(key1);
        int j = rank(key2);
        return j-i;
    }
    public List<Key> keys(Key key1,Key key2){
        List<Key> list = new ArrayList<Key>();
        int i = rank(key1);
        int j = rank(key2);
        for (int k = i; k<j;k++){
            list.add(keys[k]);
        }
        if (key2.equals(keys[j])){
            list.add(key2);
        }
        return list;
    }
    public static void main(String[] args){
        Chapt3STSequentialArray3<String,Integer> st = new Chapt3STSequentialArray3(5);
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
        st.delete("a");
        System.out.println(st.keys());
        st.deleteMax();
        System.out.println(st.keys());
        st.deleteMin();
        System.out.println(st.keys());
        int max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }

        System.out.println(max);
    }
}
