package com.company;
import java.util.Scanner;
import java.util.Stack;
/**
 * Created by mileygao on 3/15/17.
 */
public class Math {
    public static void main(String[] args){
        Stack<String> ops = new Stack<String>();
        Stack<Double> var = new Stack<Double>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int l = s.length();
        for (int i =0; i<l;i++){
            char c = s.charAt(i);
            switch (c){
                case '(': break;
                case '+':
                case '-':
                case '*':
                case '/':
                    ops.push(c+"");
                    break;
                case ')':{
                    String op = ops.pop();
                    Double v = var.pop();
                    switch (op){
                        case "+": v = var.pop() + v; break;
                        case "-": v = var.pop() - v; break;
                        case "*": v = var.pop() * v; break;
                        case "/": v = var.pop() / v; break;
                    }
                    var.push(v);
                    break;
                }
                default:var.push(Double.parseDouble(c+""));
            }
        }
        System.out.println(var.pop());
    }
}
