package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 6/27/17.
 */
public class Chapt3HashSTSeperateChains2<Key, Value> {
    private int M;
    private Chapt3STLinkedNode2<Key, Value>[] list;
    public Chapt3HashSTSeperateChains2(int M){
        this.M = M;
        list = new Chapt3STLinkedNode2[M];
        for (int i = 0; i<M;i++){
            list[i] = new Chapt3STLinkedNode2<Key, Value>();
        }
    }
    private int hash(Key key){
        return (key.hashCode()&0x7fffffff)%M;
    }
    public boolean contains(Key key){
        int i = hash(key);
        if (list[i]==null){return false;}
        return list[i].contains(key);
    }
    public void put(Key key, Value value){
        int i = hash(key);
        list[i].put(key,value);
    }
    public void delete(Key key){
        int i = hash(key);
        if (list[i]==null){return;}
        list[i].delete(key);
    }
    public Value get(Key key){
        int i = hash(key);
        return list[i].get(key);
    }
    public List<Key> keys(){
        List<Key> a = new ArrayList<Key>();
        for (int i = 0; i<M; i++){
           if (list[i]!=null){
               a.addAll(list[i].keys());
           }
        }
        return a;
    }
    public static void main(String[] args){
        Chapt3HashSTSeperateChains2<String,Integer> st = new Chapt3HashSTSeperateChains2(10);
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
