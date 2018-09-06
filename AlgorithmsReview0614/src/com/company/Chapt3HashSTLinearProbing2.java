package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 6/27/17.
 */
public class Chapt3HashSTLinearProbing2<Key , Value> {
    private int M;
    private Key[] keys;
    private Value[] values;
    private int N;
    public Chapt3HashSTLinearProbing2(int M){
        this.M = M;
        keys =(Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }
    private int hash(Key key){
        return (key.hashCode()&0x7ffffff)%M;
    }
    private void resize(int maxN){
        Chapt3HashSTLinearProbing2<Key,Value> lp2 = new Chapt3HashSTLinearProbing2<Key, Value>(maxN);
        for (int i = 0; i<M;i++){
            if (keys[i]==null){
                continue;
            }
            lp2.put(keys[i],values[i]);
        }
        this.keys = lp2.keys;
        this.values = lp2.values;
        this.M = lp2.M;
    }
    public void put(Key key, Value value){
        if (N>=M/2){
            resize(M*2);
        }
        int i = hash(key);
        while (keys[i]!=null&&!keys[i].equals(key)){
            i = (i+1)%M;
        }
        if (keys[i]==null){
            keys[i] = key;
            values[i] = value;
            N++;
            return;
        }
        values[i] = value;
    }
    public Value get(Key key){
        int i = hash(key);
        while (keys[i]!=null&&!keys[i].equals(key)){
            i = (i+1)%M;
        }
        if (keys[i]==null){
            return null;
        }
        return values[i];
    }
    public boolean contains(Key key){
        return get(key)!=null;
    }
    public List<Key> keys(){
        List<Key> list= new ArrayList<Key>();
        for (int i = 0; i<M;i++){
            if (keys[i]!=null){
                list.add(keys[i]);
            }
        }
        return list;
    }
    public void delete(Key key){
        int i = hash(key);
        while (keys[i]!=null&&!keys[i].equals(key)){
            i = (i+1)%M;
        }
        if (keys[i]==null){
            return;
        }
        keys[i]=null;
        values[i] = null;
        int k = (i+1)%M;
        while (keys[k]!=null){
            Key redokey = keys[k];
            Value redov = values[k];
            keys[k] = null;
            values[k] = null;
            put(redokey,redov);
            N--;
            k = (k+1)%M;
        }
        N--;
        if (N>0&&N<=M/8){
            resize(M/2);
        }
    }
    public static void main(String[] args){
        Chapt3HashSTLinearProbing2<String,Integer> st = new Chapt3HashSTLinearProbing2(99);
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
