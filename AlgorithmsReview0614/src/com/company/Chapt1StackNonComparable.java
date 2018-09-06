package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 7/6/17.
 */
public class Chapt1StackNonComparable<Item> {
    private int N;
    private Item[] items;
    public Chapt1StackNonComparable(int cp){
        items =(Item[]) new Object[cp];
    }
    private void resize(int maxN){
        Item[] a = (Item[]) new Object[maxN];
        for (int i = 0; i<N; i++){
            a[i] = items[i];
        }
        items = a;
    }
    public void push(Item item){
        if (N==items.length){
            resize(N*2);
        }
        items[N++] = item;
    }
    public Item pop(){
        Item t = items[--N];
        if (N>0&&N==items.length/4){
            resize(items.length/2);
        }
        return t;
    }
    public int size(){
        return N;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Chapt1StackNonComparable stack = new Chapt1StackNonComparable(3);
        int[] aa = {3,2,4,1,-1};
        int i = 0;
        while (i<aa.length){
            stack.push(aa[i++]);
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
