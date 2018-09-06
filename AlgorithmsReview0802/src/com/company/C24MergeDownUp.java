package com.company;

/**
 * Created by mileygao on 8/3/17.
 */
public class C24MergeDownUp<Item extends Comparable<Item>> {
    private Item[] copy;
    public void sort(Item[] a){
        copy = (Item[]) new Comparable[a.length];
        for (int sz = 1; sz<a.length;sz=sz*2){
            for (int i = 0; i<a.length;i = i+sz*2){
                merge(a,i,i+sz-1,Math.min(i+sz+sz-1,a.length-1));
            }
        }
    }
    private void merge(Item[] a, int lo, int mid,int hi){
        for (int i = lo; i<=hi; i++){
            copy[i] = a[i];
        }
        int lt = lo;
        int i = lo;
        int gt = mid+1;
        while (i<=hi){
            if (gt>hi){
                a[i++] = copy[lt++];
            } else if (lt>mid){
                a[i++] = copy[gt++];
            } else if (less(copy[lt],copy[gt])) {
                a[i++] = copy[lt++];
            }else {
                a[i++] = copy[gt++];
            }
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
            System.out.print(a[i]);
        }
        System.out.println();
    }
    public static void main(String[] args){
        C24MergeDownUp sort = new C24MergeDownUp();
        String[] a = {"","bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"","S", "O", "R" , "T", "E"};                                 // EORST
        String[] c = {"","a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        String[] d = {"a"};
        String[] e = {"d","a"};
        sort.sort(b);
        sort.show(b);
        sort.sort(e);
        sort.show(e);
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.show(a);

        sort.sort(d);
        sort.show(d);

    }
}
