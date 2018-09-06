package com.company;

/**
 * Created by mileygao on 4/13/17.
 */
public class Truck implements Cars {
    String name;
    int price;
    int cargos;

    public Truck(String name, int price, int cargos){
        this.name = name;
        this.price = price;
        this.cargos = cargos;
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
        return 0;
    }

    @Override
    public int getCargos() {
        return cargos;
    }

    @Override
    public int check() {
        return 0;
    }
}
