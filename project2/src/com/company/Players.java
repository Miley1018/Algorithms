package com.company;

/**
 * Created by mileygao on 4/5/17.
 */
public class Players {
    public boolean put(String p, int x, int y, String[][] a){
        if (!a[x][y].equals("-")){
             System.out.print("already taken, change to:");
             return false;
        }else{
            if (p == "p1") {
                a[x][y] = "o";
                return true;
            }else{
                a[x][y] = "x";
                return true;
            }

        }
    }


}
