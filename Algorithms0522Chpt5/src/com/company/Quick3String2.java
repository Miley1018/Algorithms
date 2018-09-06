package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by mileygao on 6/7/17.
 */
public class Quick3String2 {
    public static int charAt(String s, int index){
        if (index<s.length()){
            return s.charAt(index);
        }
        return -1;
    }
    public static void sort(String[] s){

        sort(s,0,s.length-1,0);
    }
    public static void sort(String[] s, int lo, int hi, int d){
        if (lo>hi){
            return;
        }
        int v = charAt(s[lo],d);
        int lt = lo;
        int gt = hi;
        int i = lo+1;
        while (i<gt){
            int now = charAt(s[i],d);
            if (now<v){
                exch(s,i++,lt++);
            }else if (now>v){
                exch(s,gt--,i);
            }else {
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
    public static void main(String[] args) {
        String[] s = {"abdse", "dbds", "abdae", "abdes", "da", "cb", "ca"};
        List<String> t = Arrays.asList(s);
        Collections.shuffle(t);
        String[] ss = (String[]) t.toArray();
        for (String a : ss) {
            System.out.println(a);
        }
        sort(ss);

        for (String a : ss) {
            System.out.println(a);
        }
    }
}
