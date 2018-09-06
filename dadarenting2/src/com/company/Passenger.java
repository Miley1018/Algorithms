package com.company;

/**
 * Created by mileygao on 4/13/17.
 */
public class Passenger implements Cars{
    String name;
    int price;
    int persons;

    public Passenger(String name, int price, int persons){
        this.name = name;
        this.price = price;
        this.persons = persons;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getPersons() {
        return persons;
    }

    @Override
    public int getCargos() {
        return 0;
    }

    @Override
    public int check() {
        return 2;
    }
}
