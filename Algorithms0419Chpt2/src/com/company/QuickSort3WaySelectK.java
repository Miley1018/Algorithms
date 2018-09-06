package com.company;


/**
 * Created by mileygao on 4/25/17.
 */
public class QuickSort3WaySelectK {
    public static Comparable select(Comparable[] a, int k){
        shuffle(a);
        int lo = 0;
        int hi = a.length-1;
        while (lo<hi){
            int j = partition(a,lo,hi);
            if (k<j){
                hi= j-1;
            }else if (k>j){
                lo= j+1;
            }else {
                return a[k];
            }
        }
        return a[k]; // ------------------------------------------------two return?
    }

    public static void shuffle(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            int j = (int) (Math.random()*(a.length-1-i))+i;
            exch(a,i,j);
        }
    }
    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;
        Comparable v;
        for (int k = lo+1; k < lo+3; k++){
            for (int kk = k; kk>lo&&less(a[kk],a[kk-1]);kk--){
                exch(a,kk,kk-1);
            }
        }
        Comparable temp = a[lo];
        a[lo] = a[lo+1];
        a[lo+1] = temp;
        show(a);
        v = a[lo];
        while (true){
            while (less(v, a[--j])){
            }
            while (less(a[++i],v)){
            }
            if (i>=j){
                break;
            }
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
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
        String[] c = {"1","0","2","3","5","3","2","6","8","1","98","0","0","88","98","89","20"};
        System.out.println(select(c,0));
    }
}
