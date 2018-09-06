package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by mileygao on 6/20/17.
 */
public class Chapt2QuickSort3WayLessEqual<Item extends Comparable<Item>> {//错误 需重写
    public void sort(Item[] a){
        List<Item> list = Arrays.asList(a);
        Collections.shuffle(list);
        sort(a,0,a.length-1);
    }
    private void sort(Item[] a, int lo, int hi){
        if (lo>=hi){
            return;
        }
        int lt = lo, gt = hi, m = lo+1,n=hi-1;
        Item v = a[lo];
        while (m<n){
            int cmp = a[m].compareTo(v);
            if (cmp>0){
                exch(m,n--,a);
            }else if (cmp<0){
                m++;
            }else{
                exch(lt++,m++,a);
            }
        }
        while(m<n){
            int cmp2 = a[n].compareTo(v);
            if (cmp2>0){
                n--;
            }else if (cmp2<0){
                exch(n,m++,a);
            }else {
                exch(gt--,n--,a);
            }
        }
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
        String[] a = {"bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        Chapt2QuickSort3WayLessEqual sort = new Chapt2QuickSort3WayLessEqual();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
