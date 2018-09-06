package com.company;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mileygao on 6/14/17.
 */
public class Chapt1FixedStack<Item> implements Iterable<Item>{  //to be or not to - be - - that - - - is
    private int N;
    private Item[] a;
    private Chapt1FixedStack(int cap){
        a =(Item[]) new Object[cap];
    }
    public void push(Item item){
        if (N == a.length){
            resize(N*2);
        }
        a[N++] = item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<Item>{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i!=0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
    private void resize(int maxN){
        Item[] b = (Item[])new Object[maxN];
        for (int i = 0; i<N;i++){
            b[i] = a[i];
        }
        a = b;
    }
    public Item pop(){
        if (!isEmpty()){
            Item t = a[--N];
            a[N] = null;
            if (N>0&&N == a.length/4){
                resize(a.length/2);
            }
            return t;
        }
        return null;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Chapt1FixedStack stack = new Chapt1FixedStack(1);
        while (sc.hasNext()){
            String t = sc.next();
            if (!t.equals("-")){
                stack.push(t);
            }else if(!stack.isEmpty()){
                stack.pop();
            }
            Iterator<String> it = stack.iterator();
            while (it.hasNext()){
                System.out.print(it.next()+"  ");
            }
        }

    }
}
