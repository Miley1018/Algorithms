package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/10/17.
 */
public class LinearProbingHashST<Key, Value> {
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] values;
    public LinearProbingHashST(){
        keys = (Key[])new Object[M];
        values = (Value[]) new Object[M];
    }
    public LinearProbingHashST(int M){
        this.M = M;
        keys = (Key[]) new Object[M];
        values = (Value[])  new Object[M];
    }
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff)%M;
    }
    public void put(Key key,Value value){
        int i;
        for (i = hash(key); keys[i]!=null; i = (i+1)%M){
            if (keys[i].equals(key)){
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }
    public Value get(Key key){
        int i ;
        for (i = hash(key); keys[i]!=null; i = (i+1)%M){
            if (key.equals(keys[i])){
                return values[i];
            }
        }
        return null;
    }
    public boolean contain(Key key){
        int i;
        for (i = hash(key); keys[i]!= null; i = (i+1)%M){
            if (key.equals(keys[i])){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return N;
    }
    public void resize(int cap){
        LinearProbingHashST<Key,Value> st = new LinearProbingHashST(cap);
        for (int i = 0; i <M ; i++){
            if (keys[i]!=null){
                st.put(keys[i], values[i]);
            }
        }
        keys = st.keys;
        values = st.values;
        M = st.M;

    }
    public void delete(Key key){
        if (!contain(key)){
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])){
            i = (i+1)%M;
        }
        keys[i] = null;
        values[i] = null;
        i = (i+1)%M;
        while (keys[i]!=null){
            Key nowKey = keys[i];
            Value nowValue = values[i];
            keys[i] = null;
            values[i] = null;
            put(nowKey, nowValue);
            i = (i+1)%M;
        }
        N--;

    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i < M; i ++){
            if (keys[i]!=null){
                list.add(keys[i]);
            }
        }
        return list;
    }
    public static void main(String[] args){
        String[] strings = {"c","a","v","b","c","b","b","b"};
        LinearProbingHashST<String, Integer> st3 = new LinearProbingHashST<>();
        for (String s : strings){
            if (st3.contain(s)){
                st3.put(s,st3.get(s)+1);
            }else {
                st3.put(s,1);
            }
        }
        System.out.println(st3.keys());
        String max = "";
        st3.put(max,0);
        for (String s : strings){
            if (st3.get(s).compareTo(st3.get(max))>0){
                st3.put(max,st3.get(s));
            }
        }
        System.out.println(st3.keys());
        st3.delete("v");
        System.out.println(st3.keys());
        System.out.println(st3.keys());
        System.out.println("max:"+st3.get(max)+"size:"+st3.size());
    }
}
