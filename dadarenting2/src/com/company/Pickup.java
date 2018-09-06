package com.company;

/**
 * Created by mileygao on 4/13/17.
 */
public class Pickup implements Cars{
    String name;
    int price;
    int cargos;
    int persons;

    public Pickup(String name, int price, int persons, int cargos){
        this.name = name;
        this.price = price;
        this.cargos = cargos;
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
        return cargos;
    }

    @Override
    public int check() {
        return 1;
    }
}
