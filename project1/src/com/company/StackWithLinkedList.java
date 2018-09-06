package com.company;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mileygao on 3/16/17.
 */
public class StackWithLinkedList{
    public static void main(String[] args){     // to be or not to - be - - that - - - is
        Stack<String> ss = new Stack<String>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.next();
            if (!a.equals("-")){
                ss.push(a);
            }else if (!ss.isEmpty()){
                System.out.println( ss.pop());
            }
            for (String i: ss){
                System.out.println("--------"+i);       // what???
            }
        }

        System.out.println(ss.size()+"left");
    }

    private static class Stack<Item> implements Iterable<Item>{
        private Node first;
        private int N;
        private class Node{
            Item item;
            Node next;
        }

        public Item pop(){
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }

        public void push(Item item){
            Node oldfirst = first;
            first = new Node();          // why new node?
            first.item = item;
            first.next = oldfirst;     // why not reverse?
            N++;
        }

        public boolean isEmpty(){
            return first == null;
        }

        public int size(){
            return N;
        }

        public Item peek(){
            return first.item;
        }

        @Override
        public Iterator<Item> iterator() {     // how to use iterator? just foreach?
            return new ListIterator();
        }

        private class ListIterator implements Iterator<Item>{
            private Node now = first;
            @Override
            public void remove() {

            }

            @Override
            public boolean hasNext() {
                return now!=null;
            }

            @Override
            public Item next() {
                Item item = now.item;
                now = now.next;                      // why next?
                return item;
            }
        }

    }


}
