package com.company;

/**
 * Created by mileygao on 3/3/17.
 */
public class Cellphone extends Telephone{
    @Override
    public void call() {
        System.out.print("dianhua");
    }

    @Override
    public void send() {
        System.out.print("duanxin");
    }
}
