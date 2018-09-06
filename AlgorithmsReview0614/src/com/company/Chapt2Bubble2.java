package com.company;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt2Bubble2<Item extends Comparable<Item>> {
    public void sort(Item[] a){
        boolean swap = false;
        for (int k=0; k<a.length-1;k++) {
            for (int i = 0; i < a.length - 1 - k; i++) {
                if (less(a[i + 1], a[i])) {
                    exch(a, i, i + 1);
                    swap = true;
                }
            }
            if (swap == false){
                return;
            }
        }
    }
    public boolean less(Item i, Item j){
        return i.compareTo(j)<0;
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
        Chapt2Bubble2 sort = new Chapt2Bubble2();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
