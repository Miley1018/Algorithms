package com.company;

import java.util.Objects;

/**
 * Created by mileygao on 3/3/17.
 */
public class Pickup implements Cars{
    private String type;
    private int price;
    private  int volumn;
    private int persons;
    public String getName(){
        return type;
    }
    public int getPrice(){
        return price;
    }
    public int getVolumn(){
        return volumn;
    }
    public int getPersons(){
        return persons;
    }

    public Pickup(String type, int price, int volumn, int persons) {
            this.type=type;
            this.price=price;
            this.volumn=volumn;
            this.persons=persons;
    }
    public  String get(){
        return (type+"\t"+price+"元／每天\t"+"载货"+volumn+"\t"+"载人"+persons);
    }
    public int check(){
        return 0;
    }
}
