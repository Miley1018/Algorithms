package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
	// write your code here
        System.out.println("Create Poker");
        System.out.println("Poker created:");
    Poker[] poker = {new Poker("Black"),new Poker("Red"),new Poker("Mei"),new Poker("Diamond")};
    List<String> pokerAll = new ArrayList<String>();                              //in class or function?
    for (int i = 0; i<4;i++){
        pokerAll.addAll(poker[i].pokerGenerator());
    }
    for(String a:pokerAll){
    System.out.print(a+",");}
    System.out.println();

        System.out.println("Start shuffling");
        Game game = new Game();
        game.shufflePoker(pokerAll);
        System.out.println("Shuffling done:");
        for(String a:pokerAll){
            System.out.print(a+",");}

        System.out.println("Create players:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls enter no1 player id:");
        int id1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Pls enter no1 player name:");
        String name1 = sc.nextLine();
        System.out.println("Pls enter no2 player id:");
        int id2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Pls enter no2 player name:");
        String name2 = sc.nextLine();
        System.out.println("Welcome player:"+name1);
        System.out.println("Welcome player:"+name2);

        System.out.println("Start dealing");
        game.dealing(pokerAll);
        System.out.println("Player "+name1+"gets a card");
        System.out.println("Player "+name2+"gets a card");
        System.out.println("Player "+name1+"gets a card");
        System.out.println("Player "+name2+"gets a card");
        System.out.println("Done with dealing");

        System.out.println("Start playing");

    }
}
