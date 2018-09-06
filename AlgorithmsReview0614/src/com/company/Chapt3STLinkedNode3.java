package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 7/10/17.
 */
public class Chapt3STLinkedNode3<Key,Value> {
    private int N;
    private Node first;
    private class Node{
        Key key;
        Value value;
        Node next;
        private Node(Key key,Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public boolean contains(Key key){
        Node i = first;
        while (i!=null){
            if (i.key.equals(key)){
                return true;
            }
            i = i.next;
        }
        return false;
    }
    public void put(Key key ,Value value){
        Node i = first;
        while (i!=null){
            if (i.key.equals(key)){
                i.value = value;
                return;
            }
            i = i.next;
        }
        N++;
       first = new Node(key,value,first);
    }
    public Value get(Key key){
        Node i = first;
        while (i!=null){
            if (i.key.equals(key)){
                return i.value;
            }
            i = i.next;
        }
        return null;
    }
    public void delete(Key key){
        if (!contains(key)){
            return;
        }
        Node i = first;
        Node before = i;
        N--;
        while (i!=null){
            if (i.key.equals(key)){
                if (i == first){
                    first = first.next;
                    break;
                }
                before.next = i.next;
                break;
            }
            before = i;
            i = i.next;
        }

    }
    public int size(){
        return N;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        Node i = first;
        while (i!=null){
            list.add(i.key);
            i = i.next;
        }
        return list;
    }
    public static void main(String[] args){
        Chapt3STLinkedNode3<String,Integer> st = new Chapt3STLinkedNode3<>();
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
