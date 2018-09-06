package com.company;

/**
 * Created by mileygao on 4/21/17.
 */
public class MergeSort {
    public static class Merge{
        private Comparable[] au;
        public void sort(Comparable[] a){
            au = new Comparable[a.length];
            sort(a,0, a.length-1);
        }

        public void sort(Comparable[] a, int lo, int hi){
            if (hi<=lo){
                return;                                 // --------------------------if no?
            }
            int mid = lo + (hi-lo)/2;
            sort(a,lo,mid);
            sort(a,mid+1,hi);
            merge(a,lo,mid,hi);
        }

        public void merge(Comparable[] a, int lo, int mid, int hi){
            for (int i = lo; i < hi; i++){
                au[i] = a[i];
            }
            int i = lo;
            int j = mid+1;
            for (int k = lo; k <= hi; k++){
                if (less(au[j],au[i])){
                    a[k] = au[j++];
                } else if (i>mid){
                    a[k] = au[j++];
                } else if (j>hi){
                    a[k] = au[i++];
                } else{
                    a[k] = au[i++];
                }
            }
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
        Merge merge = new Merge();
        merge.sort(a);
        assert isSorted(a);
        show(a);
    }
}
