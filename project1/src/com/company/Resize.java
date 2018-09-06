package com.company;

import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;

/**
 * Created by mileygao on 3/15/17.
 */
public class Resize {
    public static void main(String[] args){
        Generics.FixedStack<String> fs = new Generics.FixedStack<String>(100);
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
        private int cap;
        FixedStack(int cap){
            a = (Item[])new Object[cap];
            this.cap= cap;
        }
        Item pop(){
            if (N==a.length/4 && N>0){
                resize(a.length/2);
            }
            return a[--N];   //N is changing as well. If N-1, N is not changing.
        }

        void push(Item k){
            if (N==a.length){
                resize(a.length*2);
            }
            a[N++] = k;
        }

        void resize(int max){
            Item[] b = (Item[]) new Object[max];
            for (int i =0; i<N;i++){
                b[i] = a[i];
            }
            a = b;
        }

        boolean isEmpty(){
            return N==0;
        }

        int size(){
            return N;
        }
    }

}
