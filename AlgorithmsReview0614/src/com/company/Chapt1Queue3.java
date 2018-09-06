package com.company;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mileygao on 7/6/17.
 */
public class Chapt1Queue3<Item extends Comparable<Item>> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public Item dequeue(){
        if (isEmpty()){
            return null;
        }
        Item i = head.item;
        head = head.next;
        if (head==null){
            tail = head;
        }
        N--;
        return i;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void enqueue(Item item){
       if (head ==null){
           head = new Node();
           head.item = item;
           tail = head;
           N++;
           return;
       }
       N++;
       Node oldtail = tail;
       tail = new Node();
       tail.item = item;
       oldtail.next = tail;
    }
    public Iterator<Item> iterator(){
        return new myIterator();
    }
    public class myIterator implements Iterator<Item>{
        Node first = head;
        public boolean hasNext(){
            return first!=null;
        }
        public Item next(){
            Item i = first.item;
            first = first.next;
            return i;
        }
    }
    public int size(){
        return N;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Chapt1Queue3 stack = new Chapt1Queue3();
        while (sc.hasNext()){
            String t = sc.next();
            if (!t.equals("-")){
                stack.enqueue(t);
                System.out.println("ww"+stack.size());
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
