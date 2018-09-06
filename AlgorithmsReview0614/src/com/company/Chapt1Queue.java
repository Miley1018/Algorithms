package com.company;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mileygao on 6/14/17.
 */
public class  Chapt1Queue <Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int N;
    private class Node{
        Node next;
        Item item;
    }
    public void enqueue(Item item){
        if (head==null){
            head = new Node();
            head.item = item;
            tail = head;
            return;
        }
        Node t = new Node();
        t.item = item;
        tail.next = t;
        tail = t;
        N++;

    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<Item>{
        private Node i = head;
        @Override
        public boolean hasNext() {
            return i!=null;
        }

        @Override
        public Item next() {
            if (!hasNext()){
                return null;
            }
            Item now = i.item;
            i = i.next;
            return now;
        }
    }
    public Item dequeue(){
        if (isEmpty()){
            return null;
        }
        Item now = head.item;
        head = head.next;
        if(isEmpty()){
            tail = null;
        }
        N--;
        return now;
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Chapt1Queue stack = new Chapt1Queue();
        while (sc.hasNext()){
            String t = sc.next();
            if (!t.equals("-")){
                stack.enqueue(t);
            }else if(!stack.isEmpty()){
                stack.dequeue();
            }
            Iterator<String> it = stack.iterator();
            while (it.hasNext()){
                System.out.print(it.next()+"  ");
            }
            System.out.println();
        }

    }
}
