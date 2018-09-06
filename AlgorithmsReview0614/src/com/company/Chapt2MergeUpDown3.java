package com.company;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt2MergeUpDown3 <Item extends Comparable<Item>>{
    private Item[] aux;
    public void sort(Item[] a){
        aux = (Item[] )new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    private void sort(Item[] a, int lo, int hi){
        if (lo>=hi){
            return;
        }
        int mid = (lo+hi)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    public void merge(Item[] a, int lo, int mid, int hi){
        if (less(a[mid],a[mid+1])){
            return;
        }
        for(int i = lo; i<=hi; i++){
            aux[i] = a[i];
        }
        int p = lo;
        int q = mid+1;
        for (int i = lo; i<=hi; i++){
            if (p>mid){
                a[i] = aux[q++];
            }else if (q>hi){
                a[i] = aux[p++];
            }else if (less(a[p],a[q])){
                a[i] = aux[p++];
            }else {
                a[i] = aux[q++];
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
        Chapt2MergeUpDown3 sort = new Chapt2MergeUpDown3();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
