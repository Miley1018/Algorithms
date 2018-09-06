package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 6/22/17.
 */
public class Chapt3HashSTSeperateChains<Key extends Comparable<Key>,Value> {
    private int M;
    private Chapt3STLinkedNode[] chains;
    public Chapt3HashSTSeperateChains(){
        this(997);
    }
    public Chapt3HashSTSeperateChains(int M){
        this.M = M;
        chains = new Chapt3STLinkedNode[M];
        for (int i = 0; i<M;i++){
            chains[i] = new Chapt3STLinkedNode();
        }
    }
    private int hash(Key key){
        int hash;
        return (key.hashCode()&0x7fffffff)%M;
    }
    public boolean contains(Key key){
        int hash = hash(key);
        return chains[hash].contains(key);
    }
    public void put(Key key, Value value){
        int hash = hash(key);
        chains[hash].put(key,value);
    }
    public Value get(Key key){
        int hash = hash(key);
        return (Value) chains[hash].get(key);
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i<M;i++) {
            list.addAll(chains[i].keys());
        }
        return list;
    }
    public void delete(Key key){
        int hash = hash(key);
        chains[hash].delete(key);
    }
    public static void main(String[] args){
        Chapt3HashSTSeperateChains<String,Integer> st = new Chapt3HashSTSeperateChains();
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
        //System.out.println(st.ceiling("e"));
        st.delete("e");
        //System.out.println(st.ceiling("e"));
        //System.out.println(st.ceiling("s"));
        st.delete("s");
        System.out.println(st.keys());
        // System.out.println(st.ceiling("s"));
       //System.out.println(st.select(2));
        int max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }

        System.out.println(max);
    }
}
