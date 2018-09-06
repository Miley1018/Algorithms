package com.company;

/**
 * Created by mileygao on 3/3/17.
 */
public class Smartphone extends Telephone implements IplayGame{
    @Override
    public void send() {
        System.out.print("smart send");
    }

    @Override
    public void call() {
        System.out.print("smart call");
    }

    @Override
    public void playGame() {
        System.out.print("smart play game");
    }
}
