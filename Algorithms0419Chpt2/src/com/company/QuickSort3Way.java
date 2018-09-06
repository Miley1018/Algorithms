package com.company;


import java.util.*;

/**
 * Created by mileygao on 4/25/17.
 */
public class QuickSort3Way {
    public static void sort(Comparable[] a){
        shuffle(a);
        sort(a,0,a.length-1);
    }

    public static void shuffle(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            int j = (int) (Math.random()*(a.length-1-i))+i;
            exch(a,i,j);
        }
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if (hi<=lo+15){                     //-------------------------三分也可以用插入？
            for (int i = lo+1; i <= hi; i++){
                for (int j = i; j>0&&less(a[j],a[j-1]); j--){
                    exch(a,j,j-1);
                }
            }
        }else {
            int lt = lo;
            int gt = hi;
            int i = lo + 1;
            Comparable v = a[lo];
            while (i <= gt) {
                if (a[i].compareTo(v) > 0) {
                    exch(a, i, gt--);
                } else if (a[i].compareTo(v) < 0) {
                    exch(a, lt++, i++);
                } else {
                    i++;
                }
            }
            sort(a, lo, lt - 1);
            sort(a, gt + 1, hi);
        }
    }

    public static boolean less(Comparable a, Comparable b){              //  为什么放到sort里面，compareTo就调用不出了
        return a.compareTo(b)<0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length-1; i++){
            if (less(a[i+1],a[i])) {
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // write your code here
        String[] a = {"bed", "dad", "yes", "yet", "zoo" };
        String[] b = {"S", "O", "R" , "T", "E", };
        String[] c = {"1","0","2","3","5","3","2","6","8","1","98","0","0","88","98","89","20",};
        sort(c);
        assert isSorted(c);
        show(c);

        sort(a);
        assert isSorted(a);
        show(a);

        sort(b);
        assert isSorted(b);
        show(b);
    }
}
