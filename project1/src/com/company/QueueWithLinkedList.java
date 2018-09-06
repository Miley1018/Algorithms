package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 3/16/17.
 */
public class QueueWithLinkedList {
    public static void main(String[] args){
        Queue<String> ss = new Queue<String>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.next();
            if (!a.equals("-")){
                ss.enqueue(a);
            }else if (!ss.isEmpty()){
                System.out.println( ss.dequeue());
            }
        }

        System.out.println(ss.size()+"left");
    }

    private static class Queue<Item>{
        private class Node{
            Node next;
            Item item;
        }
        private Node first;
        private Node last;
        private int N;

        public boolean isEmpty(){
            return first == null;
        }

        public int size(){
            return N;
        }

        public void enqueue(Item item){
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()){
                first = last;
            }else{
                oldLast.next = last;
            }
            N++;
        }

        public Item dequeue(){
            Item item = first.item;
            first = first.next;
            if (isEmpty()){
                last = null;
            }
            N--;
            return item;
        }
    }
}

