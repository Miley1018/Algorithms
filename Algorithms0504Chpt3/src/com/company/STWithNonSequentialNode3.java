package com.company;

import java.util.ArrayList;
import java.util.List;

public class STWithNonSequentialNode3<Key, Value> {
    private Node first;
    private int N;
    private class Node{
        Key key;
        Value value;
        Node next;
        private Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }
    public void put(Key key, Value value){
        for (Node x = first; x!=null; x=x.next){
            if (x.key.equals(key)){
                x.value = value;
                return;
            }
        }
        first = new Node(key, value,first);
        N++;
    }
    public Value get(Key key){
        for (Node x = first; x!= null; x= x.next){
            if (x.key.equals(key)){
                return x.value;
            }
        }
        return null;
    }
    public void delete(Key key){
        Node before = null;
        for (Node x = first; x!=null; x = x.next){
            if (x.key.equals(key)){
                if (before == null){
                    first = first.next;
                }else {
                    before.next = x.next;
                }
                N--;
                return;
            }
            before = x;
        }
    }
    public int size(){
        return N;
    }
    public boolean contain(Key key){
        for (Node x = first; x != null; x = x.next){
            if (x.key.equals(key)){
                return true;
            }
        }
        return false;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next){
            list.add(x.key);
        }
        return list;
    }
    public static void main(String[] args){

        String[] strings = {"c","a","v","b","c","b","b","b"};
        STWithNonSequentialNode3<String, Integer> st3 = new STWithNonSequentialNode3();
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
