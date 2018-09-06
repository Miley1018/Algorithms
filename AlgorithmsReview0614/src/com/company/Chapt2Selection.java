package com.company;

/**
 * Created by mileygao on 6/16/17.
 */
public class Chapt2Selection<Item extends Comparable<Item>> {
    public void sort(Item[] a){
        int min;
        for (int j = 0; j<a.length;j++) {
            min = j;
            for (int i = j+1; i < a.length; i++) {
                if (less(a[i], a[min])) {
                    min = i;
                }
            }
            exch(j,min,a);
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
        Chapt2Selection sort = new Chapt2Selection();
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
