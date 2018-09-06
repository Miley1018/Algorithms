package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 8/8/17.
 */
public class C35LinearProbingHashST <Key , Value>{
    private Key[] keys;
    private Value[] values;
    private int N;
    private int M;
    public C35LinearProbingHashST(int m){
        M=m;
        keys = (Key[])new Object[m];
        values = (Value[]) new Object[m];
    }
    private int hash(Key key){
        return (key.hashCode()&0x0fffffff)%M;
    }
    private void resize(int maxN){
        C35LinearProbingHashST<Key,Value> st = new C35LinearProbingHashST(maxN);
        for (int i = 0; i<M;i++){
            if (keys[i]!=null) {
                st.put(keys[i], values[i]);
            }
        }
        this.keys = st.keys;
        this.values = st.values;
        this.M = st.M;
    }
    public void put(Key key, Value value){
        int i = hash(key);
        while (keys[i]!=null){
            if (key.equals(keys[i])){
                values[i] = value;
                return;
            }
            i = (i+1)%M;
        }
        keys[i] = key;
        values[i] = value;
        N++;
        if (N==M/2){
            resize(M*2);
        }
    }
    public Value get(Key key){
        int i = hash(key);
       return values[i];
    }
    public boolean contains(Key key){
        int i = hash(key);
        while (keys[i]!=null){
            if (key.equals(keys[i])){
                return true;
            }
            i = (i+1)%M;
        }
        return false;
    }
    public int size(){
        return N;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i<M;i++){
            if (keys[i]!=null) {
                list.add(keys[i]);
            }
        }
        return list;
    }
    public void delete(Key key){//------------------important!
        int i = hash(key);
        if (keys[i]==null) {
            return;
        }
        keys[i] = null;
        values[i]=null;
        N--;
        if (N>0&&N==M/8){//------------------important!
            resize(M/2);
        }
        i =(i+1)%M;
        while (keys[i]!=null){
           Key k = keys[i];
           Value v = values[i];
           keys[i] = null;
           values[i]= null;
           put(k,v);
           N--;
            i =(i+1)%M;
        }
    }
    public static void main(String[] args){
        C35LinearProbingHashST<String,Integer> st = new C35LinearProbingHashST<>(10);
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

        System.out.println(max);
        st.delete("s");
        System.out.println(st.keys());
        System.out.println(st.size());
        max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }

        System.out.println(max);
    }
}
