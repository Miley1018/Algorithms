package com.company;

/**
 * Created by mileygao on 8/4/17.
 */
public class C27HeapSort <Item extends Comparable<Item>>{
    private int N;
    public void sort(Item[] a){
        N = a.length-1;
        for (int i = a.length/2;i>0;i--){
            sink(i,a);
        }
       // System.out.println("ss");
        while (N>1){
            exch(1,N--,a);
            sink(1,a);
        }
    }

    private void sink(int k, Item[] pq){
        while (2*k<=N){
            int j = 2*k;
            if (j<N&&less(pq[j+1],pq[j])){
                j = j+1;
            }
            if (!less(pq[j],pq[k])){
                break;
            }
            exch(j,k,pq);
            k=j;
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
        C27HeapSort sort = new C27HeapSort();
        String[] a = {"","bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = { "","O", "R" , "T", "E"};                                 // EORST
        String[] c = {"","a","d","y","f","g","b","c","u","i","o","j","e","h","k","n","k","m","w"};
        String[] d = {"","a"};
        String[] e = {"","d","a","a","d","d","b","c","c"};
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
