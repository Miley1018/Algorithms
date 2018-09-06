package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 6/21/17.
 */
public class Chapt3STSequentialArray <Key extends Comparable<Key>, Value>{
    private Key[] keys;
    private Value[] values;
    private int N;
    public Chapt3STSequentialArray(int N){
        this.N = 0;
        keys =(Key[]) new Comparable[N];
        values =(Value[]) new Object[N];
    }
    private void resize(int maxN){
        Key[] newkey = (Key[]) new Comparable[maxN];
        Value[] newvalue = (Value[]) new Object[maxN];
        for (int i = 0; i<N;i++){
            newkey[i] = keys[i];
        }
        for (int i = 0; i<N;i++){
            newvalue[i] = values[i];
        }
        keys = newkey;
        values = newvalue;
    }
    private int erfen(Key key, int lo, int hi){
        if (lo>hi){
            return lo;
        }
        int mid = (lo+hi)/2;
        if (keys[mid].equals(key)){
            return mid;
        }else if (keys[mid].compareTo(key)>0){
            return erfen(key,lo,mid-1);
        }else {
            return erfen(key,mid+1,hi);
        }
    }
    public boolean contains(Key key){
        int k = erfen(key,0,N-1);
        if (k<N&&keys[k].equals(key)){
            return true;
        }
        return false;
    }
    public void put(Key key, Value value){
        if (N == keys.length){
            resize(2*N);
        }
        int k = rank(key);
        if (contains(key)){
            values[k] = value;
        }else {
            for (int i = N; i>k;i--){
                keys[i] = keys[i-1];
                values[i] = values[i-1];
            }
            keys[k] = key;
            values[k] = value;
            N++;
        }
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public Value get(Key key){
        if (!contains(key)){
            return null;
        }
        int k = rank(key);
        return values[k];
    }
    public int size(){
        return N;
    }
    public void delete(Key key){
        if (N>0&&N==keys.length/4){
            resize(keys.length/2);
        }
        if (!contains(key)){
            return;
        }
        int k = rank(key);
        for (int i = k; i<N-1;i++){
            keys[i] = keys[i+1];
            values[i] = values[i+1];
        }
        keys[N-1] = null;
        values[N-1] = null;
        N--;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i<N;i++){
            list.add(keys[i]);
        }
        return list;
    }
    public Key min(){
        if (isEmpty()){
            return null;
        }
        return keys[0];
    }
    public Key max(){
        if (isEmpty()){
            return null;
        }
        return keys[N-1];
    }
    public void deleteMin(){
       delete(min());
    }
    public void deleteMax(){
        delete(max());
    }
    public Key floor(Key key){
        int k = rank(key);
        if (!contains(key)){
            return k>0?keys[k-1]:null;
        }else {
            return keys[k];
        }
    }
    public Key ceiling(Key key){
        int k = rank(key);
        return keys[k];
    }
    public int rank(Key key){
        int k = erfen(key,0,N-1);
        return k;
    }
    public Key select(int k){
        if (k<0||k>=N){
            return null;
        }
        return keys[k];
    }
    public static void main(String[] args){
        Chapt3STSequentialArray<String,Integer> st = new Chapt3STSequentialArray(5);
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
        System.out.println(st.keys());
        //System.out.println(st.floor("a"));
        st.delete("a");
        //System.out.println(st.floor("c"));
        //System.out.println(st.floor("a"));
        //System.out.println(st.ceiling("a"));
       // System.out.println(st.rank("e"));
        System.out.println(st.ceiling("e"));
        st.delete("e");
        System.out.println(st.ceiling("e"));
        System.out.println(st.ceiling("s"));
        st.delete("s");
        System.out.println(st.keys());
        System.out.println(st.ceiling("s"));
        System.out.println(st.select(2));
        int max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }

        System.out.println(max);
    }
}
