package com.company;

import java.util.Arrays;

public class Main {
    public void erFenSearching(int[] a, int key){
        Arrays.sort(a);
        int l = a.length-1;
        int lo = 0;
        int hi = l;
        while (lo<=hi){
            int mid = (hi-lo)/2+lo;
            if (key<a[mid]){
                hi = mid-1;
            }else if (key>mid){
                lo = mid+1;
            }else{
                System.out.println(a[mid]);
                System.exit(0);
            }
        }
        System.out.println("Not found");

    }

    public static void main(String[] args) {
	// write your code here
        int[] a = {0,1,2,4,5,3};
        int key = 3;
        Main main = new Main();
        main.erFenSearching(a,key);
    }
}
