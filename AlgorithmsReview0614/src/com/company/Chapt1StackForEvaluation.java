package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 7/6/17.
 */
public class Chapt1StackForEvaluation {
    private Chapt1StackNonComparable<String> ops;
    private Chapt1StackNonComparable<Integer> vals;
    public Chapt1StackForEvaluation(){
        ops = new Chapt1StackNonComparable<>(3);
        vals = new Chapt1StackNonComparable<>(3);
    }
    public static void main(String[] args){
        Chapt1StackForEvaluation s = new Chapt1StackForEvaluation();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        while (!a.equals("=")){
            //System.out.println(a);
            if (a.equals("(")){
                a = sc.next();
            }else if (a.equals("-")||a.equals("+")||a.equals("*")||a.equals("/")){
                s.ops.push(a);
                //System.out.println("ops:"+a);
                a=sc.next();
            }else if(a.equals(")")){
                int i = s.vals.pop();
                int j = s.vals.pop();
                String t = s.ops.pop();
                int now;
                if (t.equals("-")){
                    now = j-i;
                }else if (t.equals("+")){
                    now = j+i;
                }else if (t.equals("*")){
                    now = j*i;
                }else {
                    now = j/i;
                }
                s.vals.push(now);
                a = sc.next();
            }else {
                s.vals.push(Integer.parseInt(a));
                System.out.println("val:"+a);
                a = sc.next();
            }
        }
        System.out.println(s.vals.pop());
    }
}
