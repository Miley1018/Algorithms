package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mileygao on 6/19/17.
 */
public class Chapt2QuickSort3Ways<Item extends Comparable<Item>> {
    public void sort(Item[] a){
        List<Item> list = Arrays.asList(a);
        Collections.shuffle(list);
        sort(a,0,a.length-1);
    }
    private void sort(Item[] a, int lo, int hi){
       if (lo>=hi){
           return;
       }
       Item v = a[lo];
       int lt = lo;
       int ht = hi;
       int i = lo+1;
       while (i<=ht){
           int cmp = a[i].compareTo(v);
           if (cmp>0){
                exch(ht--,i,a);
           }else if(cmp<0){
               exch(i++,lt++,a);
           }else{
               i++;
           }
       }
       sort(a,lo,lt-1);
       sort(a,ht+1,hi);
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
        String[] a = {"dad", "yes","bed",  "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        Chapt2QuickSort3Ways sort = new Chapt2QuickSort3Ways();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
