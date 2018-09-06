package com.company;

import java.util.Arrays;

/**
 * Created by mileygao on 6/9/17.
 */
public class SubSearchBM {
    private int R = 256;
    private int[] right;
    public SubSearchBM(String pat){
        right = new int[R];
        for (int i = 0; i<R;i++){
            right[i] = -1;
        }
        for (int i = 0; i<pat.length();i++){
            right[pat.charAt(i)] = i;
        }
    }
    public int search(String s, String pat){
        int N = s.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i<=N-M;i = i+skip){
            skip =0;
            for (int j = M-1; j>=0; j--){
                if (s.charAt(i+j)!=pat.charAt(j)){
                    skip = j- right[s.charAt(i+j)];
                    if (skip<1){
                        skip = 1;
                    }
                    break;
                }
            }
            if (skip == 0){
                return i;
            }
        }
        return N;
    }
    public static void main(String [] args){
        String pat = "des";
        String string = "abdes";
        SubSearchBM a = new SubSearchBM(pat);
        Integer [] ss = {1,2};
        System.out.println(Arrays.toString(ss));
        System.out.println(a.search(string,pat));
    }
}
