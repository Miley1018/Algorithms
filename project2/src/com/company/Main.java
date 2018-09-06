package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Telephone phone1 = new Cellphone();
        phone1.call();
        phone1.send();

        Telephone phone2 = new Smartphone();
        phone2.send();
        phone2.call();

        IplayGame ip1 = new Smartphone();
        IplayGame ip2 = new Psp();
        ip1.playGame();
        ip2.playGame();

        IplayGame ip3 = new IplayGame() {
            @Override
            public void playGame() {
                System.out.print("是用匿名内部类实现接口1");
            }
        };
        ip3.playGame();

        new IplayGame(){
            @Override
            public void playGame() {
                System.out.print("niming 2");
            }
        }.playGame();
    }
}
