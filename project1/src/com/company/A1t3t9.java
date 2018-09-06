package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mileygao on 3/16/17.
 */
public class A1t3t9 {
    public static void main(String[] args){   //1+2)*3-4)*5-6)))
        Stack<String> ops = new Stack<String>();
        Stack<String> var = new Stack<String>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int l = s.length();
        for (int i =0; i<l;i++){
            char c = s.charAt(i);
            switch (c){
                case '+':
                case '-':
                case '*':
                case '/':
                    ops.push(c+"");
                    break;
                case ')':{
                    String op = ops.pop();
                    String v = var.pop();
                    var.push("("+var.pop()+op+v+c);
                    break;
                }
                default:var.push(c+"");
            }
        }
        for (int i =0; i<var.size();i++){
            System.out.println(var.pop());
        }
    }
}
