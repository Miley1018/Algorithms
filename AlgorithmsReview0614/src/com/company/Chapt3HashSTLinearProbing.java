package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 6/22/17.
 */
public class Chapt3HashSTLinearProbing<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int M = 1000;
    private int N;
    public Chapt3HashSTLinearProbing(){
        keys = (Key[]) new Object[M];
        values = (Value[])new Object[M];
    }
    private int hash(Key key){
        return (key.hashCode()&0x7fffffff)%M;
    }
    public boolean contains(Key key){
        return get(key)!=null;
    }
    private void resize(int M){
        this.M = M;
        Key[] newKeys =(Key[]) new Object[M];
        Value[] newValues =(Value[]) new Object[M];
        Key[] keybefore = keys;
        Value[] valuebefore = values;
        keys = newKeys;
        values= newValues;
        for (int i = 0; i<keybefore.length;i++){
            if (keybefore[i]!=null) {
                put(keybefore[i],valuebefore[i] );
            }
        }
    }
    public void put(Key key, Value value){
        if (N>=M/2){
            resize(M*2);
        }
        int hash = hash(key);
        while (keys[hash]!=null&&!keys[hash].equals(key)){
            hash++;
            if(hash==M){
                hash = hash%M;
            }
        }
        if(keys[hash]==null){
            keys[hash] = key;
            values[hash] = value;
            N++;
        }else {
            values[hash] = value;
        }
    }
    public Value get(Key key){
        int hash = hash(key);
        while (keys[hash]!=null){
            if (keys[hash].equals(key)){
                return values[hash];
            }
            hash = hash+1;
            if (hash==M){
                hash= hash%M;
            }
        }
        return null;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i<M;i++){
            if (keys[i]!=null){
                list.add(keys[i]);
            }
        }
        return list;
    }
    public void delete(Key key){
       if (get(key)==null){
           return;
       }
       N--;
       int hash = hash(key);
       while (keys[hash]!=null){
           if (keys[hash].equals(key)){
               keys[hash] = null;
               values[hash] = null;
               hash = hash+1==M?hash%M:hash;
               while (keys[hash]!=null) {
                  Key keytoredo = keys[hash];
                  Value valuetoredo = values[hash];
                  put(keytoredo,valuetoredo);
                  hash = hash+1==M?hash%M:hash;
               }
           }else {
               hash = hash+1==M?hash%M:hash;
           }
       }
       if (N == M/8){
           resize(M/2);
       }
    }
    public static void main(String[] args){
        Chapt3HashSTLinearProbing<String,Integer> st = new Chapt3HashSTLinearProbing();
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
        //st.delete("s");
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
