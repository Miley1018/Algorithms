package com.company;

/**
 * Created by mileygao on 7/7/17.
 */
public class Chapt2Insert3 <Item extends Comparable<Item>>{
    public void sort(Item[] a){
        for (int i = 1; i<a.length;i++){
            for (int j = i; j>0;j--){
                if (less(j,j-1,a)){
                    exch(j,j-1,a);
                }
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
        Chapt2Insert3 sort = new Chapt2Insert3();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.show(a);
        sort.sort(b);
        sort.show(b);
    }
}
