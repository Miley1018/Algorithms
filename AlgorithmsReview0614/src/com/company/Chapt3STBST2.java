package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 6/27/17.
 */
public class Chapt3STBST2 <Key extends Comparable<Key>, Value>{
    private Node root;
    private class Node{
        Key key;
        Value value;
        Node left;
        Node right;
        int N;
        private Node(Key key, Value value, Node left, Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public int size(){
        return size(root);
    }
    public int size(Node x){
        if (x==null){
            return 0;
        }
        return x.N;
    }
    public void put(Key key, Value value){
        if (value==null){
            delete(key);
            return;
        }
        root = put(key,value,root);
    }
    public Node put(Key key, Value value, Node node){
        if (node==null){
            node = new Node(key,value,null,null);
            node.N = 1;
            return node;
        }
        if (node.key.equals(key)){
            node.value = value;
        }else if (node.key.compareTo(key)>0){
            node.left = put(key,value,node.left);
        }else {
            node.right = put(key,value,node.right);
        }
        node.N = size(node.left)+size(node.right)+1;
        return node;
    }
    public Value get(Key key){
        Node t = get(key,root);
        if (t==null){
            return null;
        }
        return t.value;
    }
    private Node get(Key key, Node x){
        if (x==null){
            return null;
        }
        if (x.key.compareTo(key)>0){
           return get(key,x.left);
        }else if(x.key.compareTo(key)<0){
            return get(key,x.right);
        }else {
            return x;
        }
    }
    public boolean contains(Key key){
        if (get(key)==null){
            return false;
        }
        return true;
    }
    public void delete(Key key){
        root = delete(key,root);
    }
    private Node delete(Key key,Node x){
        if (x==null){
            return null;
        }
        if (x.key.equals(key)){
            if (x.right==null){
                return x.left;
            }
            if (x.left==null){
                return x.right;
            }
            Node min = min(x.right);
            min.left = x.left;
            min.right = deleteMin(x.right);
            x = min;
        }else if (x.key.compareTo(key)>0){
            x.left = delete(key,x.left);
        }
        return x;
    }
    public Key min(){
        Node t =  min(root);
        if (t == null){
            return null;
        }
        return t.key;
    }
    private Node min(Node x){
        if (x==null){
            return null;
        }
        if (x.left==null){
            return x;
        }
        return min(x.left);
    }
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if (x==null){
            return null;
        }
        if (x.left==null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        keys(root,list);
        return list;
    }
    private void keys(Node x,List list){
        if (x==null){
            return;
        }
        list.add(x.key);
        keys(x.left,list);
        keys(x.right,list);
    }
    public static void main(String[] args){
        Chapt3STBST2<String,Integer> st = new Chapt3STBST2();
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
        st.delete("s");
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
