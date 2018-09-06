package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 5/9/17.
 */
public class BST <Key extends Comparable, Value>{
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private int N;
        private Node(Key key, Value value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
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
    public void put(Key key, Value value){
        root = put(root, key, value);         //------------------
    }
    public Node put(Node root, Key key, Value value){
        if (root == null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(root.key);
        if (cmp == 0){
            root.value = value;
        }else if(cmp>0){
            root.right = put(root.right,key,value);
        }else {
            root.left = put(root.left,key,value);
        }
        root.N = size(root.left)+size(root.right)+1;
        return root;
    }
    public Value get(Key key){
        return get(root, key);
    }
    public Value get(Node root, Key key){
        if (root == null){
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp>0){
            return get(root.right,key);
        }else if (cmp<0){
            return get(root.left,key);
        }else {
            return root.value;
        }
    }
    public Key max(){
        if (root == null){ //------------------ //------------------no use?
            return null;
        }
        return max(root).key;
    }
    public Node max(Node root){
        if (root.right == null){
            return root;
        }else{
            return max(root.right);
        }
    }
    public Key min(){
        if (root == null){ //------------------ //------------------no use?
            return null;
        }
        return min(root).key;
    }
    public Node min(Node root){
        if (root.left==null){
            return root;
        }else{
            return min(root.left);
        }
    }
    public Key floor(Key key){
        return floor(root, key);
    }
    public Key floor(Node root, Key key){
        if (root==null){
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp == 0){
            return key;
        }else if (cmp>0){
            Key rightFloor = floor(root.right,key);
            if (rightFloor == null){
                return root.key;
            }
            return rightFloor;
        }
        return floor(root.left,key);
    }
    public boolean contains(Key key){
        return contains(root, key);
    }
    public boolean contains(Node root, Key key){
        if (root == null){
            return false;
        }
        int cmp = key.compareTo(root.key);
        if (cmp==0){
            return true;
        }else if (cmp>0){
            return contains(root.right,key);
        }
        return contains(root.left,key);
    }
    public Key select(int k){
        return select(root,k);
    }
    public Key select(Node root, int k){
        if (root == null){
            return null;
        }
        if (size(root.left)== k){
            return root.key;
        }else if (size(root.left) > k){
            return select(root.left,k);
        }
        return select(root.right,k-size(root.left)-1);
    }
    public int rank(Key key){
        return rank(root,key);
    }
    public int rank(Node root, Key key){
        if (root == null){
            return 0;
        }
        int cmp = key.compareTo(root.key);
        if (cmp==0){
            return size(root.left);
        }else if (cmp>0){
            int right = rank(root.right,key);
            return right+size(root.left)+1;
        }else{
            return rank(root.left,key);
        }
    }
    public void deleteMin(){
        root = deleteMin(root);                //----------why root?
    }
    public Node deleteMin(Node root){
        if (root == null){               //--------------------??no use?
            return null;
        }
        if (root.left!=null){
            root.left = deleteMin(root.left);
            root.N = size(root.left)+size(root.right)+1;
        }else{
            root.N = size(root.left)+size(root.right)+1;   //.........
            return root.right;
        }
        return root;
    }
    public void delete(Key key){
        root = delete(root,key);
    }
    public Node delete(Node root, Key key){
        if (root == null){
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0){
            root.left = delete(root.left,key);
        }else if (cmp>0){
            root.right = delete(root.right,key);
        }else{
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            Node t = root;
            root = min(t.right);
            root.right=deleteMin(t.right);
            root.left = t.left;
        }
        root.N = size(root.left)+size(root.right)+1;
        return root;
    }
    public List<Key> keys(){
        return keys(min(),max());
    }
    public List<Key> keys(Key lo, Key hi){
        List<Key> list = new ArrayList<Key>();
        keys(root,list,lo,hi);
        return list;
    }
    public void keys(Node root, List<Key> list, Key lo, Key hi){
        if (root == null){
            return;
        }
        //int cmpLo = lo.compareTo(root.key);
        //int cmphi = hi.compareTo(root.key);
        //if ()
    }
    public static void main(String[] args){
        String[] s = {"c","a","v","b","c","b","b","b"};
        BST<String,Integer> st = new BST();
        for (String s1: s) {
            if (st.contains(s1)) {
                st.put(s1,st.get(s1)+1);
            }else{
                st.put(s1,1);
            }
        }

        String max = "min";
        st.put(max,0);
        for (String s1: s){
            if (st.get(s1)>(st.get(max))){
                st.put(max,st.get(s1));
            }
        }
        System.out.println("max:"+st.get(max));
        st.deleteMin();
        st.delete("b");
        //st.delete("a");
        System.out.println("select 0"+st.select(0)+"rank:"+st.rank("w"));
        System.out.println("size:"+st.size()+"min:"+st.min()+"max:"+st.max()+st.floor("e"));
    }
}
