package com.company;

/**
 * Created by mileygao on 6/6/17.
 */
public class MSD {
    static int R = 256;
    static String [] aux;
    public static int charAt(String s, int d){
        if (d<s.length()){
            return s.charAt(d);
        }else{
            return -1;
        }
    }
    public static void sort(String[] s){
        aux= new String[s.length];
        sort(s,0,s.length-1,0);
    }
    public static void sort(String[] s, int lo, int hi, int d){
        if (lo>hi){
            return;
        }
        if(hi<=lo+15){
            insert(s,lo,hi,d);
            return;
        }
        int[] count = new int[R+2];
        for (int i = lo; i<=hi; i++){
            count[charAt(s[i],d)+2]++;
        }
        for (int i = 0; i <R+1;i++){
            count[i+1]+=count[i];
        }
        for (int i = lo; i<=hi; i++){
            aux[count[charAt(s[i],d)+1]++] =s[i];
        }
        for (int i = lo; i<=hi; i++){
            s[i] = aux[i-lo];
        }
        for(int i = 0; i<R;i++){
            sort(s,lo+count[i],lo+count[i+1]-1,d+1);
        }
    }
    public static void insert(String[] s, int lo, int hi, int d){
        for (int i=lo; i <=hi;i++){
            for (int j = i; j>lo;j--){
                if (less(s[j],s[j-1],d)){
                    exch(s,j,j-1);
                }
            }
        }
    }
    public static void exch(String[] s, int i, int j){
        String t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
    public static boolean less(String v, String w, int d){
        return v.substring(d).compareTo(w.substring(d))<0;
    }
    public static void main(String[] args){
        String[] s = {"abdse","dbds","abdae","abdes","da","cb","ca"};
        sort(s);
        for (String a:s) {
            System.out.println(a);
        }
    }
}
