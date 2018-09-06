package com.company;

/**
 * Created by mileygao on 7/7/17.
 */
public class Chapt2MergeDownUp4<Item extends Comparable<Item>> {
    private Item[] aux;
    public void sort(Item[] a){
        aux = (Item[])new Comparable[a.length];
        for (int sz = 1; sz<a.length;sz=sz+sz){
            for (int i = 0;i+sz<a.length;i=i+sz+sz){
                merge(i,i+sz-1,i+sz+sz-1>a.length-1?a.length-1:i+sz+sz-1,a);
            }
        }
    }
    public void merge(int lo, int mid, int hi,Item[] a){
        for (int i = lo;i<=hi;i++){
            aux[i] = a[i];
        }
        int lt = lo;
        int gt = mid+1;
        int i = lo;
        while (i<=hi){
            if (lt>mid){
                a[i++] = aux[gt++];
            }else if (gt>hi){
                a[i++] = aux[lt++];
            }else if (less(aux[lt],aux[gt])){
                a[i++] = aux[lt++];
            }else {
                a[i++] = aux[gt++];
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
        String[] a = {"dad", "yes", "bed", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O","A"};                                 // EORST
        Chapt2MergeDownUp4 sort = new Chapt2MergeDownUp4();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
