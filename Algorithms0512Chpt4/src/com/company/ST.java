package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/15/17.
 */
public class ST <Key, Value>{
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] values;
    public ST(){
        keys =(Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }
    public ST(int cap){
        keys = (Key[]) new Object[cap];
        values = (Value[]) new Object[cap];
    }
    public void resize(int cap){
        ST<Key,Value> stResize = new ST(cap);
        for (int i = 0 ; i <M; i++){
            if (keys[i]!=null){
                stResize.put(keys[i],values[i]);
            }
        }
        this.M = cap;
        keys = stResize.keys;
        values = stResize.values;
    }
    public int hash(Key key){
       return (key.hashCode()& 0x7fffffff)%M;
    }
    public void put(Key key, Value value){
        if (N>M/2){
            resize(2*M);
        }
        int i;
        for (i = hash(key); keys[i]!=null;i=(i+1)%M){
            if (key.equals(keys[i])){
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }
    public Value get(Key key){
        int i;
        for (i = hash(key); keys[i] != null; i = (i+1)%M){
            if (key.equals(keys[i])){
                return values[i];
            }
        }
        return null;
    }
    public boolean contains(Key key){
        int i;
        for (i = hash(key); keys[i]!=null; i = (i+1)%M){
            if (key.equals(keys[i])){
                return true;
            }
        }
        return false;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i < M; i++){
            if (keys[i]!=null){
                list.add(keys[i]);
            }
        }
        return list;
    }
    public int size(){
        return N;
    }
}
