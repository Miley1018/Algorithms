package com.company;

import java.util.Iterator;

public class Chapt1Bag<Item> implements Iterable<Item> {
    private int N;
    private Node head;
    private class Node{
        Item item;
        Node next;
    }
    public void add(Item item){
        Node oldfirst = head;
        head = new Node();
        head.item = item;
        head.next = oldfirst;
        N++;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public int size(){
        return N;
    }
    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<Item>{
        private Node first = head;
        @Override
        public boolean hasNext() {
            return first!=null;
        }

        @Override
        public Item next() {
            Item now = first.item;
            first = first.next;
            return now;
        }
    }
    public static void main(String[] args) {
	// write your code here
        Chapt1Bag bag = new Chapt1Bag();
        bag.add("a");
        bag.add("b");
        Iterator it = bag.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
