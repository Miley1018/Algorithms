package com.company;

import java.util.*;

/**
 * Created by mileygao on 3/10/17.
 */
public class Game {
    List<Poker> poker;
    Game(List<Poker> poker){
        this.poker = poker;
    }
    int i=0;
    List<Poker> pp () throws Exception{
        List<Poker> pp = new ArrayList<>();
        if (i>53){
            throw new Exception();
        }else{
            pp.add(poker.get(i));
            pp.add(poker.get(i+1));
            i+=2;
        }
        return pp;
    }

    static class compareCards implements Comparator<Poker>{
        @Override
        public int compare(Poker o1, Poker o2) {
            if (o1.getNum() > o2.getNum()){
                return 1;
            }else if (o1.getNum() < o2.getNum()){
                return -1;
            }else{
                colorMap();
                if (colorMap.get(o1.getColor())>colorMap.get(o2.getColor())){
                    return 1;
                }else{
                    return -1;
                }
            }
        }

        private String[] colors = {"Black","Red","Mei","Diamond"};
        Map<String,Integer> colorMap = new HashMap<String,Integer>();
        void colorMap(){
            for (int i =3; i>=0;i--){
                colorMap.put(colors[3-i],i);
            }
        }
        }





}

