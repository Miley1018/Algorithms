package com.company;

import java.util.*;

public class Main {
    List<Poker> pokers = new ArrayList<Poker>();
    Scanner sc = new Scanner(System.in);
    Player[] players = new Player[2];
    String[] colors = {"spades","hearts","clubs","diamonds"};
    Map<String,Integer> colorMap = new HashMap<String,Integer>();
    int id;
    String name;
    List<Poker> bigget = new ArrayList<Poker>();
    public void setColorMap(){
        for (int i = 0; i<4;i++){
            colorMap.put(colors[i],i);
        }
    }
    public void create(){
        for (int i = 1; i <= 13; i++){
            for (String color: colors){
                Poker poker = new Poker(i,color);
                pokers.add(poker);
            }
        }
        System.out.print("[");
        int cnt = 1;
        for (Poker j: pokers){
            if (cnt<=51){
                System.out.print(j+",");
                cnt++;
            }else{
                System.out.print(j);
            }
        }
        System.out.println("]");
    }

    public void shuffle(){
        Collections.shuffle(pokers);
    }

    public void createPlayers(){
        for (int i = 1;i<=2;i++){
            try{
                System.out.println("Type in No."+i+" player's id and name:");
                System.out.println("Type in id:");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Type in name:");
                name = sc.nextLine();
                Player player = new Player(id,name);
                players[i-1] = player;
            }catch (InputMismatchException e){
                System.out.println("Type in int");
                sc.nextLine();
                i--;
            }
        }
        System.out.println("-----Welcome player:"+players[0]);
        System.out.println("-----Welcome player:"+players[1]);
    }

    public void dealing(){
        int j =0;
        for (int i = 0; i<=1;i++)
            for (Player p: players){
                System.out.println("Player "+p.name+" get a poker");
                p.ownPokers.add(pokers.get(j));
                j++;
        }
    }

    public void getPokers(){
        System.out.println(players[0].ownPokers);
        System.out.println(players[1].ownPokers);
    }

    public void gaming(){
        class PokerCompare implements Comparator<Poker>{
            @Override
            public int compare(Poker o1, Poker o2) {
                if (o1.getNum()==o2.getNum()){
                    //     return o1.getColor(o2.getColor());         if i want this, wrong?
                    return colorMap.get(o1.getColor()).compareTo(colorMap.get(o2.getColor()));
                }else if (o1.getNum()>o2.getNum()){
                    return 1;
                }else{
                    return -1;
                }
            }
        }
        PokerCompare pokerCompare = new PokerCompare();
        for (Player p: players){
            System.out.println("Player "+p.name+" biggest one:");
            int result = pokerCompare.compare(p.getOwnPokers().get(0),p.getOwnPokers().get(1));
            if (result>0){
                bigget.add(p.getOwnPokers().get(0));
                System.out.println(p.getOwnPokers().get(0));
            }else{
                bigget.add(p.getOwnPokers().get(1));
                System.out.println(p.getOwnPokers().get(1));
            }
        }

        int result = pokerCompare.compare(bigget.get(0),bigget.get(1));
        if (result>0){
            System.out.println("Player "+players[0]+" wins!");
        }else{
            System.out.println("Player "+players[1]+" wins!");
        }

    }

    public static void main(String[] args) {
	// write your code here
        Main game = new Main();
        game.setColorMap();
        System.out.println("---------Create pokers----------");
        game.create();
        System.out.println("---------Pokers created---------");
        System.out.println("---------Start shuffling----------");
        game.shuffle();
        System.out.println("-------------Shuffled-------------");
        System.out.println("---------Create players-----------");
        game.createPlayers();
        System.out.println("---------Start dealing-----------");
        game.dealing();
        System.out.println("---------Finish dealing-----------");
        System.out.println("---------Start gaming-----------");
        game.gaming();
        System.out.println("---------Own pokers of each player:------");
        game.getPokers();
    }
}
