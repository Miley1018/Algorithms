package com.company;

/**
 * Created by mileygao on 6/6/17.
 */
public class Quick3String {
    public static int charAt(String s, int d){
        if (d<s.length()){
            return s.charAt(d);
        }
        return -1;
    }
    public static void sort(String[] s){
        sort(s,0,s.length-1,0);
    }
    public static void sort(String[] s,int lo, int hi,int d){
        int lt = lo;
        int gt = hi;
        int v = s[lo].charAt(d);
        int i = lo+1;
        while (i<=gt){
            if (s[i].charAt(d)>v){
                exch(s,gt--,i);
            }else if(s[i].charAt(d)<v){
                exch(s,lt++,i++);
            }else{
                i++;
            }
        }
        sort(s,lo,lt-1,d);
        if (v>=0){
            sort(s,lt,gt,d+1);
        }
        sort(s,gt+1,hi,d);
    }
    public static void exch(String[] s, int i, int j){
        String t = s[i];
        s[i] = s[j];
        s[j] = t;
    }

}
