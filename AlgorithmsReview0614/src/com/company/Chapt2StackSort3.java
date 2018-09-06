package com.company;

/**
 * Created by mileygao on 7/10/17.
 */
public class Chapt2StackSort3 <Item extends Comparable<Item>>{
    public void sort(Item[] a){
        int N = a.length-1;
        for (int i = N/2;i>0;i--){
            sink(a,i,N);
        }
        while (N>1) {
            exch(1, N--, a);
            sink(a, 1,N);
        }
    }
    private void sink(Item[] a,int k,int hi){
        while (k<=hi/2){
            int j = 2*k;
            if (j<hi&&less(a[j],a[j+1])){
                j = j+1;
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
        Chapt2StackSort3 sort = new Chapt2StackSort3();
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
