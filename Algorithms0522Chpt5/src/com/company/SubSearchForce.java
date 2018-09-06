package com.company;

/**
 * Created by mileygao on 6/9/17.
 */
public class SubSearchForce {
    public int search(String s, String pat){
        int j;
        for (int i = 0; i<=s.length()-pat.length();i++){
            for (j = 0 ;j<pat.length();j++){
                if (s.charAt(i+j)!=pat.charAt(j)){
                    break;
                }
            }
            if (j == pat.length()) {
                return i;
            }
        }
        return s.length();
    }
    public static void main(String [] args){
        String pat = "des";
        String string = "abdes";
        SubSearchForce a = new SubSearchForce();
        System.out.println(a.search(string,pat));
    }
}
