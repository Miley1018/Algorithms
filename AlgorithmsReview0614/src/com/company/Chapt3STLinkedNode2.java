package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 6/27/17.
 */
public class Chapt3STLinkedNode2 <Key, Value>{
    private int N;
    private Node head;
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
    public boolean contains(Key key){
        Node con = head;
        while (con!=null) {
            if (con.key.equals(key)) {
                return true;
            }
            con = con.next;
        }
        return false;
    }
    public void put(Key key, Value value){
        if (value==null){
            delete(key);
            return;
        }
        Node con = head;
        while (con!=null) {
            if (con.key.equals(key)) {
                con.value = value;
                return;
            }
            con = con.next;
        }
        N++;
        Node oldhead = head;
        head = new Node(key,value,oldhead);
    }
    public Value get(Key key){
        Node con = head;
        while (con!=null){
            if (con.key.equals(key)){
                return con.value;
            }
            con = con.next;
        }
        return null;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        Node con  = head;
        while (con!=null){
            list.add(con.key);
            con = con.next;
        }
        return list;
    }
    public void delete(Key key){
        if (!contains(key)){
            return;
        }
        N--;
        Node con = head;
        Node before = head;
        while (con!=null){
            if (con.key.equals(key)){
                if (before==con){
                    head = head.next;
                    return;
                }
                before.next = con.next;
                return;
            }
            before = con;
            con = con.next;
        }
    }
    public int size(){
        return N;
    }
    public static void main(String[] args){
        Chapt3STLinkedNode2<String,Integer> st = new Chapt3STLinkedNode2<>();
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
        st.delete("a");
        System.out.println(st.keys());
        System.out.println(st.size());
        int max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }

        System.out.println(max);
    }
}
