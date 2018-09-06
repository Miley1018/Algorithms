package com.company;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt1Queue2 <Key> implements Iterable<Key>{
    private int N;
    private Node head;
    private Node tail;
    private class Node{
        Key key;
        Node next;
        private Node(Key key, Node next){
            this.key= key;
            this.next = next;
        }
    }
    public void enqueue(Key key){
        if (head == null){
            head = new Node(key,null);
            tail = head;
            return;
        }
        Node oldTail = tail;
        tail = new Node(key,null);
        oldTail.next = tail;
        N++;
    }
    public Key dequeue(){
        if (size()==0){return null;}
        Key key = head.key;
        head = head.next;
        if (head==null){
            tail = head;
        }
        N--;
        return key;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    @Override
    public Iterator<Key> iterator() {
        return new myIterator();
    }
    private class myIterator implements Iterator<Key>{
        private Node i = head;
        @Override
        public boolean hasNext() {
            return i!=null;
        }

        @Override
        public Key next() {
            if (!hasNext()){
                return null;
            }
            Key key = i.key;
            i = i.next;
            return key;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Chapt1Queue2 stack = new Chapt1Queue2();
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
