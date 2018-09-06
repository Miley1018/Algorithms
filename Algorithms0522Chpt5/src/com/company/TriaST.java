package com.company;

import java.util.*;

/**
 * Created by mileygao on 6/7/17.
 */
public class TriaST<Value> {
    private static int R = 256;
    private Node root;
    public static class Node{
        Object value;
        Node[] next = new Node[R];
    }
    public Value get(String key){
        Node x =  get(key,0,root);
        if (x==null)
        {
            return null;
        }
        return (Value)x.value;
    }
    public Node get(String key, int d, Node x){
        if (x==null){
            return null;
        }
        if (d==key.length()){
            return x;
        }
        Node t =  x.next[key.charAt(d)];
        return get(key,d+1,t);
    }
    public void put(String s,Value value){
        root = put(root,s,value,0);
    }
    public Node put(Node x,String s, Value value, int d){
        if (x==null){
            x = new Node();
        }
        if (d == s.length()){
            x.value = value;
            return x;
        }
        x.next[s.charAt(d)] =   put(x.next[s.charAt(d)],s,value,d+1);
        return x;
    }
    public Iterable<String> keys(){
        return keysWithPrefix("");
    }
    public Iterable<String> keysWithPrefix(String pre){
        List<String> list = new ArrayList<>();
        colect(pre,get(pre,0,root),list);
        return list;
    }
    public void colect(String pre,Node x,List<String> list){
        if (x==null){
            return;
        }
        if (x.value!=null){
            list.add(pre);
        }
        for (char c = 0; c<R; c++){
           colect(pre+c, x.next[c],list);
        }

    }
    public List<String> keysmatch(String pat){
        List<String> list = new ArrayList<>();
        collect(root,pat,list,"");
        return list;
    }
    public void collect(Node x, String pat,List<String > list, String pre){
        if (x == null){
            return;
        }
        int d = pre.length();
        if (d == pat.length()&&x.value!=null){
            list.add(pre);
        }
        if (d == pat.length()){
            return;
        }
        char c = pat.charAt(d);
        for (char i = 0; i<R;i++) {
            if (c == '.' || c ==i){
                collect(x.next[i],pat,list,pre+i);
            }
        }

    }
    public String longestPrefixOf(String s){
        int length = search(s,0,root,0);
        return s.substring(0,length);
    }
    public int search(String s, int d, Node root, int length){
        if (root == null){
            return length;
        }
        if (root.value!=null){
            length = d;
        }
        if (d==s.length()){
            return length;
        }
        char c = s.charAt(d);
        return search(s,d+1,root.next[c],length);
    }
    public void delete(String key){
        root = delete(key,root,0);
    }
    public Node delete(String key, Node root, int d){
        if (root == null){
            return null;
        }
        if (d == key.length()){
           root.value = null;
        }else{
            char c = key.charAt(d);
            root.next[c] = delete(key,root.next[c],d+1);
        }
        if (root.value!=null){
            return root;
        }
        for (char c = 0; c<R; c++){
            if (root.next[c]!=null){
                return root;
            }
        }
        return null;
    }
   public static void main(String[] args){
       String[] s = {"abd", "dbds", "abdfjs", "abdes", "da", "cb","asd", "ca"};
       TriaST<Integer> t = new TriaST();
       for (int i = 0; i < s.length;i++){
           t.put(s[i],i);
       }
       System.out.println(t.get(""));
       System.out.println(t.keys());
       System.out.println(t.keysmatch("a.."));
       System.out.println(t.longestPrefixOf("abd"));
   }
}
