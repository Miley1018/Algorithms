package com.company;

public class SelectionSort {
    public static void sort(Comparable[] a){
        for (int j = 0; j<a.length; j++) {
            int min = j;
            for (int i = j+1; i < a.length; i++) {
                if (less(a[i],a[min])) {
                    min = i;
                }
            }
            exch(a, min, j);
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
        String[] a = {"bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E", };                                 // EORST
        sort(a);
        assert isSorted(a);
        show(a);

        sort(b);
        assert isSorted(b);
        show(b);
    }
}
