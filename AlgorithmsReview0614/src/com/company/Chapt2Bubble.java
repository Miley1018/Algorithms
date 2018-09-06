package com.company;

/**
 * Created by mileygao on 6/16/17.
 */
public class Chapt2Bubble<Item extends Comparable> {
    public void sort(Item[] a){
        boolean didSwap = false;
        int k = 0;
        while (k<a.length) {
            for (int i = 0; i < a.length-1-k; i++) {
                if (less(a[i + 1], a[i])) {
                    exch(i + 1, i, a);
                    didSwap = true;
                }
            }
            if(didSwap == false){
               break;
            }
            k ++;
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
        Chapt2Bubble sort = new Chapt2Bubble();
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
