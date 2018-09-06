package com.company;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt2MergeDownUp3<Item extends Comparable<Item>> {
    public void sort(Item[] a){
        Item[] aux = (Item[])new Comparable[a.length];
        for (int sz = 1; sz<a.length;sz = sz+sz){
            for (int t = 0; t<a.length; t++){
                aux[t] = a[t];
            }
            for (int i = 0; i<a.length-sz;i=i+sz+sz){
                int mid = i+sz;
                int lo = i;
                for(int j = i; j<(i+sz+sz>a.length?a.length:i+sz+sz); j++) {
                    if (lo >= i + sz) {
                            a[j] = aux[mid++];
                    } else if (mid >=(i+sz+sz>a.length?a.length:i+sz+sz)) {
                            a[j] = aux[lo++];
                    } else if (less(aux[lo], aux[mid])) {
                        a[j] = aux[lo++];
                    } else {
                        a[j] = aux[mid++];
                    }
                }
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
        Chapt2MergeDownUp3 sort = new Chapt2MergeDownUp3();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        //sort.sort(a);
        sort.sort(b);
        //sort.show(a);
        sort.show(b);
    }
}
