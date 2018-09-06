package com.company;

/**
 * Created by mileygao on 8/3/17.
 */
public class C21SelectionSort<Item extends Comparable> {
    public void sort(Item[] a){
        for (int i = 0; i<a.length;i++){
            int t = i;
            for (int j = i+1; j<a.length;j++){
                if (less(a[j],a[t])){
                    t = j;
                }
            }
            exch(i,t,a);
        }
    }
    public boolean less(Item a, Item b){
        return a.compareTo(b)<0;
    }
    public void exch(int i, int j, Item[] a){
        Item t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public void show(Item[] a){
        for (int i = 0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args){
        C21SelectionSort sort = new C21SelectionSort();
        String[] a = {"","bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"","S", "O", "R" , "T", "E"};                                 // EORST
        String[] c = {"","a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
