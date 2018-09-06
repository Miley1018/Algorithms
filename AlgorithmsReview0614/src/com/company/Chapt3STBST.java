package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 6/21/17.
 */
public class Chapt3STBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node{
        Key key;
        Value value;
        Node left;
        Node right;
        int N;
        private Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }
    public int size(){
        return size(root);
    }
    public int size(Node root){
        if (root == null){
            return 0;
        }
        return root.N;
    }
    public boolean contains(Key key){
        return get(key)!=null;
    }
    public void put(Key key,Value value){
        root = put(key,value,root);
    }
    public Node put(Key key,Value value, Node root){
        if (root==null){
            root = new Node(key,value);
            root.N = 1;
            return root;
        }
        if(root.key.compareTo(key)>0){
            root.left = put(key,value,root.left);
        }else if (root.key.compareTo(key)<0){
            root.right = put(key,value,root.right);
        }else {
            root.value = value;
        }
        root.N = size(root.left)+size(root.right)+1;
        return root;
    }
    public Value get(Key key){
        if ( get(key,root) == null){
            return null;
        }
        return  get(key,root).value;
    }
    public Node get(Key key, Node root){
        if (root == null){
            return null;
        }
        if (root.key.compareTo(key)>0){
            return get(key,root.left);
        }else if (root.key.compareTo(key)<0){
            return get(key,root.right);
        }else {
            return root;
        }
    }
    public List<Key> keys(){
        List<Key> list = new ArrayList<Key>();
        keys(root,list);
        return list;
    }
    private void keys(Node root,List<Key> list){
        if (root == null){
            return;
        }
        list.add(root.key);
        keys(root.left,list);
        keys(root.right,list);
    }
    public List<Key> keys(Key lo, Key hi){
        List<Key> list = new ArrayList<Key>();
        keys(lo,hi,root,list);
        return list;
    }
    private void keys(Key lo, Key hi, Node root,List<Key> list){
        if (root == null){
            return;
        }
        int cmplo = lo.compareTo(root.key);
        int cmphi = hi.compareTo(root.key);
        if (cmplo<0){
            keys(lo,hi,root.left,list);
        }
        if(cmplo<=0&&cmphi>=0){
            list.add(root.key);
        }
        if(cmphi>0){
            keys(lo,hi,root.right,list);
        }
    }
    public Key max(){//---------------------------------------
        Node x = max(root);
        if (x == null){
            return null;
        }
        return x.key;
    }
    public Node max(Node root){
        if (root == null){
            return null;
        }
        Node max = root;
        max(root.right);
        return max;
    }
    public Key min(){//-------------------------------------------
        Node k = min(root);
        if (k == null){
            return null;
        }
        return k.key;
    }
    private Node min(Node root){
        if (root==null){
            return null;
        }
        Node min = root;
        min(root.left);
        return min;
    }
    public void deleteMin(){
        root= deleteMin(root);
    }
    private Node deleteMin(Node root){
        if (root==null){
            return null;
        }
        if (root.left==null){
            return root.right;
        }
        root.left =  deleteMin(root.left);
        root.N = size(root.left)+size(root.right)+1;
        return root;
    }
    public void delete(Key key){
        root =  delete(key,root);
    }
    private Node delete(Key key, Node root){
        if (root == null){
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp<0){
            root.left =  delete(key,root.left);
        }else if (cmp>0){
            root.right =  delete(key,root.right);
        }else {
            if (root.left==null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            Node x = root;
            root = min(x.right);
            root.left = x.left;
            root.right = deleteMin(x.right);
        }
        root.N = size(root.left)+ size(root.right)+1;
        return root;
    }

    public Key floor(Key key){
        Node floor = floor(key,root);
        if (floor==null){
            return null;
        }
        return floor.key;
    }
    private Node floor(Key key, Node root){
        if (root == null){
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp>0){
            Node floor = floor(key,root.right);
            return floor==null?root:floor;
        }else if(cmp<0){
            return floor(key,root.left);
        }else {
            return root;
        }
    }
    public Key select(int k){
        Node now = select(k,root);
        if (now==null){
            return null;
        }
        return now.key;
    }
    private Node select(int k, Node root){
        if (root == null){
            return null;
        }
        if (size(root.left)== k){
            return root;
        }else if (size(root.left)<k){
            return select(k-size(root.left)-1,root.right);
        }else {
            return select(k,root.left);
        }
    }
    public int rank(Key key){
        return rank(key,root);
    }
    private int rank(Key key,Node root){
        if (root==  null){
            return 0;
        }
        int cmp = key.compareTo(root.key);
        if (cmp>0){
            return size(root.left)+1+rank(key,root.right);
        }else if(cmp<0){
            return rank(key,root.left);
        }else {
            return size(root.left);
        }
    }
    public static void main(String[] args){
        Chapt3STBST<String,Integer> st = new Chapt3STBST();
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
        System.out.println(st.select(2));
        int max = 0;
        for (String s:st.keys()){
            max = Math.max(max,st.get(s));
        }

        System.out.println(max);
    }
}
