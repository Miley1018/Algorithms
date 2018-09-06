package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mileygao on 6/8/17.
 */
public class ThreeST<Value> {
    private Node root;
    private class Node{
        Value value;
        char c;
        Node left, mid, right;
    }
    public void put(String key, Value value){
        root = put(key,value,0,root);
    }
    private Node put(String key, Value value, int d, Node root){
        char c = key.charAt(d);
        if (root==null){
            root = new Node();
            root.c = c;
        }
        if (c<root.c){
            root.left = put(key,value,d,root.left);
        }else if (c>root.c){
            root.right = put(key,value,d,root.right);
        }else if (d<key.length()-1){
            root.mid = put(key,value,d+1,root.mid);
        }else {
            root.value = value;
        }
        return root;
    }
    public Value get(String s){
        if(s==null||s.length()==0){
            return null;
        }
        Node t = get(s,root,0);
        if (t == null){
            return null;
        }
        return t.value;
    }
    private Node get(String s, Node root,int d){
        if (root == null){
            return null;
        }
        char c = s.charAt(d);
        if (c>root.c){
            return get(s,root.right,d);
        }else if (c<root.c){
            return get(s,root.left,d);
        }else if (d<s.length()-1){
            return get(s,root.mid,d+1);
        }else{
            return root;
        }
    }
    public Iterable<String> keys(){
        return keysWithPrefix("");
    }
    public Iterable<String > keysWithPrefix(String pre){
        List<String> list = new ArrayList<>();
        if(pre.length()==0){
          keyswith(pre,root,root,list);
        }else {
            Node t = get(pre, root, 0);
            keyswith(pre, t, t, list);
        }
        return list;
    }
    private void keyswith(String pre, Node root, Node t, List<String> list){
        if (root == null){
            return;
        }
        if (root.value!=null){
            list.add(pre+root.c);
        }
        if (pre.length()==0){
            keyswith(pre+root.c,root.mid,root,list);
            keyswith(pre,root.left,root,list);
            keyswith(pre,root.right,root,list);
            return;
        }
        if(root == t){
            keyswith(pre,root.mid,t,list);
        }else {
            keyswith(pre+root.c,root.mid,t,list);
            keyswith(pre,root.left,t,list);
            keyswith(pre,root.right,t,list);
        }
    }
    public String longPrefixOf(String s){
        int length = search(s,0,0,root);
        return s.substring(0,length+1);
    }
    private int search(String s, int length, int d,Node root){
        if (root == null){
            return length;
        }
        if (root.value!=null){
            length = d;
        }
        if (d == s.length()-1){
            return length;
        }
        char c = s.charAt(d);
        if (c<root.c){
           return search(s,length,d,root.left);
        }else if (c>root.c){
            return search(s,length,d,root.right);
        }else {
            return search(s,length,d+1,root.mid);
        }
    }
    public List<String> keysMatch(String pat){
        List<String> list = new ArrayList<>();
        collectMatch(pat,0,root,list,"");
        return list;
    }
    public void collectMatch(String pat, int d,Node root, List<String> list,String pre){
        if (root == null){
            return;
        }
        char c = pat.charAt(d);
        if (c == '.'){
            collectMatch(pat,d,root.right,list,pre);
            if (d<pat.length()-1){
                collectMatch(pat,d+1,root.mid,list,pre+root.c);
            }else if(root.value!=null){
                list.add(pre+root.c);
            }
            //collectMatch(pat,d+1,root.mid,list,pre+root.c);
            collectMatch(pat,d,root.left,list,pre);
            return;
        }
        if (c > root.c){
            collectMatch(pat,d,root.right,list,pre);
        }else if (c<root.c){
            collectMatch(pat,d,root.left,list,pre);
        }else if (d<pat.length()-1){
            collectMatch(pat,d+1,root.mid,list,pre+root.c);
        }else if(root.value!=null){
            list.add(pre+root.c);
        }
    }
    public static void main(String[] args) {
        String[] s = {"she","ab","ae"};
        ThreeST<Integer> t = new ThreeST<>();
        for (int i = 0; i < s.length; i++) {
            t.put(s[i], i);
        }
        System.out.println(t.get("ae"));
        System.out.println(t.keys());
        System.out.println("longis:"+t.longPrefixOf("abde"));
        System.out.println("pat:"+t.keysMatch("a."));
    }
}
