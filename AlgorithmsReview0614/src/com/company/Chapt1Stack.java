package com.company;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mileygao on 6/14/17.
 */
public class Chapt1Stack<Item extends Comparable> implements Iterable<Item>  {
    private Node head;
    private int N;
    private Item Min;
    private class Node{
        Item item;
        Node next;
        Item min;
    }
    public void push(Item item){
        N++;
        Node oldfirst = head;
        head = new Node();
        head.item = item;
        head.next = oldfirst;
        if (Min==null){
            Min = item;
        }else {
            Min = Min.compareTo(item) > 0 ? item : Min;
        }
        head.min = Min;
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
    public Item pop(){
        if (isEmpty()){
            return null;
        }
        N--;
        Item now = head.item;
        head = head.next;
        Min = head.min;
        return now;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public int size(){
        return N;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Chapt1Stack stack = new Chapt1Stack();
        int[] aa = {3,2,4,1,-1};
        int i = 0;
        while (i<aa.length){
            stack.push(aa[i++]);
        }
        System.out.println(stack.Min);
        stack.pop();
        System.out.println(stack.Min);

    }
}
