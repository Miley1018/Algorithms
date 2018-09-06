package com.company;

/**
 * Created by mileygao on 5/1/17.
 */
public class StackSort {
    public static void sort(Comparable[] a){
        int N = a.length-1;
        for (int i = N/2; i >0; i--){
            sink(a,i,N);
        }
        show(a);
        while (N>1){
            exch(a,1,N--);
            sink(a,1,N);
        }
    }

    public static void sink(Comparable[] a, int k, int n){
        while (k<=n/2){
            int j = 2*k;
            if (j<n && less(a[j+1],a[j])){
                j++;
            }
            if (!less(a[j],a[k])){
                break;
            }
            exch(a,k,j);
            k = j;
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
        for (int i = 1; i < a.length-1; i++){
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
        String[] a = {"0","bed", "dad", "yes", "yet", "zoo" };
        String[] b = {"0","S", "O", "R" , "T", "E" };
        String[] c = {"0","1","0","2","3","5","3","2","6","8","1","98","0","0","88","98","89","20"};
        sort(c);
        assert isSorted(c);
        System.out.println(isSorted(c));
        show(c);

        sort(a);
        assert isSorted(a);
        show(a);

        sort(b);
        assert isSorted(b);
        show(b);
    }
}
