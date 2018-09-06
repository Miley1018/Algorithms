package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 7/12/17.
 */
public class Chapt3HashSTLinearProbing3<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    private int M;
    public Chapt3HashSTLinearProbing3(int n){
        this.M = n;
        keys = (Key[])new Object[n];
        values = (Value[])new Object[n];
    }
    private void resize(int max){
        Chapt3HashSTLinearProbing3 lp = new Chapt3HashSTLinearProbing3(max);
        for (int i = 0; i<M;i++){
            lp.put(keys[i],values[i]);
        }
        this.keys= (Key[])lp.keys;
        this.values = (Value[])lp.values;
        this.M = lp.M;
    }
    private int hash(Key key){
        return (key.hashCode()&0x0fffffff)%M;
    }
    public void put(Key key, Value value){
        if (key == null){
            return;
        }
        if (value==null){
            delete(key);
            return;
        }
        if (N>=M/2){
            resize(M*2);
        }
        int h = hash(key);
        int j = h;
        for (int i = h;!key.equals(keys[i])&&keys[i]!=null;i = (i+1)%M){
            j = (i+1)%M;
        }
        if (keys[j]==null) {
            keys[j] = key;
            values[j] = value;
            N++;
        } else {
            values[j] = value;
        }
    }
    public Value get(Key key){
        int h = hash(key);
        int j = h;
        for (int i = h;!key.equals(keys[i])&&keys[i]!=null;i = (i+1)%M){
            j = (i+1)%M;
        }
        if (keys[j] == null){
            return null;
        }
        return values[j];
    }
    public int size(){
        return N;
    }
    public boolean contains(Key key){
        int h = hash(key);
        int j = h;
        for (int i = h;!key.equals(keys[i])&&keys[i]!=null;i = (i+1)%M){
            j = (i+1)%M;
        }
        if (keys[j] == null){
            return false;
        }
        return true;
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
        int h = hash(key);
        int j = h;
        for (int i = h;!key.equals(keys[i])&&keys[i]!=null;i = (i+1)%M){
            j = (i+1)%M;
        }
        if (keys[j] == null){
            return;
        }
        keys[j] = null;
        values[j] = null;
        j = (j+1)%M;
        while (keys[j]!=null){
            Key a = keys[j];
            Value b = values[j];
            keys[j] = null;
            values[j] = null;
            put(a,b);
            N--;
            j = (j+1)%M;
        }
        if (N>0&&N==M/8){
            resize(M/2);
        }
    }
    public static void main(String[] args){
        Chapt3HashSTLinearProbing3<String,Integer> st = new Chapt3HashSTLinearProbing3(99);
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
