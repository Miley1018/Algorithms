package com.company;

import java.util.Scanner;

/**
 * Created by mileygao on 3/13/17.
 */
public class A11 {
    static String equalCheck(int a , int b, int c){
        if ((a==b)&&(b==c)){
            return "equal";
        }else{
            return "not equal";
        }
    }

    static boolean doubleCheck(double x, double y){
        if ((x>0)&&(x<1)&&(y>0)&&(y<1)){
            return true;
        }
        return false;
    }

    static String binary(int N){
        String s = "";
        for (int n=N;n>0;n/=2){
            s=n%2+s;
        }
        return s;
    }

    static void d2(){
        String[][] d2 = {{" ","*"},{" "," "},{" ","*"},{" "," "}};    //could use toString return?
        for (int i =0;i<4;i++){
            for (int j = 0; j<2;j++){
                System.out.print(i+""+j+ d2.toString());
            }
            System.out.println(" ");
        }
    }

    static void change2D1113(int[][] A){
        for(int i =0; i<A[0].length;i++){
            for(int j =0; j<A.length;j++){
                System.out.print(A[j][i]+" ");
            }
            System.out.println(" ");
        }
    }
    private int[]a = new int[10000];
    boolean[] b = new boolean[10000];
    int fibonacci(int N){

       if (N==0){
           a[N]=0;
           return a[N];
       }
       if (N==1){
           a[N]=1;
           return a[N];
       }
       if(b[N]){
           return a[N];
       }
       else {
           a[N] = fibonacci(N-1)+fibonacci(N-2);
           b[N] = true;
           return a[N];
       }
    }

}
