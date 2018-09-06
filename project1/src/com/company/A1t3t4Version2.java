package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 3/16/17.
 */
public class A1t3t4Version2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> left = new Stack<Character>();
        int l = s.length();
        char leftnow;
        int i = 0;
        while (i<l){
            char now = s.charAt(i);
            switch (now){
                case '(':
                case '[':
                case '{':
                    left.push(now);
                    break;
                case ')':
                    if (left.isEmpty()){
                        i = l*2;
                        break;
                    }
                    leftnow = left.pop();
                    if (leftnow == '('){
                        break;
                    }
                case ']':
                    if (left.isEmpty()){
                        i = l*2;
                        break;
                    }
                    leftnow = left.pop();
                    if (leftnow == '['){
                        break;
                    }
                case '}':
                    if (left.isEmpty()){
                        i = l*2;
                        break;
                    }
                    leftnow = left.pop();
                    if (leftnow == '{'){
                        break;
                    }
                default:
                    i = l*2;
                    //throw new Exception("must be (){}[]");
            }
            i++;
        }
        if ((left.isEmpty())&& (i!=l*2+1)){
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
