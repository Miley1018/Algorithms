package com.company;

/**
 * Created by mileygao on 6/16/17.
 */
public class Chapt2MergeDownUp {
    private Comparable[] aux;
    public void sort(Comparable[] a){
        /*if (a.length<15){
            insert(a);
        }*/
        aux = new Comparable[a.length];
        for (int size = 1; size<a.length; size*=2){
            for (int lo=0; lo<a.length-size;lo=lo+size+size){
                merge(a,lo,lo+size-1,Math.min((lo+size+size-1),a.length-1));
            }
        }
    }
    private void insert(Comparable[] a){
        for (int i = 0; i<a.length;i++){
            for (int j = i; j>0;j--){
                if (less(a[j],a[j-1])){
                    exch(j,j-1,a);
                }
            }
        }
    }
    private void merge(Comparable[] a, int lo, int mid, int hi){
        if (less(a[mid],a[mid+1])){
            return;
        }
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++){
            aux[k] = a[k];
        }
        for (int k = lo; k<=hi; k++){
            if (i>mid){
                a[k] = aux[j++];
            }else if(j>hi){
                a[k] = aux[i++];
            }else if (less(a[i],a[j])){
                a[k] = aux[i++];
            }else {
                a[k] = aux[j++];
            }
        }
    }
    private boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }
    private void exch(int i, int j, Comparable[] a){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void show(Comparable[] a){
        for (int i = 0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        String[] a = {"bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        Chapt2MergeDownUp sort = new Chapt2MergeDownUp();
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
