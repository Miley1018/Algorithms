package com.company;

/**
 * Created by mileygao on 6/16/17.
 */
public class Chapt2HillSort<Item extends Comparable> {
    public void sort(Item[] a){
        int h=1;
        while (h<a.length){
            h = h*3+1;
        }
        while (h>0) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >=h ; j = j - h) {
                    if (less(a[j], a[j - h])) {
                        exch(j, j - h, a);
                    }
                }
            }
            h = h / 3;
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
    public static class Solution1 {
        public int[] solve(int[] array) {
            // Write your solution here
            if (array == null || array.length == 0) {
                return array;
            }
            for (int i = 0; i < array.length; i ++) {
                int min = i;
                for (int j = i; j < array.length; j ++) {
                    if (array[j] < min) {
                        min = j;
                    }
                }
                swap(i, min, array);
            }
            return array;
        }
        private void swap(int i, int j, int[] array) {
            int one = array[i];
            array[i] = array[j];
            array[j] = one;
        }
    }


    public static void main(String[] args){
        String[] a = {"bed", "dad", "yes", "yet", "zoo" };    //bed, dad, yes, yet, zoo
        String[] b = {"S", "O", "R" , "T", "E"};                                 // EORST
        Chapt2HillSort sort = new Chapt2HillSort();
        sort.sort(a);
        sort.sort(b);
        sort.show(a);
        sort.show(b);
    }
}
