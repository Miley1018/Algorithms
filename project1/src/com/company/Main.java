package com.company;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }
    public static int mystery(int a, int b)
    {
        if (b == 0)     return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
    public static void main(String[] args) {
        Stack<Integer> sta = new Stack<Integer>();
        sta.push(17);
        System.out.print(sta.pop());

        String s1 = "hello";
        String s2 = s1;
        s1 = "world";
        System.out.println(s2+s1);
        String s ="hello world";
        s.toUpperCase();
        System.out.println(s);
        s=s.toUpperCase();
        s=s.substring(1,11);
        System.out.println(s);
        System.out.print(mystery(2,25));
        System.out.print(mystery(3,11));
        System.out.println('b');
        System.out.println('b' + "c");
        System.out.println((char) ('a' + 4));
        int[][] A = {{1,2,3,4},{5,6,7,8}};
        A11.change2D1113(A);
        A11.d2();
        System.out.println(A11.binary(8));
        Main a = new Main();
        try{System.out.println( a.ojilide(30,10));}
        catch (IllegalArgumentException e){
            System.out.println("error"+e.getMessage());
        }
        Scanner sc = new Scanner(System.in);
        try {
            int i = sc.nextInt();
        } catch (InputMismatchException e){
            System.out.println("chucuola:" + e.getMessage());

            //e.printStackTrace();
        }
        System.out.println("lll");

        int[] arrays = {};
        int l =arrays.length;
        //could this be put into print directly?
        System.out.println(l+""+BinarySearch.binarySearch(4,arrays));

        Scanner scanner = new Scanner(System.in);
        int aa = scanner.nextInt();                 //cant use private here?
        int bb = scanner.nextInt();
        int cc = scanner.nextInt();
        System.out.println(A11.equalCheck(aa,bb,cc));

        double x = 0.2;
        double y = 0.9;
        System.out.println(A11.doubleCheck(x,y));


        }



    int ojilide(int p, int q){
        throw new IllegalArgumentException("wwwwwwww");
        /*
        if (q==0){
            return p;
        }else{
            int r = p%q;
            return ojilide(q,r);
        }
        */
    }
}
