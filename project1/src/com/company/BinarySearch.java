package com.company;

import java.util.Arrays;

/**
 * Created by mileygao on 3/13/17.
 */
public class BinarySearch extends A11{
    static boolean binarySearch(int key, int[] a){
        Arrays.sort(a);
        int lo = 0;
        int hi = a.length-1;
        while (lo<hi){
            int mid = ((hi-lo)/2+lo);
            if (a[mid]>a[key]){
                hi = mid - 1;
            }else if(a[mid]<a[key]){
                lo = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
