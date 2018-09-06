package com.company;

/**
 * Created by mileygao on 8/2/17.
 */
public class C11Oujilide {
    public int ouji(int p, int q){
        if (q==0){
            return p;
        }else {
            int r = p%q;
            return ouji(q,r);
        }
    }
}
