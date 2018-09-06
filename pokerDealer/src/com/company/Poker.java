package com.company;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by mileygao on 3/8/17.
 */
public class Poker {
    private String color;

    private int num;

    public Poker(String color,int num){
        this.num = num;                    //can be outside?
        this.color=color;
    }

    @Override
    public String toString() {
        return color+num;
    }

    public static List<Poker> pokerGenerator() {
        List<Poker> pokers = new ArrayList();
        String [] colors = {"Black","Red","Mei","Diamond"};
        for(String color : colors) {
            for (int i = 1; i <= 13; i++) {
                pokers.add(new Poker(color, i));
            }
        }
        return pokers;
    }

}
