package com.company;

/**
 * Created by mileygao on 6/7/17.
 */
public class LSD2 {
    public static void sort(String[] s, int w){
        int R = 256;
        int[] count;
        w = w-1;
        String[] aux = new String[s.length];
        while (w>=0) {
            count = new int[R+1];
            for (int i = 0; i < s.length; i++) {
                count[s[i].charAt(w)+1]++;
            }
            for (int i =0; i <R; i++){
                count[i+1] += count[i];
            }
            for (int i = 0; i<s.length;i++){
                aux[count[s[i].charAt(w)]++] = s[i];
            }
            for (int i = 0; i<s.length;i++){
                s[i] = aux[i];
            }
            w--;
        }
    }
    public static void main(String [] args) {
        String[] s = {"ab", "db", "ac", "da", "cb", "ca"};

        sort(s, 2);
        for (String a : s) {
            System.out.println(a);
        }
    }
}
