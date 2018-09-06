package com.company;

/**
 * Created by mileygao on 6/19/17.
 */
public class Chapt2HIllSort2<Item extends Comparable<Item>> {
    public void sort(Item[] a){
        int h = 1;
        while (h<a.length){
            h = 3*h+1;
        }
        while (h>0) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >=h ; j = j - h) {
                    if (less(a[j], a[j - h])) {
                        exch(j, j - h, a);
                    }
                }
            }
            h = h/3;
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
        String[] a = {"bed", "yes",  "dad","yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        Chapt2HIllSort2 sort = new Chapt2HIllSort2();
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
