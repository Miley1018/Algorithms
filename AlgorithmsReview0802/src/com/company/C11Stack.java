package com.company;

import java.util.Iterator;

/**
 * Created by mileygao on 8/2/17.
 */
public class C11Stack<Item > implements Iterable<Item>  {
    private int N;
    private Item[] arr;
    public C11Stack(int n){
        arr = (Item[])new Object[n];
    }
    private void resieze(int maxN){
        Item[] n = (Item[]) new Object[maxN];
        for (int i = 0; i<N; i++){
            n[i] = arr[i];
        }
        arr = n;
    }
    public void push(Item item){
        if (N==arr.length){
            resieze(N*2);
        }
        arr[N++] = item;
    }
    public Item pop(){
        Item a = arr[--N];
        arr[N] = null;
        if (N>0&&N==arr.length/4){
            resieze(arr.length/2);
        }
        return a;
    }

    @Override
    public Iterator<Item> iterator() {
        return new myIter();
    }

    public class myIter implements Iterator{
        private int t = N;
        @Override
        public boolean hasNext() {
            return t>0;
        }

        @Override
        public Object next() {
            return arr[--t];
        }
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public static void main(String[] args){
        C11Stack<String> s = new C11Stack<>(2);
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");
        s.pop();
        System.out.println(s.size()+" "+s.isEmpty());
        for (String i : s){
            System.out.println(i);
        }
    }
}
