package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 4/20/17.
 */
public class QueueWithNode2<Item> {
    private class Node{
        Node next;
        Item item;
    }
    private Node first;
    private Node last;
    private int cnt;

    public void push(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
        } else{
            oldLast.next = last;
        }
        cnt++;
    }
    public Item pop(){
        Item now = first.item;
        first = first.next;
        cnt--;
        if (isEmpty()){
            last = null;
        }
        return now;
    }
    public boolean isEmpty(){
        return cnt == 0;
    }
    public int size(){
        return cnt;
    }

    public static void main(String[] args){
        QueueWithNode2 sn = new QueueWithNode2();
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
