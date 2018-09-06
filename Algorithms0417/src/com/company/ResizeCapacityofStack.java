package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 4/18/17.
 */
public class ResizeCapacityofStack {                // to be or not to - be - - that - - - is
    private String[] a;
    private int N;
    private int cap;
    public ResizeCapacityofStack(int cap){
        a = new String[cap];
        this.cap = cap;
    }

    public void push(String s){
        if (N==a.length){
            resize(2*N);
        }
        a[N++] = s;
    }

    public String pop(){
        String temp = a[--N];
        a[N]=null;
        if (N == a.length/4 && N>0){
            resize(a.length/2);
        }
        return temp;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void resize(int Max){
       String[] temp = new String[Max];
       for (int i = 0; i < N; i++){
           temp[i] = a[i];
       }
       a = temp;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ResizeCapacityofStack resizeCapacityofStack = new ResizeCapacityofStack(100);
        while (sc.hasNext()){
            String s = sc.next();
            if (!s.equals("-")){
                resizeCapacityofStack.push(s);
            } else if (!resizeCapacityofStack.isEmpty()){
                System.out.println(resizeCapacityofStack.pop()+" ");
            }
        }
        System.out.println(resizeCapacityofStack.size());
    }
}
