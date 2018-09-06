package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by mileygao on 3/10/17.
 */
public class Poker {
    private String color;
    private int num;

    Poker(String color, int num){
        this.color = color;
        this.num = num;
    }

    public String toString(){
        return color+num;
    }

    int getNum(){
        return num;
    }

    String getColor(){
        return color;
    }

    private static String[] colors = {"Black","Red","Mei","Diamond"};

    static List<Poker> generator(){
        List<Poker> pokers = new ArrayList();
        for (String a:colors){
            for (int i = 1; i<=13;i++){
                pokers.add(new Poker(a,i));
        }}
        return pokers;
    }



}




