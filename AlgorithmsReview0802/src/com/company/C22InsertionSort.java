package com.company;

/**
 * Created by mileygao on 8/3/17.
 */
public class C22InsertionSort <Item extends Comparable<Item>>{
    public void sort(Item[] a){
        Item v ;
        for (int i = 1; i<a.length;i++){
            v = a[i];
            int j = i-1;
            for (; j>=0; j--){
                if (less(v,a[j])){
                    a[j+1] =a[j];
                }else {
                    break;
                }
            }
            a[j+1] = v;
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
        C22InsertionSort sort = new C22InsertionSort();
        String[] a = {"","bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"","S", "O", "R" , "T", "E"};                                 // EORST
        String[] c = {"","a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        String[] e = {"d","a"};
        sort.sort(e);
        sort.show(e);
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
