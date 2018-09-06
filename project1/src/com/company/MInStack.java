package com.company;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mileygao on 3/16/17.
 */
public class MInStack{
    public static void main(String[] args){     // to be or not to - be - - that - - - is
        Stack<Integer> ss = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int a = Integer.parseInt(sc.next());
            if (a<100){
                ss.push(a);
            } else if(a==123){
                ss.pop();
            }
            else if (!ss.isEmpty()){
                //System.out.println( ss.pop());
                System.out.print(ss.min());
            }
        }

        System.out.println(ss.size()+"left");
    }

    private static class Stack<Item> implements Iterable<Item>{
        private Node first;
        private int N;
        private int[] M = new int[10000];
        private class Node{
            Item item;
            Node next;
        }

        public Item pop(){
            M[N]=100000;
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }

        public void push(Item item){
            if (Integer.parseInt(item+"")<M[N]) {
                M[N+1]=Integer.parseInt(item+"");
            }else if (N==0){
                M[1]=Integer.parseInt(item+"");
            }else{
                M[N+1]=M[N];
            }
            Node oldfirst = first;
            first = new Node();          // why new node?
            first.item = item;
            first.next = oldfirst;     // why not reverse?
            N++;
        }

        public int min(){
            return M[N];
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
