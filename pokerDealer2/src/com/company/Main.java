package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        testCompare();

        System.out.println("Create pokers");
        System.out.println("Pokers created");
        List<Poker> a = Poker.generator();
        System.out.println(a);

        System.out.println("Start shuffling");
        Collections.shuffle(a);
        System.out.println("Done shuffling");
        System.out.println(a);

        System.out.println("Create players");
        Scanner sc = new Scanner(System.in);
        System.out.println("First id:");
        int id1;
        while (true) {
            try {                                                                    //how to catch every time?
                id1 = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("ID must be int, pls type again:");
            }
        }
        System.out.println("First name:");
        String name1 = sc.nextLine();
        int id2;
        boolean first = true;

        do{
            if(first) {
                System.out.println("Second id:");
            } else{
                System.out.println("It's taken, change it:");
            }
            first = false;
            while (true){
                try {
                    id2 = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException w) {
                    sc.nextLine();
                    System.out.println("ID must be int, pls type again:");
                }
            }
        }while (id2 == id1);
        System.out.println("Second name:");
        String name2 = sc.nextLine();
        Player p1 = new Player(id1,name1);
        Player p2 = new Player(id2,name2);
        System.out.println("Welcome player:" + p1.getName());
        System.out.println("Welcome player:" + p2.getName());

        System.out.println("Start dealing");
        System.out.println("Player "+name1+" gets a card");
        System.out.println("Player "+name2+" gets a card");
        System.out.println("Player "+name1+" gets a card");
        System.out.println("Player "+name2+" gets a card");
        Game gg= new Game(a);
        List<Poker> p1p;
        List<Poker> p2p;
        try{
            p1p = gg.pp();
            p2p = gg.pp();
        System.out.println("Done dealing. 1:"+p1p+" 2:"+p2p);

        System.out.println("Start gaming");
        Game.compareCards cc = new Game.compareCards();
        int result1 = cc.compare(p1p.get(0),p1p.get(1));
        Poker p1big;
        Poker p2big;
        if (result1>0){
            p1big=p1p.get(0);
            System.out.println(name1+"biggest card is: "+p1p.get(0));
        }else{
            p1big=p1p.get(1);
            System.out.println(name1+"biggest card is: "+p1p.get(1));
        }

        int result2 = cc.compare(p2p.get(0),p2p.get(1));
        if (result2>0){
            p2big=p2p.get(0);
            System.out.println(name2+"biggest card is: "+p2p.get(0));
        }else{
            p2big=p2p.get(1);
            System.out.println(name2+"biggest card is: "+p2p.get(1));
        }

        int result12 =cc.compare(p1big, p2big);
        if (result12>0){
            System.out.println(name1+" win");
        }else{
            System.out.println(name2+" win");
        }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    static void testCompare(){
        Poker p1 = new Poker("Red", 2);
        Poker p2 = new Poker("Black", 2);
        Game.compareCards compare = new Game.compareCards();
        System.out.println(compare.compare(p1,p2));
    }
}
