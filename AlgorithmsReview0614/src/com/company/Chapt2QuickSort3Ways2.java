package com.company;

/**
 * Created by mileygao on 6/26/17.
 */
public class Chapt2QuickSort3Ways2<Item extends Comparable<Item>> {//wrong!!!
    public void sort(Item[] a){
        sort(a,0,a.length-1);
    }
    private void sort(Item[] a , int lo, int hi){
        if (lo>=hi){
            return;
        }
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private int partition(Item[] a, int lo, int hi){
        int v = lo;
        int lt = lo+1;
        int gt = hi;
        int cc = lo+1;
        while (lt<=gt){//<?--------------------------------------------
            if (less(a[lt],a[v])){
                exch(lt++,cc++,a);
            }else if (less(a[v],a[lt])){
                exch(lt,gt--,a);
            }else {
                lt++;
            }
        }
        exch(v,gt,a);
        return gt;
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
        Chapt2QuickSort3Ways2 sort = new Chapt2QuickSort3Ways2();
        String[] a = {"bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        String[] c = {"a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
