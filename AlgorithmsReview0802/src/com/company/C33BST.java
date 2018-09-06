package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 8/8/17.
 */
public class C33BST<Key extends Comparable<Key>, Value> {//-------wrong partly
    private Node root;
    private class Node{
        Key key;
        Value value;
        Node left;
        Node right;
        int N;
        private Node(Key key, Value value,Node left, Node right,int N){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.N =N;
        }
    }
    public void put(Key key, Value value){
        root = put(key,value,root);
    }
    private Node put(Key key, Value value ,Node x){
        if (x==null){
            return new Node(key,value,null,null,1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            x.right = put(key,value,x.right);
        }else if (cmp<0){
            x.left = put(key,value,x.left);
        }else {
            System.out.println("value:"+value);
            x.value = value;
        }
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
    public Value get(Key key){
        Node t = get(key,root);
        if (t==null){
            return null;
        }
        return t.value;
    }
    private Node get(Key key, Node x){
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp==0){
            return x;
        }else if (cmp>0){
            return get(key,x.right);
        }else {
            return get(key,x.left);
        }
    }
    public void delete(Key key){
        root = delete(key,root);
    }
    private Node delete(Key key, Node x){
        if (x==null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            x.right = delete(key,x.right);
        }else if (cmp<0){
            x.left = delete(key,x.left);
        }else {
            if (x.right==null){
                return x.left;
            }
            if (x.left==null){
                return x.right;
            }
            Node l = x.left;
            Node t = min(x.right);
            t.left = l;
            t.right = deleteMin(x.right);
            x= t;
        }
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
    public Key min(){
        Node t = min(root);
        if (t==null){
            return null;
        }
        return t.key;
    }
    private Node min(Node x){
        if (x==null){
            return null;
        }
        while (x.left!=null){
            x = x.left;
        }
        return x;
    }
    public Key max(){
        Node t = max(root);
        if (t==null){
            return null;
        }
        return t.key;
    }
    private Node max(Node x){
        if (x==null){
            return null;
        }
        while (x.right!=null){
            x = x.right;
        }
        return x;
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
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
    public void deleteMax(){
        root = deleteMax(root);
    }
    private Node deleteMax(Node x){
        if (x==null){
            return null;
        }
        if (x.right==null){
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
    public List<Key> keys(){
        return keys(min(),max());
    }
    public List<Key> keys(Key lo, Key hi){
        List<Key > list = new ArrayList<Key>();
        keys(lo,hi,root,list);
        return list;
    }
    private void keys(Key lo, Key hi, Node x,List list){
        if (x==null){
            return;
        }
        int cmp1= x.key.compareTo(lo);
        int cmp2 =x.key.compareTo(hi);
        if (cmp1<0||cmp2>0){
            return;
        }
        list.add(x.key);
        keys(lo,hi,x.left,list);
        keys(lo,hi,x.right,list);
    }
    public int rank(Key key){
        return rank(key,root);
    }
    private int rank(Key key,Node x){
        if (x==null){
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp==0){
            return size(x.left);
        }else if (cmp>0){
            return size(x.left)+1+rank(key,x.right);
        }else {
            return rank(key,x.left);
        }
    }
    public Key floor(Key key){
        Node t = floor(key,root);
        return t==null?null:t.key;
    }
    private Node floor(Key key, Node x){
        if (x==null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp==0){
            return x;
        }else if (cmp>0){
          Node t = floor(key,x.right);
          if (t==null){
              return x;
          }
          return t;
        }else {
            return floor(key,x.left);
        }
    }
    public Key ceiling(Key key){
        Node t = ceiling(key,root);
        return t==null?null:t.key;
    }
    private Node ceiling(Key key,Node x){
        if (x==null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp==0){
            return x;
        }else if (cmp>0){
           return ceiling(key,x.right);
        }else {
           Node t = ceiling(key,x.left);
           if (t==null){
               return x;
           }
           return t;
        }
    }
    public Key select(int k){
        Node t = select(k,root);
        return t==null?null:t.key;
    }
    private Node select(int k, Node x){
        if (x==null){
            return null;
        }
        if (size(x.left)==k-1){
            return x;
        }else if (size(x.left)>k-1){
            return select(k,x.left);
        }else {
            return select(k-size(x.left)-1,x.right);
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
    public int size(Key lo, Key hi){
        int i = rank(lo);

        int j = rank(hi);
        System.out.println(" boolean:"+hi.equals(select(j)));
        if (hi.equals(select(j))){

            return j-i+1;
        }else {
            return j-i;
        }
    }
    public boolean contains(Key key){
       Node t = contains(key,root);
       if (t==null){
           return false;
       }
       return true;
    }
    private Node contains(Key key, Node x){
        if (x==null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp==0){
            return x;
        }else if (cmp>0){
            return contains(key,x.right);
        }else {
            return contains(key,x.left);
        }
    }
    public static void main(String[] args){
        C33BST<String,Integer> st = new C33BST<>();
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        while (!key.equals("-")){
            if (st.contains(key)) {
                System.out.println("get:"+st.get(key)+1);
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
        System.out.println("min:"+st.min());
        System.out.println("max:"+st.max());
        System.out.println(st.rank("c"));
        System.out.println(st.ceiling("c"));
        System.out.println(st.floor("a"));
        System.out.println(st.floor("f"));
        System.out.println(st.select(2));
        System.out.println(st.keys("a","f"));
        st.deleteMin();
        System.out.println(st.keys());
        System.out.println(st.size());
        st.deleteMax();
        System.out.println(st.keys());
        System.out.println(st.size());
        max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }
        System.out.println(max);
    }
}
