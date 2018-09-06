package com.company;

public class STWithNonSequentialNode2<Key,Value> {

    private Node first;
    int N;
    private class Node{
        private Key key;
        private Value value;
        private Node next;
        private Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public void put(Key key, Value value){
        for (Node x = first; x!=null; x = x.next){
            if (x.key.equals(key)){
                x.value = value;
                return;
            }
        }
        first = new Node(key,value,first);
        N++;
    }
    public void delete(Key key){
        Node before=null;
        for (Node x = first; x!=null; x = x.next){
            if (x.key.equals(key)){
                if (before == null){
                    first = first.next;
                }else {
                    before.next = x.next;
                }
                N--;
                return;
            }
            before = x;
        }
    }
    public int size(){
        return N;
    }
    public Value get(Key key){
        for (Node x = first; x!=null; x=x.next){
            if (x.key.equals(key)){
                return x.value;
            }
        }
        return null;
    }
    public boolean contains(Key key){
        for (Node x = first; x!=null; x=x.next){
            if (x.key.equals(key)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        String[] a = {"c","a","v","b","c","b","b","b"};
        STWithNonSequentialNode2<String,Integer> st = new STWithNonSequentialNode2();
        for (String s: a){
            if (st.contains(s)){
                st.put(s,st.get(s)+1);              // why  int enoungh?
            }else {
                st.put(s,1);
            }
        }
        st.delete("a");
        System.out.println(st.get("a"));
        String max = "";
        st.put(max,0);
        for (String s: a){
            if (st.get(s)>st.get(max)){
                //(int)st.get(max) = (int)st.get(s);          //   can't?
                st.put(max,st.get(s));                // why  not int?
            }
        }
        System.out.println(st.get(max)+"size:"+st.size());
    }
}
