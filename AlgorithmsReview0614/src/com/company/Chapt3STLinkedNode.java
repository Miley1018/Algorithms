package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 6/21/17.
 */
public class Chapt3STLinkedNode<Key, Value> {
    private Node head;
    private int N;
    private class Node{
        Key key;
        Value value;
        Node next;
    }
    public boolean contains(Key key){
        if (get(key)==null){
            return false;
        }
        return true;
    }
    public void put(Key key, Value value){
        if (value==null){
            delete(key);
            return;
        }
        if (contains(key)){
            Node tmp = head;
            while(tmp!=null&&!tmp.key.equals(key)){
                tmp = tmp.next;
            }
            tmp.value=value;
        }else {
            Node oldhead = head;
            head = new Node();
            head.key = key;
            head.value = value;
            head.next = oldhead;
            N++;
        }
    }
    public boolean isEmpty(){
        return head==null;
    }
    public int size(){
        return N;
    }
    public Value get(Key key){
        Node tmp = head;
        while(tmp!=null&&!tmp.key.equals(key)){
            tmp = tmp.next;
        }
        if (tmp==null){
            return null;
        }
        return tmp.value;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        Node tmp = head;
        while(tmp!=null){
            list.add(tmp.key);
            tmp = tmp.next;
        }
        return list;
    }
    public void delete(Key key){
        Node tmp = head;
        Node before= head;
        while(tmp!=null&&!tmp.key.equals(key)){
            before = tmp;
            tmp = tmp.next;
        }
        if (tmp==null){
            return;
        }
        if (before==tmp){
            head=null;
            N--;
            return;
        }
        Node next = tmp.next;
        before.next = next;
        N--;
    }
    public static void main(String[] args){
        Chapt3STLinkedNode<String,Integer> st = new Chapt3STLinkedNode();
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
