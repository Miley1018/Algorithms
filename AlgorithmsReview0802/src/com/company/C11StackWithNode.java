package com.company;

import java.util.Iterator;

/**
 * Created by mileygao on 8/2/17.
 */
public class C11StackWithNode<Item extends Comparable<Item>> implements Iterable<Item>{
    private Node first;
    private int N;
    private Item Min;
    private class Node{
        Node next;
        Item item;
        Item min;
    }
    public void push(Item item){
        N++;
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if (Min==null){
            Min = item;
            first.min=item;
        }else {
            Min = Min.compareTo(item)<0?Min:item;
            first.min = Min;
        }
        first.next = oldfirst;
    }
    public void pop(){
        if (first == null){
            return;
        }
        Node a = first;
        first = first.next;
        Min = first==null?null:first.min;
        N--;
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public Iterator<Item> iterator(){
        return new  myiter();
    }
    public class myiter implements Iterator{
        Node head = first;
        @Override
        public boolean hasNext() {
            return head!=null;
        }

        @Override
        public Item next() {
            Node i = head;
            head= head.next;
            return i.item;
        }
    }
    public Item getMin(){
        return Min;
    }
    public static void main(String[] args){
        C11StackWithNode<String> s = new C11StackWithNode<>();
        s.push("d");
        s.push("b");
        System.out.println(s.getMin());
        s.push("c");
        s.push("a");
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        System.out.println(s.size()+" "+s.isEmpty());
        for (String i : s){
            System.out.println(i);
        }
    }
}
