package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 4/18/17.
 */
public class StackWithNode<Item> {
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public void push(Item s){
        Node oldfirst = first;                  // first 都没初始化过？怎么old first要新node.....
        first = new Node();
        first.item = s;
        first.next = oldfirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        //first = null;                        //------need?
        first = first.next;
        N--;                                  //------ 不用考虑N》0么？ 上面的old first是空？
        return item;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void main(String[] args){
        ResizeGenericsIteratorStack rgs = new ResizeGenericsIteratorStack(100);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            if (!s.equals("-")){
                rgs.push(s);
            } else if (!rgs.isEmpty()){
                System.out.println(rgs.pop()+" ");
            }
        }
        System.out.println(rgs.size()+"   "+rgs.isFull());
    }

}
