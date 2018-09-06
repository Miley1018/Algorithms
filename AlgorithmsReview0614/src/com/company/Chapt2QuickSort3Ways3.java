package com.company;

/**
 * Created by mileygao on 7/10/17.
 */
public class Chapt2QuickSort3Ways3<Item extends Comparable<Item>> {
    public void sort(Item[] a){
        sort(a,0,a.length-1);
    }
    private void sort(Item[] a, int lo, int hi){
        if (lo>=hi){
            return;
        }
        int lt = lo;
        Item v = a[lo];
        int i = lo;
        int j = hi+1;
        while (++lt<=j-1){
                if (less(a[lt],v)){
                    exch(++i,lt,a);
                }else if (less(v,a[lt])){
                    exch(lt--,--j,a);
                }else {
                }
        }
        exch(lo,i,a);
        sort(a,lo,i-1);
        sort(a,j,hi);
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
        Chapt2QuickSort3Ways3 sort = new Chapt2QuickSort3Ways3();
        String[] a = {"bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(b);
        sort.show(b);
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.show(a);
    }
}
