package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt1Stack2<Item extends Comparable<Item>> implements Iterable<Item> {
    private int N;
    private Node head;
    private Item min;
    private List<Item> mins;
    private class Node{
        Item item;
        Node next;
        private Node(Item item, Node next){
            this.item = item;
            this.next = next;
        }
    }
    public Chapt1Stack2(){
        mins =new ArrayList<Item>();
    }
    public Iterator<Item> iterator(){
        return new myIterator();
    }
    public class myIterator implements Iterator<Item>{
        private Node i = head;
        public boolean hasNext(){
            return i!=null;
        }
        public Item next(){
            if (hasNext()){
                Item item = i.item;
                i = i.next;
                return item;
            }
            return null;
        }
    }
    public void push(Item item){
        if (min==null){
            min = item;
        }else {
            min = min.compareTo(item) < 0 ? min : item;
        }
        mins.add(min);
        N++;
        if (head==null){
            head = new Node(item,null);
            return;
        }
        Node oldhead = head;
        head = new Node(item,oldhead);
    }
    public Item pop(){
        if (isEmpty()){
            return null;
        }
        Item item = head.item;
        head = head.next;
        N--;
        return item;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public int size(){
        return N;
    }
    public Item min(){
        if (isEmpty()){
            return null;
        }
        return mins.get(N-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Chapt1Stack2 stack = new Chapt1Stack2();
        int[] aa = {3,2,4,1,-1};
        int i = 0;
        while (i<aa.length){
            stack.push(aa[i++]);
        }
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());

    }
}
