package com.company;

/**
 * Created by mileygao on 4/5/17.
 */
public class add12100 {
    public static void main(String[] args){
        int s = 0;
        for (int i = 1; i <= 100; i++){
            s = s + i;
        }
        System.out.println(s);

        System.out.print(add12100.feibo(8));
    }

    public static int feibo(int n){
        if ((n==2)||(n==1)){
            return 1;
        }else{
            return feibo(n-1)+feibo(n-2);
        }
    }
}
