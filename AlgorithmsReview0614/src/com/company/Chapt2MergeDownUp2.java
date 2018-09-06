package com.company;

/**
 * Created by mileygao on 6/19/17.
 */
public class Chapt2MergeDownUp2<Item extends Comparable<Item>> {
    private Item[] aux;
    public void sort(Item[] a){
        aux = (Item[]) new Comparable[a.length];
        for (int sz = 1; sz<a.length;sz = sz+sz){
          for (int lo = 0; lo<a.length-sz; lo = lo+sz+sz){
              merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,a.length-1));
          }
        }
    }
    private void merge(Item[] a, int lo, int mid, int hi){
        if (less(a[mid],a[mid+1])){
            return;
        }
        int i= lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++){
            aux[k] = a[k];
        }
        for (int k = lo; k<hi; k++){
            if (i>mid){
                a[k] = aux[j++];
            }else if(j>hi){
                a[k] =aux[i++];
            }else if (less(aux[i],aux[j])){
                a[k] = aux[i++];
            }else{
                a[k] = aux[j++];
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
        Chapt2MergeDownUp2 sort = new Chapt2MergeDownUp2();
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
