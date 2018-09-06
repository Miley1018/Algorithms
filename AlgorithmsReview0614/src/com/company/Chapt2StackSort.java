package com.company;

/**
 * Created by mileygao on 6/16/17.
 */
public class Chapt2StackSort<Key extends Comparable> {
    private void sink(int n,Key[] a, int N){
        while(n<=N/2){
            int j = 2*n;
            if (n*2<N &&less(2*n,2*n+1,a)){
                j = 2*n+1;
            }
            if (!less(n,j,a)){
                break;
            }
            exch(n,j,a);
            n = j;
        }
    }
    private void exch(int i, int j,Key[] a){
        Key t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private boolean less(int i, int j,Key[] a){
        return a[i].compareTo(a[j])<0;
    }
    public void sort(Key[] a){
        int N = a.length-1;
        for (int k = N/2;k>0;k--){
            sink(k,a,N+1);
        }
        while(N>1) {
            exch(1, N--, a);
            sink(1, a, N);
        }
    }
    public void show(Key[] a){
        for (int i = 0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        String[] a = {"","bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"","S", "O", "R" , "T", "E"};                                 // EORST
        Chapt2StackSort sort = new Chapt2StackSort();
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
