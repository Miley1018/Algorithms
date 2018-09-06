package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 3/15/17.
 */
public class FixedCapacityStackOfStrings {
    public static void main(String[] args){
        FixedStack fs = new FixedStack(100);
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

    static class FixedStack{
        private int N;
        private String[] a;
        FixedStack(int cap){
            a = new String[cap];
        }
        String pop(){
            return a[--N];   //N is changing as well. if N-1, N is not changing.
        }

        void push(String k){
            a[N++] = k;
        }

        boolean isEmpty(){
            return N==0;
        }

        boolean isFull(){
            return N==a.length;
        }

        int size(){
            return N;
        }
    }
}
