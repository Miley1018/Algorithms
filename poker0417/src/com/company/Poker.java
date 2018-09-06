package com.company;

/**
 * Created by mileygao on 4/17/17.
 */
public class Poker {
    private int num;
    private String color;
    public Poker(int num, String color){
        this.num = num;
        this.color = color;
    }

    public int getNum(){
        return num;
    }

    public String getColor(){
        return color;
    }

    @Override
    public String toString() {
        return color+num;
    }
}
