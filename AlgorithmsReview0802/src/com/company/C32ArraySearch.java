package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 8/4/17.
 */
public class C32ArraySearch<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    public C32ArraySearch(){
        keys =(Key[]) new Comparable[10];
        values = (Value[])new Object[10];
    }
    public int size(){
        return N;
    }
    private void resize(int maxn){
        Key[] keys1 =(Key[]) new Comparable[maxn];
        Value[] values1 = (Value[]) new Object[maxn];
        for (int i = 0; i<N; i++){
            keys1[i] = keys[i];
            values1[i] = values[i];
        }
        keys = keys1;
        values = values1;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i<N; i++){
            list.add(keys[i]);
        }
        return list;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public boolean contains(Key key){
        int i = rank(key);
        if (i<N&&keys[i].equals(key)){
            return true;
        }
        return false;
    }
    public void delete(Key key){
     if (contains(key)) {
        int i = rank(key);
        for (int kk = i; kk<N-1;kk++){
            keys[kk] = keys[kk+1];
            values[kk] = values[kk+1];
        }
        keys[N-1] = null;
         values[N-1] = null;
        N--;
        if (N==keys.length/4){
            resize(keys.length/2);
        }
     }
    }
    public Value get(Key key){
        int i = rank(key);
        if (i<N&&keys[i].equals(key)){
            return values[i];
        }
        return null;
    }
    public void put(Key key, Value value){
       int i = rank(key);
       if (i<N&&keys[i].equals(key)){
           values[i] = value;
           return;
       }
       for (int kk = N; kk>i; kk--){
           keys[kk] = keys[kk-1];
           values[kk] = values[kk-1];
       }
       keys[i] = key;
        values[i] = value;
        N++;
        if (N==keys.length){
            resize(keys.length*2);
        }
    }
    public int rank(Key key){
      int i = rank(key,0,N-1);
      return i;
    }
    private int rank(Key key, int lo, int hi){
        while (lo<=hi){
            int mid = (lo+hi)/2;
            //System.out.println("ww");
            if (keys[mid].equals(key)){
                return mid;
            }else if (keys[mid].compareTo(key)>0){
                hi = mid-1;
            }else {
                lo = mid+1;
            }
        }
        return lo;
    }
    public Key min(){
        return keys[0];
    }
    public Key max(){
        return keys[N-1];
    }
    public Key floor(Key key){
        if (contains(key)){
            return key;
        }
        int i = rank(key);
        if (i==0){
            return null;
        }
        return keys[i-1];
    }
    public Key ceiling(Key key){
        int i = rank(key);
        return keys[i];
    }

    public Key select(int k){
        if (k>N-1){
            return null;
        }
        return keys[k];
    }
    public void deleteMin(){
        delete(keys[0]);
    }
    public void deleteMax(){
        delete(keys[N-1]);
    }
    public int size(Key lo, Key hi){
        int i = rank(lo);
        int j = rank(hi);
        if (contains(lo)){
            return j-i+1;
        }
        return j-i;
    }
    public List<Key> keys(Key lo, Key hi){
        List<Key> list = new ArrayList<Key>();
        int i = rank(lo);
        int j = rank(hi);
        for (int t = i; t<j; t++){
            list.add(keys[t]);
        }
        if (contains(hi)){
            list.add(hi);
        }
        return list;
    }
    public static void main(String[] args){
        C32ArraySearch<String,Integer> st = new C32ArraySearch<>();
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
        int max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }

        System.out.println(st.min());
        System.out.println(st.max());
        System.out.println(st.ceiling("a"));
        System.out.println(st.ceiling("c"));
        System.out.println(st.floor("a"));
        System.out.println(st.floor("f"));
        System.out.println(st.select(2));
       System.out.println(st.keys("a","f"));
      st.deleteMin();
        System.out.println(st.keys());
        System.out.println(st.size());
        st.deleteMax();
        System.out.println(st.keys());
        System.out.println(st.size());
         max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }

        System.out.println(max);
    }
}
