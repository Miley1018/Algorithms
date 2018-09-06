package com.company;

/**
 * Created by mileygao on 4/20/17.
 */
public class InsertionSort {
    public static void sort(Comparable[] a){
        int index = 0;
        for (int i = 0; i <a.length-1; i++){
            Comparable now = a[i+1];
            index = i;
            int j = i;
            while (j>=0){
                if (less(now,a[j])){
                    exch(a,j,i+1);
                }
                i--;
                j--;
            }
            i = index;
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
        for (int i = 0; i < a.length-1; i++){
            if (less(a[i+1],a[i])){
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] a ){
        for (int i = 0; i<a.length; i++){
            System.out.print(a[i]);
        }
    }

    public static void main(String[] args){
        String[] a = {"dad", "bed", "yet", "yes", "zoo" };    //bed, dad, ..., yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E", };
        sort(a);
        assert isSorted(a);
        show(a);

        sort(b);
        assert isSorted(b);
        show(b);
    }
}
