package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 8/4/17.
 */
public class C31SequentialSearch<Key, Value> {
    private Node head;
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
        Node x = head;
        while (x!=null){
            if (x.key.equals(key)){
                x.value = value;
                return;
            }
            x = x.next;
        }
        N++;
        Node oldhead = head;
        head = new Node(key,value,oldhead);

    }
    public Value get(Key key){
        Node x = head;
        while (x!=null){
            if (x.key.equals(key)){
                return x.value;
            }
            x = x.next;
        }
        return null;
    }
    public void delete(Key key){
        Node x = head;
        Node before = null;
        while (x!=null){
            if (x.key.equals(key)&&before==null){
                N--;
                x = x.next;
                return;
            }else if (x.key.equals(key)){
                N--;
                before.next = x.next;
                return;
            }else {
                before = x;
                x = x.next;
            }
        }
    }
    public boolean contains(Key key){
        Node x = head;
        while (x!=null){
            if (x.key.equals(key)){
                return true;
            }
            x = x.next;
        }
        return false;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public int size(){
        return N;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        Node x = head;
        while (x!=null){
            list.add(x.key);
            x = x.next;
        }
        return list;
    }
    public static void main(String[] args){
        C31SequentialSearch<String,Integer> st = new C31SequentialSearch<>();
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
        st.delete("a");
        System.out.println(st.keys());
        System.out.println(st.size());
        max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }

        System.out.println(max);
    }
}
