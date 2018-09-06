package com.company;

/**
 * Created by mileygao on 6/16/17.
 */
public class Chapt2Insert<Item extends Comparable> {
    public void sort(Item[] a){
        for (int i = 0; i<a.length;i++){
            Item now = a[i];
            int j = i;
            while (j>0&&less(now,a[j-1])){
                a[j] = a[j-1];
                j--;
            }
            a[j] = now;
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
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        Chapt2Insert sort = new Chapt2Insert();
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
