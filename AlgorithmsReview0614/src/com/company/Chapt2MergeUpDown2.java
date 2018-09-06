package com.company;

/**
 * Created by mileygao on 6/19/17.
 */
public class Chapt2MergeUpDown2<Item extends Comparable<Item>> {
    Item[] aux ;
    public void sort(Item[] a){
        aux =  (Item[]) new Comparable[a.length];//------------object?
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
    private void merge(Item[] a, int lo, int mid, int hi){
        if (less(a[mid],a[mid+1])){
            return;
        }
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++){
            aux[k] = a[k];
        }
        for (int k = lo; k<=hi; k++) {
            if (i>=mid+1){
                a[k] = aux[j++];
            }else if(j>=hi+1){
                a[k] = aux[i++];
            } else if(less(aux[i], aux[j])) {
                a[k] = aux[i++];
            }else {
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
        Chapt2MergeUpDown2<String> sort = new Chapt2MergeUpDown2();
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
