package com.company;

import java.util.*;

/**
 * Created by mileygao on 7/10/17.
 */
public class Chapt2QuickSort4<Item extends Comparable<Item>> {
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
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private int partition(Item[] a, int lo, int hi){
        int lt = lo;
        int gt = hi+1;
        Item v = a[lo];
        while (true){
            while (less(a[++lt],v)){
                if (lt==hi){
                    break;
                }
            }
            while (less(v,a[--gt])){
            }
            if (lt>=gt){
                break;
            }
            exch(lt,gt,a);
        }
        exch(lo,gt,a);
        return gt;
    }
    private boolean less(Item a, Item b){
        return a.compareTo(b)<0;
    }
    private void exch(int i, int j, Item[] a){
        Item temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void show(Item[] a){
        for (int i = 0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){

        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        Chapt2QuickSort4 sort = new Chapt2QuickSort4();
        sort.sort(b);

        sort.show(b);
        String[] a = {"bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.show(a);

    }
}
