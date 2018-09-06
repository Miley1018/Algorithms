package com.company;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/10/17.
 */
public class SeparateChainingHashST<Key, Value> {
    private STWithNonSequentialNode3<Key, Value>[] st;
    private int N;        //----------------------------------------??
    private int M;
    public SeparateChainingHashST(){
        this(997);
    }
    public SeparateChainingHashST(int M){
        this.M = M;
        st = new STWithNonSequentialNode3[M];
        for (int i = 0; i <M; i++){
            st[i] = new STWithNonSequentialNode3();
        }
    }
    public int hash(Key key){
        return (key.hashCode() & 0x7fffffff)%M;
    }
    public void put(Key key,Value value){
        int i = hash(key);
        st[i].put(key,value);
    }
    public Value get(Key key){
        return (Value)st[hash(key)].get(key);
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i<M; i++) {
            list.addAll(st[i].keys());
        }
        return list;
    }
    public boolean contain(Key key){
        int i = hash(key);
        return st[i].contain(key);
    }
    public int size(){
        int size = 0;
        for (int i = 0; i < M; i++){
            size = size+st[i].size();
        }
        return size;
    }
    public void delete(Key key){
        int i = hash(key);
        System.out.println(i);
        st[i].delete(key);
    }
    public static void main(String[] args){
        String[] strings = {"c","a","v","b","c","b","b","b"};
        SeparateChainingHashST<String, Integer> st3 = new SeparateChainingHashST<>();
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
        st3.delete("v");
        System.out.println(st3.keys());
        System.out.println("max:"+st3.get(max)+"size:"+st3.size());
    }
}
