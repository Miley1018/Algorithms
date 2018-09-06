package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Poker a = new Poker();
        for (Object i: a.poker){
            System.out.println();
        }

        String[] colors = {"hearts","spades","diamonds","clubs"};
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        public Poker(){
            poker = new ArrayList<Poker>();
            for (String s:colors){
                for (int i : nums){
                    poker.add(s+i);
                }
            }
        }
    }
}
