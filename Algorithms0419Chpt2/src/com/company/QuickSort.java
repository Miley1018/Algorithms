package com.company;




/**
 * Created by mileygao on 4/25/17.
 */
public class QuickSort {
    public static void sort(Comparable[] a){
        shuffle(a);
        show(a);
        int lo=0,hi=a.length-1;
        int max = lo;
        for (int k = lo+1; k <a.length; k++){ // ----------------------------------------------max 作为右哨兵？P205，2.3.17
            if (less(a[max],a[k])){
                max = k;
            }
        }
        exch(a,hi,max);
        sort(a,0,a.length-1);
    }

    public static void shuffle(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            int j = (int) (Math.random()*(a.length-i))+i;
            exch(a,i,j);
        }
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if (hi<=lo+15){
            for (int i = lo+1; i <= hi; i++){
                for (int j = i; j>0&&less(a[j],a[j-1]); j--){
                    exch(a,j,j-1);
                }
            }
        } else {
            int j = partition(a, lo, hi);
            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
        }
    }

    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;
        Comparable v;
        for (int k = lo+1; k < lo+3; k++){ // ------------------------------------------------??
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
        String[] a = {"bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
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
