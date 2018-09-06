package com.company;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt2Insert2<Item extends Comparable<Item>> {
    public void sort(Item[] a) {
        for (int i = 1; i < a.length; i++) {
            Item now = a[i];
            for (int j = i; j > 0; j--) {
                if (less(now, a[j - 1])) {
                    a[j] = a[j-1];
                } else {
                    a[j] = now;
                    break;
                }
                if (j == 1){
                    a[0] = now;
                }
            }
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
        Chapt2Insert2 sort = new Chapt2Insert2();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
