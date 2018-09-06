package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 4/20/17.
 */
public class StackWithNode2<Item> {
    private class Node{
        Node next;
        Item item;

        @Override
        public String toString() {
            return item+"";
        }
    }
    private Node first;
    private int cnt;
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        cnt++;
    }

    public Node pop(){
        Node now = first;
        first = first.next;
        cnt--;
        return now;
    }

    public int size(){
        return cnt;
    }

    public boolean isEmpty(){
        return cnt == 0;
    }

    public static void main(String[] args){
        StackWithNode2 sn = new StackWithNode2();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            if (s.equals("-")){
                System.out.println(sn.pop());
            }else{
                sn.push(s);
            }
            System.out.println("cnt now:"+sn.size()+"--------Is empty?"+sn.isEmpty());
        }
    }
}
