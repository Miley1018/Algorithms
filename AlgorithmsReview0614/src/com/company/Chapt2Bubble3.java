package com.company;

/**
 * Created by mileygao on 7/7/17.
 */
public class Chapt2Bubble3 <Item extends Comparable<Item>>{
    private boolean swap = false;
    public void sort(Item[] a){
        for (int j = 0; j<a.length;j++) {
            for (int i = 0; i < a.length - 1 - j; i++) {
                if (less(i + 1, i, a)) {
                    swap = true;
                    exch(i, i + 1, a);
                }
            }
            if (swap == false){
                break;
            }
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
        Chapt2Bubble3 sort = new Chapt2Bubble3();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.show(a);
        sort.sort(b);
        sort.show(b);
    }
}
