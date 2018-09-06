package com.company;

/**
 * Created by mileygao on 6/6/17.
 */
public class LSD {
    public static void sort(String[] a, int w){
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = w-1; d>=0; d--){
            int[] count = new int[R+1];
            for (int i =0; i<a.length;i++){
                count[a[i].charAt(d)+1]++;
            }
            for (int i = 0; i<R;i++){
                count[i+1]+=count[i];
            }
            for (int i = 0; i<a.length;i++){
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i<a.length;i++){
                a[i] = aux[i];
            }
        }

    }
    public static void main(String[] args){
        String[] s = {"ab","db","ac","da","cb","ca"};

        sort(s,2);
        for (String a:s) {
            System.out.println(a);
        }
    }
}
