package com.company;

import java.util.Collections;
import java.util.List;

/**
 * Created by mileygao on 4/18/17.
 */
public class Dealer {
    int i = 0;
    public static void shuffle(List<Poker> pokers){
        Collections.shuffle(pokers);
    }
    public static void dealing(List<Poker> pokers, Player[] players){
        Dealer dealer = new Dealer();
        System.out.println("Player "+players[0]+" get a card");
        players[0].ownPokers.add(dealer.deal(pokers));
        System.out.println("Player "+players[1]+" get a card");
        players[1].ownPokers.add(dealer.deal(pokers));
        System.out.println("Player "+players[0]+" get a card");
        players[0].ownPokers.add(dealer.deal(pokers));
        System.out.println("Player "+players[1]+" get a card");
        players[1].ownPokers.add(dealer.deal(pokers)); //-----------------------------why
    }

    public Poker deal(List<Poker> pokers){
        if (i<pokers.size()){
            System.out.println("poker::::::"+pokers.get(i++));
            return pokers.get(i++);
        }else{
            return null;
        }
    }
}
