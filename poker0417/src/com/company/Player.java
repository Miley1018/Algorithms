package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 4/17/17.
 */
public class Player {
    int id;
    String name;
    List<Poker> ownPokers;
    public Player(int id, String name){
        this.id = id;
        this.name = name;
        ownPokers = new ArrayList<Poker>();
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Poker> getOwnPokers(){
       return ownPokers;
    }
}
