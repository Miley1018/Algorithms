package com.company;

/**
 * Created by mileygao on 3/3/17.
 */
public class Passengers implements Cars{
    private String type;
    private int price;
    private  int persons;
    public String getName(){
        return type;
    }
    public int getPrice(){
        return price;
    }
    public int getPersons(){
        return persons;
    }
    public  Passengers (String type, int price, int persons) {
        this.type=type;
        this.price=price;
        this.persons=persons;
    }
    public String get(){
        return (type+"\t"+price+"元／每天\t"+"载人"+persons);
    }
    public int check(){
        return 2;
    }

    @Override
    public int getVolumn() {
        return 0;
    }
}
