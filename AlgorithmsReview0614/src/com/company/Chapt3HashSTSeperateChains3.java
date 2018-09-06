package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 7/12/17.
 */
public class Chapt3HashSTSeperateChains3<Key ,Value> {
    private Chapt3STLinkedNode3[] chains;
    private int M;
    public Chapt3HashSTSeperateChains3(){
        this(997);
    }
    public Chapt3HashSTSeperateChains3(int n){
        this.M = n;
        chains = new Chapt3STLinkedNode3[n];
        for (int i = 0; i<n;i++){
            chains[i] = new Chapt3STLinkedNode3();
        }
    }
    private int hash(Key key){
        return (key.hashCode()&0x0fffffff)%M;
    }
    public boolean contains(Key key){
        int h = hash(key);
        return chains[h].contains(key);
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i<M;i++){
            list.addAll(chains[i].keys());
        }
        return list;
    }
    public void put(Key key,Value value){
        int h = hash(key);
        chains[h].put(key,value);
    }
    public Value get(Key key){
        int h = hash(key);
        return (Value)chains[h].get(key);
    }
    public void delete(Key key){
        int h = hash(key);
        chains[h].delete(key);
    }
    public static void main(String[] args){
        Chapt3HashSTSeperateChains3<String,Integer> st = new Chapt3HashSTSeperateChains3();
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
