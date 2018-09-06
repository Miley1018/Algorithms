package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mileygao on 6/16/17.
 */
public class Chapt2QuickSort<Item extends Comparable> {
    public void sort(Item[] a){
        List<Item> list = Arrays.asList(a);
        Collections.shuffle(list);
        //a = (Item[])list.toArray();
        for (Item j:a){
            System.out.println(j+"---");
        }
        sort(a,0,a.length-1);
    }
    private void sort(Item[] a, int lo, int hi){
        if (lo>=hi){
            return;
        }
        int par = partition(a,lo,hi);
        sort(a,lo,par-1);
        sort(a,par+1,hi);
    }
    public int partition(Item[] a,int lo, int hi){
        Item v = a[lo];
        int lt = lo;
        int gt = hi+1;
        while (true) {
            while (less(a[++lt], v)) {
                if (lt==hi){
                    break;
                }
            }
            while (less(v, a[--gt])) {
                //if(gt==lo)break;
            }
            if (lt>=gt){
                break;
            }
            exch(lt, gt, a);
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
        String[] a = {"bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        Chapt2QuickSort sort = new Chapt2QuickSort();
        sort.sort(a);
        sort.show(a);
        sort.sort(b);

        sort.show(b);
    }
}
