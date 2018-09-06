package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 4/18/17.
 */
public class Poker {
    int num;
    int color;
    //List<Poker> pokerAll = new ArrayList<>();

    private Poker(int color, int num){
        this.num = num;
        this.color = color;
    }
    private static String[] numStr = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private static String[] colorStr = {"Spades","Hearts","Clubs","Diamonds"};

    public static List<Poker> pokerAll(){
        ArrayList<Poker> pokerAll = new ArrayList<>();
        for (int i = 0; i < colorStr.length; i++){
            for (int j = 0; j < numStr.length; j++){
                Poker poker = new Poker(i,j);
                pokerAll.add(poker);
            }
        }
        return pokerAll;
    }

    @Override
    public String toString() {
        return colorStr[color]+numStr[num];
    }
}
