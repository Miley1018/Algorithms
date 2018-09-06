package com.company;

/**
 * Created by mileygao on 4/21/17.
 */
public class ShellSort {
    public static void sort(Comparable[] a){
        int h = 0;
        while (h<a.length){
            h = 3*h+1;
        }
        while (h>0){
            for (int i = h; i < a.length; i++){
                for (int j =i; j>=h && less(a[j], a[j-h]);j = j - h){
                    exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }

    private static void exch(Comparable[] a, int i , int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length-1; i++){
            if (less(a[i+1],a[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String[] a = {"dad", "bed", "yet", "yes", "zoo" };    //bed, dad, ..., yes, yet, zoo
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
