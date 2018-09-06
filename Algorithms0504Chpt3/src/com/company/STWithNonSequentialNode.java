package com.company;

public class STWithNonSequentialNode<Key,Value> {
    private Node first;
    private class Node{
        private Key key;
        private Value val;
        Node next;
        public Node(Key key,Value val,Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public void put(Key key, Value val){
        for (Node x = first; x!=null; x=x.next){
            if (x.key.equals(key)){
                x.val = val;
                return;
            }
        }
        first = new Node(key,val,first);
    }
    public Value get(Key key){
        for (Node x = first; x!=null;x = x.next){
            if (x.key.equals(key)){
                return x.val;
            }
        }
        return null;
    }
    public boolean contains(Key key){
        for (Node x = first; x!=null;x = x.next){
            if (x.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // write your code here
        String[] s = {"c","a","v","b","c","b","b","b"};
        STWithNonSequentialNode st1 = new STWithNonSequentialNode();
        for (String i: s){
            if (st1.contains(i)){
                st1.put(i,(int)st1.get(i)+1);
            }else{
                st1.put(i,1);
            }
        }
        String max = "";
        st1.put(max,0);
        for (String i:s) {
            if ((int)st1.get(i)>(int)st1.get(max)){
                st1.put(max,st1.get(i));
            }
        }
        System.out.println(st1.get(max));
    }
}
