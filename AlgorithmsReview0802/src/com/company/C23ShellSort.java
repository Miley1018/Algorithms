package com.company;

/**
 * Created by mileygao on 8/3/17.
 */
public class C23ShellSort<Item extends Comparable<Item>> {
    public void sort(Item[] a){
        int h  = 1;
        while (h<a.length/3){
            h = 3*h+1;
        }
        Item v ;
        while (h>0) {
            for (int i = h; i < a.length; i++) {
                v = a[i];
                int j = i-h;
                for (; j >= 0; j = j - h) {
                    if (less(v, a[j])) {
                        a[j + h] = a[j];
                    } else {
                       break;
                    }
                }
                a[j+h] = v;
            }
            h = h / 3;
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
        C23ShellSort sort = new C23ShellSort();
        String[] a = {"","bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"","S", "O", "R" , "T", "E"};                                 // EORST
        String[] c = {"","a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        String[] d = {"a"};
        String[] e = {"d","a"};
        sort.sort(e);
        sort.show(e);
        sort.sort(c);
        sort.show(c);
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
        sort.sort(d);
        sort.show(d);

    }
}
