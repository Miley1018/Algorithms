package com.company;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt2HillSort3<Item extends Comparable<Item>> {
    public void sort(Item[] a){
        int h = 0;
        while (h<a.length){
            h = 3*h+1;
        }
        while (h>0) {
            for (int i = h; i < a.length; i ++) {
                for (int j = i; j >= h; j = j - h) {
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                    }
                }
            }
            h = h / 3;
        }
    }
    public boolean less(Item a, Item b){
        return a.compareTo(b)<0;
    }
    public void exch(Item[] a, int i, int j){
        Item tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public void show(Item[] a){
        for (Item i:a){
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        String[] a = {"bed",  "yet", "dad", "yes","zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        Chapt2HillSort3 sort = new Chapt2HillSort3();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
