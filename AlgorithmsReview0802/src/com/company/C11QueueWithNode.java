package com.company;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mileygao on 8/2/17.
 */
public class C11QueueWithNode <Item> implements Iterable<Item>{
    private Node head;
    private Node tail;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public void enqueue(Item item){
        N++;
        if (tail==null){
            tail = new Node();
            tail.item = item;
            head = tail;
            return;
        }
        Node oldtail = tail;
        tail = new Node();
        tail.item = item;
        oldtail.next = tail;
    }
    public Item dequeue(){
        if (head==null){
            return null;
        }
        N--;
        Node x = head;
        head = head.next;
        if (head==null){
            tail = head;
        }
        return x.item;
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public Iterator<Item> iterator(){
        return new myiter();
    }
    private class myiter implements Iterator<Item>{
        private Node x = head;
        public boolean hasNext(){
            return x!=null;
        }
        public Item next(){
            Node i = x;
            x = x.next;
            return i.item;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        C11QueueWithNode stack = new C11QueueWithNode();
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
