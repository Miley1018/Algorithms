package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 8/8/17.
 */
public class C34SeperateChainHashST<Key, Value> {
    private C31SequentialSearch<Key,Value>[] chains;
    private int M;
    private int N;
    public C34SeperateChainHashST(int M){
        this.M = M;
        chains = new C31SequentialSearch[M];
        for (int i = 0; i<M;i++){
            chains[i] = new C31SequentialSearch();
        }
    }
    private int hash(Key key){
        return (key.hashCode()&0x0fffffff)%M;
    }
    public void put(Key key, Value value){
        int i = hash(key);
        chains[i].put(key,value);
        N++;
    }
    public Value get(Key key){
        int i = hash(key);
        return chains[i].get(key);
    }
    public int size(){
        return N;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i<M;i++){
            list.addAll(chains[i].keys());
        }
        return list;
    }
    public boolean contains(Key key){
        int i = hash(key);
        return chains[i].contains(key);
    }
    public void delete(Key key){
        int i = hash(key);
        chains[i].delete(key);
        N--;
    }
    public static void main(String[] args){
        C34SeperateChainHashST<String,Integer> st = new C34SeperateChainHashST<>(10);
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
