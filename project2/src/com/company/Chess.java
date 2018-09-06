package com.company;

import java.util.ArrayList;

/**
 * Created by mileygao on 4/5/17.
 */
public class Chess {
    String[][] a;
    public Chess(String[][] a){
            this.a = a;
    }

    public void display(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(a[i][j]);
            }
            System.out.println("");
        }
    }
}
