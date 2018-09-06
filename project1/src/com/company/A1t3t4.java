package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mileygao on 3/16/17.
 */
public class A1t3t4 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> small = new Stack<Character>();
        Stack<Character> mid = new Stack<Character>();
        Stack<Character> big = new Stack<Character>();
        int l = s.length();
        int bi = 0;
        int sm = 0;
        int mi = 0;
        for (int i = 0; i < l; i++){
            char now = s.charAt(i);
            switch (now){
                case '(':
                    small.push(now);
                    break;
                case '[':
                    mid.push(now);
                    break;
                case '{':
                    big.push(now);
                    break;
                case ')':
                    if (small.size()==0){
                        sm++;
                    }
                    else{
                        small.pop();}
                    break;
                case ']':
                    if (mid.size()==0){
                        mi++;
                    }
                    else{
                        mid.pop();}
                    break;
                case '}':
                    if (big.size()==0){
                        bi++;
                    }
                    else{
                        big.pop();}
                    break;
                default:
                    throw new Exception("must be (){}[]");  // how to print?
            }
        }
        if ((small.isEmpty() || sm==small.size()) && (mid.isEmpty() || mi==mid.size()) && (big.isEmpty() || bi==big.size())){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }

    private static class Stack<Item>{
        private Node first;
        private int N;
        private class Node{
            Node next;
            Item item;
        }

        void push(Item item){
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            N++;
        }

        Item pop(){
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }

        boolean isEmpty(){
            return first == null;
        }

        int size(){
            return N;
        }
    }
}
