package com.company;

/**
 * Created by mileygao on 7/7/17.
 */
public class Chapt2HillSort4 <Item extends Comparable<Item>>{
    public void sort(Item[] a){
        int n = a.length;
        int h =1 ;
        while (h<n){
            h = 3*h+1;
        }
        while (h>0) {
            for (int i = h; i < n; i++) {
                for (int j = i;j-h>=0;j=j-h) {
                    if (less(j, j-h, a)) {
                        exch(j, j-h, a);
                    }
                }
            }
            h = h/3;
        }
    }
    public boolean less(int i, int j,Item[] a){
        return a[i].compareTo(a[j])<0;
    }
    public void exch(int i, int j, Item[] a){
        Item t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public void show(Item[] a){
        for (int i = 0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        String[] a = {"bed",  "yet", "dad", "yes","zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        Chapt2HillSort4 sort = new Chapt2HillSort4();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.show(a);
        sort.sort(b);
        sort.show(b);
    }
}
