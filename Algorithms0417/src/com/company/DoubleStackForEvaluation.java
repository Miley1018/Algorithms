package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mileygao on 4/17/17.
 */
public class DoubleStackForEvaluation {
    public static void main(String[] args){
        Stack<String> ops = new Stack<String >();
        Stack<Integer> nums = new Stack<Integer>();
        Scanner scanner = new Scanner(System.in);
        int newNum = 0;
        while (scanner.hasNext()){
            String now = scanner.next();             //how nextString?
            if (now.equals("(")){
                continue;
            }
            else if (now.equals("+")){
                ops.push(now);
            }
            else if (now.equals("-")){
                ops.push(now);
            }
            else if (now.equals("*")){
                ops.push(now);
            }
            else if (now.equals("/")){
                ops.push(now);
            }
            else if (now.equals(")")){
                String nowOps = ops.pop();
                if (nowOps.equals("+")){
                    newNum = nums.pop()+nums.pop();
                    System.out.println(newNum);
                    nums.push(newNum);
                }
                if (nowOps.equals("-")){
                    newNum = -(nums.pop()-nums.pop());
                    nums.push(newNum);
                }
                if (nowOps.equals("*")){
                    newNum = nums.pop()*nums.pop();
                    nums.push(newNum);
                    System.out.println(newNum);
                }
                if (nowOps.equals("/")){
                    newNum = 1/(nums.pop()/nums.pop());
                    nums.push(newNum);
                }
            }
            else{
                nums.push(Integer.parseInt(now));
            }
        }
        System.out.println(nums.pop());

    }

}
