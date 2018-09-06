package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 4/18/17.
 */
public class FixedCapacityofStack {                // to be or not to - be - - that - - - is
    private String[] a;
    private int N;
    public FixedCapacityofStack(int cap){
        a = new String[cap];
    }

    public void push(String s){
        a[N++] = s;
    }

    public String pop(){
        return a[--N];
    }

    public boolean isEmpty(){
      return N==0;
    }

    public int size(){
        return N;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        FixedCapacityofStack fixedCapacityofStack = new FixedCapacityofStack(100);
        while (sc.hasNext()){
            String s = sc.next();
            if (!s.equals("-")){
                fixedCapacityofStack.push(s);
            } else if (!fixedCapacityofStack.isEmpty()){
                System.out.println(fixedCapacityofStack.pop()+" ");
            }
        }
        System.out.println(fixedCapacityofStack.size());
    }
}
