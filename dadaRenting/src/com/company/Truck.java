package com.company;

/**
 * Created by mileygao on 3/3/17.
 */
public class Truck implements Cars{
    private String type;
    private int price;
    private  int volumn;
    public String getName(){
        return type;
    }
    public int getPrice(){
        return price;
    }
    public int getVolumn(){
        return volumn;
    }


    public Truck(String type, int price, int volumn) {
            this.type=type;
            this.price=price;
            this.volumn=volumn;
    }
    public String get(){
        return (type+"\t"+price+"元／每天\t"+"载货"+volumn);
    }
    public int check(){
        return 1;
    }

    @Override
    public int getPersons() {
        return 0;
    }
}
