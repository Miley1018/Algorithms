package com.company;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt2Selection2 <Item extends Comparable<Item>>{
    public void sort(Item[] a){
        for (int i = 0; i<a.length;i++){
            int min = i;
            for (int j = i+1; j<a.length;j++){
                if (less(a[j],a[min])){
                    min = j;
                }
            }
            exch(i,min,a);
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
        Chapt2Selection2 sort = new Chapt2Selection2();
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
