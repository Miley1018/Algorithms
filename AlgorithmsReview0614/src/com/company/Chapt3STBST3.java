package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 7/10/17.
 */
public class Chapt3STBST3<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node{
        Key key;
        Value value;
        int N;
        Node left;
        Node right;
        private Node(Key key, Value value,Node left,Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public boolean contains(Key key){
        return contains(key,root);
    }
    private boolean contains(Key key,Node x){
        if (x == null){
            return false;
        }
        if (key.compareTo(x.key)>0){
            return contains(key,x.right);
        }else if (key.compareTo(x.key)<0){
            return contains(key,x.left);
        }else {
            return true;
        }
    }
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if (x==null){
            return 0;
        }
        return x.N;
    }
    public void put(Key key, Value value){
        if (value==null){
            delete(key);
        }
        root = put(key,value,root);
    }
    private Node put(Key key,Value value,Node x){
        if (x==null){
            x = new Node(key,value,null,null);
            x.N = 1;
            return x;
        }
        if (key.compareTo(x.key)==0){
            x.value = value;
        }else if (key.compareTo(x.key)<0){
            x.left = put(key,value,x.left);
        }else {
            x.right = put(key,value,x.right);
        }
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
    public Value get(Key key){
        Node a = get(key,root);
        if (a==null){
            return null;
        }
        return a.value;
    }
    private Node get(Key key, Node x){
        if (x==null){
            return null;
        }
        if (key.compareTo(x.key)==0){
            return x;
        }else if (key.compareTo(x.key)>0){
            return get(key,x.right);
        }else {
            return get(key,x.left);
        }
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        keys(root,list);
        return list;
    }
    private void keys(Node x,List<Key> list){
        if (x==null){
            return;
        }
        list.add(x.key);
        keys(x.left,list);
        keys(x.right,list);
    }
    public Key min(){
       Node a = min(root);
       if (a==null){
           return null;
       }
       return a.key;
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

    public Key max(){
        Node a = max(root);
        if (a==null){
            return null;
        }
        return a.key;
    }
    private Node max(Node x){
        if (x==null){
            return null;
        }
        if (x.right==null){
            return x;
        }
        return max(x.right);
    }
    public Key floor(Key key){
        Node a = floor(key,root);
        if (a==null){
            return null;
        }
        return a.key;
    }
    private Node floor(Key key,Node x){
        if (x==null){
            return null;
        }
        if (key.compareTo(x.key)==0){
            return x;
        }else if (key.compareTo(x.key)>0){
            if (x.right==null){
                return x;
            }
            Node t = floor(key,x.right);
            return t==null?x:t;
        }else {
            return floor(key,x.left);
        }
    }
    public Key ceiling(Key key){
        Node a = ceiling(key,root);
        if (a==null){
            return null;
        }
        return a.key;
    }
    private Node ceiling(Key key, Node x){
        if (x==null){
            return null;
        }
        if (key.compareTo(x.key)==0){
            return x;
        }else if (key.compareTo(x.key)<0){
            if (x.left==null){
                return x;
            }
            Node t = ceiling(key,x.left);
            return t == null?x:t;
        }else {
            return ceiling(key,x.right);
        }
        //int i = rank(key);
        //return select(i);
    }
    public int rank(Key key){
       return rank(key,root);
    }
    private int rank(Key key,Node x){
        if (x==null){
            return 1;
        }
        if (key.compareTo(x.key)==0){
            return size(x.left)+1;
        }else if (key.compareTo(x.key)<0){
            if (x.left==null){
                return 1;
            }
            return rank(key,x.left);
        }else {
            return size(x.left)+1+rank(key,x.right);
        }
    }
    public Key select(int k){
        Node a = select(k-1,root);
        if (a==null){
            return null;
        }
        return a.key;
    }
    private Node select(int k,Node x){
        if (x == null){
            return null;
        }
        if (size(x.left)==k){
            return x;
        }else if (size(x.left)<k){
            return select(k-size(x.left)-1,x.right);
        }else {
            return select(k,x.left);
        }
    }
    public void delete(Key key){
        root = delete(key,root);
    }
    private Node delete(Key key,Node x){
        if (x==null){
            return null;
        }
        if (key.equals(x.key)){
             if (x.right==null){
                 return x.left;
             }else {
                 Node min = min(x.right);
                 min.left = x.left;
                 min.right = deleteMin(x.right);
                 min.N = size(min.left)+size(min.right)+1;
                 return min;
             }
        }else if (key.compareTo(x.key)>0){
            return delete(key,x.right);
        }else {
            return delete(key,x.left);
        }
    }
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if (x == null){
            return null;
        }
        if(x.left == null){
            return x.right;
        }else{
            x.left =  deleteMin(x.left);
            x.N = size(x.left)+size(x.right)+1;
            return x;
        }
    }
    public void deleteMax(){
        root = deleteMax(root);
    }
    private Node deleteMax(Node x){
        if (x==null){
            return null;
        }
        if (x.right == null){
            return x.left;
        }else {
            x.right = deleteMax(x.right);
            x.N = size(x.left)+size(x.right)+1;
            return x;
        }
    }
    public int size(Key key1, Key key2){
        int i = rank(key1);
        int j = rank(key2);
        return j-i;
    }
    public List<Key> keys(Key key1,Key key2){
        List<Key> list = new ArrayList<Key>();
        int i = rank(key1);
        int j = rank(key2);
        for (int k = i;k<=j;k++){
            if (select(k)==null){
                continue;
            }
            list.add(select(k));
        }
        return list;
    }
    public static void main(String[] args){
        Chapt3STBST3<String,Integer> st = new Chapt3STBST3<>();
        /*
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        while (!key.equals("-")){
            if (st.contains(key)) {
                st.put(key, st.get(key)+1);
            }else{
                st.put(key, 1);
            }
            key = sc.next();
        }*/
        String [] data = {"b","d","e","s"};
        for(String s:data){
            st.put(s,1);
        }
        System.out.println(st.rank("b"));
        System.out.println(st.ceiling("a"));
        System.out.println(st.keys());
        System.out.println(st.keys("b","t"));
        st.delete("a");
        System.out.println(st.keys());
        System.out.println(st.keys("a","d"));
        st.deleteMax();
        System.out.println(st.keys());
        st.deleteMin();
        System.out.println(st.keys());
        int max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }

        System.out.println(max);
    }

}