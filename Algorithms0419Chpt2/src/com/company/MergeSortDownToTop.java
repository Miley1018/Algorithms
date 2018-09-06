package com.company;

/**
 * Created by mileygao on 4/25/17.
 */
public class MergeSortDownToTop {
    public static Comparable[] au;
    public static void sort(Comparable[] a){
        au = new Comparable[a.length];
        for (int sz = 1; sz<a.length;sz += sz){              //why not starting from sz=2?
            for (int lo = 0; lo<a.length-sz;lo+=sz+sz){
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,a.length-1));
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
