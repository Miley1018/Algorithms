package com.company;

/**
 * Created by mileygao on 4/25/17.
 */
public class MergeSortTopToDown {
    public static Comparable[] au;
    public static void sort(Comparable[] a){
        au = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if ((hi-lo)<=15){
            for (int i = lo+1; i <=hi; i++){
                for (int j = i; j>lo && less(a[j],a[j-1]);j--){
                    exch(a,j,j-1);
                }
            }
        }else {
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            if (less(a[mid],a[mid+1])){
                return;
            }else {
                merge(a, lo, mid, hi);
            }
        }
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <=hi; k++){
            au[k] = a[k];
        }
        for (int k = lo; k <=hi; k++){
            if (j>hi){
                a[k] = au[i++];
            }else if (i>mid){
                a[k] = au[j++];
            }else if (less(au[j],au[i])){
                a[k] = au[j++];
            }else{
                a[k] = au[i++];
            }
        }
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            if (less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args){
        String[] a = {"1","0","2","3","5","3","2","6","8","1","98","0","0","88","98","89","20",};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
