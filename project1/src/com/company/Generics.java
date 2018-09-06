package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 3/15/17.
 */
public class Generics{
    public static void main(String[] args){
        FixedStack<String> fs = new FixedStack<String>(100);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.next();
            if (!a.equals("-")){
                fs.push(a);
            }else if (!fs.isEmpty()){
                System.out.println( fs.pop());
            }
        }

        System.out.println(fs.size()+"left");
    }

    static class FixedStack<Item>{
        private int N;
        private Item[] a;
        FixedStack(int cap){
            a = (Item[])new Object[cap];
        }
        Item pop(){
            return a[--N];   //N is changing as well. if N-1, N is not changing.
        }

        void push(Item k){
            a[N++] = k;
        }

        boolean isEmpty(){
            return N==0;
        }

        int size(){
            return N;
        }
    }

}
