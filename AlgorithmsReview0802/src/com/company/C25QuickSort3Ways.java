package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mileygao on 8/4/17.
 */
public class C25QuickSort3Ways<Item extends Comparable<Item>> {
    public void sort(Item[] a){
        List b = Arrays.asList(a);
        Collections.shuffle(b);
        sort(a, 0, a.length-1);
    }
    private void sort(Item[]a, int lo, int hi){
        if (lo>=hi){
            return;
        }
        Item v = a[lo];
        int lt = lo;
        int i = lo;
        int j = hi+1;
        while (lt<j-1){
            int cmp = v.compareTo(a[++lt]);
            if (cmp>0){
                exch(lt,++i,a);
            }else if (cmp<0){
                exch(lt,--j,a);
                lt--;
            }else {
            }
        }
        exch(i,lo,a);
        sort(a,lo,i-1);
        sort(a,j,hi);
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
        C25QuickSort3Ways sort = new C25QuickSort3Ways();
        String[] a = {"","bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"","S", "O", "R" , "T", "E"};                                 // EORST
        String[] c = {"","a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        String[] d = {"a"};
        String[] e = {"d","a","a","d","d","b","c","c"};
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
