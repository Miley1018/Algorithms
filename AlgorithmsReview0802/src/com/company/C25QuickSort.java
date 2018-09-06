package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mileygao on 8/4/17.
 */
public class C25QuickSort <Item extends Comparable<Item>>{
    public void sort(Item[] a){
        List b = Arrays.asList(a);
        Collections.shuffle(b);
        show(a);
        sort(a,0,a.length-1);
    }
    private void sort(Item[] a, int lo, int hi){
        if (lo>=hi){
            return;
        }
       /* if (lo+15>hi){
            insertionSort(a,lo,hi);
            return;
        }*/
       int par = partition(a,lo,hi);
       sort(a,lo,par-1);
       sort(a,par+1,hi);
    }
    private int partition(Item[] a, int lo, int hi){
       Item v = a[lo];
       int lt = lo;
       int gt = hi+1;
       while (lt<gt) {
           while (lt<hi&&less(a[++lt], v)) {
           }
           while (less(v, a[--gt])) {
           }
           if (lt>=gt){
               break;
           }
           exch(lt,gt,a);
       }
       exch(lo,gt,a);
       return gt;
    }
    private void insertionSort(Item[] a,int lo, int hi){
        Item v;
        for (int i = lo; i<=hi;i++){
            v = a[i];
            int j = i-1;
            for (; j>=0; j--){
                if (less(v,a[j])){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = v;
        }
    }
    public boolean less(Item a, Item b){
        return a.compareTo(b)<0;
    }
    public void exch(int i, int j, Item[] a){
        Item t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public void show(Item[] a){
        for (int i = 0; i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
    public static void main(String[] args){
        C25QuickSort sort = new C25QuickSort();
        String[] a = {"","bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"","S", "O", "R" , "T", "E"};                                 // EORST
        String[] c = {"","a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        String[] d = {"a"};
        String[] e = {"d","a"};
        sort.sort(b);
        sort.show(b);
        sort.sort(e);
        sort.show(e);
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.show(a);

        sort.sort(d);
        sort.show(d);

    }
}
