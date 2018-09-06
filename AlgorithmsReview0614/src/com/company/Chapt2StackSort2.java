package com.company;

/**
 * Created by mileygao on 6/27/17.
 */
public class Chapt2StackSort2 <Item extends Comparable<Item>>{
    public void sort(Item[] a){
        for (int i = (a.length-1)/2;i>0;i--){
            sink(i,a,a.length-1);
        }
        int N = a.length-1;
        while (N>0){
            exch(1,N--,a);
            sink(1,a,N);
        }
    }
    private void sink(int k,Item[] a, int N){
        while (k<=(N)/2){
            int j = 2*k;
            if (j<N&&less(a[j],a[j+1])) {
                j = j + 1;
            }
            if (!less(a[k],a[j])){
                break;
            }
            exch(k,j,a);
            k = j;
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
        Chapt2StackSort2 sort = new Chapt2StackSort2();
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
