package com.company;

/**
 * Created by mileygao on 3/10/17.
 */
public class Player {
    private int id;
    private String name;

    Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    String getName(){
        return name;
    }

}
