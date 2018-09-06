package com.company;

/**
 * Created by mileygao on 6/7/17.
 */
public class MSD2 {
    static int R = 256;
    static String[] aux;
    static int[] count;
    public static void sort(String[] s){
        aux = new String[s.length];
        sort(s,0,s.length-1,0);
    }
    public static void sort(String[] s, int lo, int hi,int d){
        if (lo>hi){
            return;
        }
        if (lo+15>=hi){
            insertion(s,lo,hi,d);
            return;
        }
        count = new int[R+2];
        for (int i = lo; i<=hi;i++){
            count[charAt(s[i],d)+2]++;
        }
        for (int i = 0; i<R+1; i++){
            count[i+1]+=count[i];
        }
        for (int i = lo; i<=hi;i++){
            aux[count[charAt(s[i],d)+1]++] = s[i];
        }
        for (int i = lo; i <=hi; i++){
            s[i] = aux[i-lo];
        }
        for (int i = 0; i<R;i++){
            sort(s,count[i]+lo,lo+count[i+1]-1,d+1);
        }
    }
    public static int charAt(String s, int index){
        if (index<s.length()){
            return s.charAt(index);
        }
        return -1;
    }
    public static void insertion(String[] s, int lo, int hi, int d){
        for (int i = lo; i<=hi; i++){
            for (int j = i; j>lo;j--){
                if (less(s[j],s[j-1],d)){
                    exch(s,j,j-1);
                }
            }
        }
    }
    public static boolean less(String a, String b,int d){
        return a.substring(d).compareTo(b.substring(d))<0;
    }
    public static void exch(String[] s, int i ,int j){
        String t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
    public static void main(String[] args){
        String[] s = {"abdse","dbds","abdae","abdes","da","cb","ca"};
        sort(s);
        for (String a:s) {
            System.out.println(a);
        }
    }
}
