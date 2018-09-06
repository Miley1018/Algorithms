package com.company;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mileygao on 4/18/17.
 */
public class ResizeGenericsIteratorStack<Item> implements Iterable<Item>{
    private Item[] a;
    private int N;
    public ResizeGenericsIteratorStack(int cap){
        a = (Item[])new Object[cap];
    }
    public void push(Item s){
        if (N == a.length){
            reseize(2*a.length);
        }
        a[N++] = s;
    }

    public  Item pop(){
        Item temp = a[--N];
        a[N] = null;
        if (N == a.length/4 && N>0){
            reseize(a.length/2);
        }
        return temp;
    }
    public void reseize(int max){
        Item[] temp =(Item[]) new Object[max];
        for (int i = 0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isFull(){
        return N==a.length;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public Iterator<Item> iterator(){
        return new ReverseIterator();
    }

    public class ReverseIterator implements Iterator<Item>{
        private int i = N;
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];                   //  ---------------------------------------why not use N , not i? 因为N是别人的，不能改
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args){
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


