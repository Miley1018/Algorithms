package com.company;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt2QuickSort2<Item extends Comparable<Item>> {
    public void sort(Item[] a){
        sort(a,0,a.length-1);
    }
    private void sort(Item[] a, int lo, int hi){
        if (lo>=hi){ //>??--------------------------------------------
            return;
        }
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private int partition(Item[] a, int lo, int hi){
        int v = lo;
        int p = lo;
        int q = hi+1;
        while (true){
            while (less(a[++p],a[v])){
                if (p>=hi){
                    break;
                }
            }
            while (less(a[v],a[--q])){
            }
            if (p>=q){//>?--------------------------------------------
                break;
            }
            exch(p,q,a);
        }
        exch(q,v,a);
        return q;
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
        Chapt2QuickSort2 sort = new Chapt2QuickSort2();
        String[] a = {"bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
