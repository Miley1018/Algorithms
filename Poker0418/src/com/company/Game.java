package com.company;

import java.util.Comparator;

/**
 * Created by mileygao on 4/18/17.
 */
public class Game implements Comparator<Poker> {
    @Override
    public int compare(Poker o1, Poker o2) {
        if ((o2 == null)||(o1 == null)){             //--------------what?
            return 0;
        } else if ((o1.num*4+o1.color)>(o2.num*4+o2.color)){
            return 1;
        } else{
            return -1;
        }
    }

    public static Poker comparing(Poker o1, Poker o2){
        Game game = new Game();
        int result = game.compare(o1,o2);
        if (result>0){
            return o1;
        }else if (result<0){
            return o1;
        }else{
            return null;
        }
    }

    public static void gaming(){
            Game game = new Game();
            System.out.println("Create pokers");
            System.out.println("Created pokers");
            Poker.pokerAll();
            System.out.println(Poker.pokerAll);
            System.out.println("Start shuffling");
            Dealer.shuffle(Poker.pokerAll);
            System.out.println("Finish shuffling");
            System.out.println("Create players");
            Player player = new Player();
            player.create();
            System.out.println("Start dealing");
            Dealer.dealing(Poker.pokerAll,player.players);
            System.out.println("Finish dealing");
            System.out.println("Start gaming");

            System.out.println("Player " + player.players[0] + " biggest: " + game.comparing(player.players[0].ownPokers.get(0),player.players[0].ownPokers.get(1)));
            System.out.println("Player " + player.players[0] + " biggest: " + game.comparing(player.players[1].ownPokers.get(0),player.players[1].ownPokers.get(1)));


            System.out.println("Each player's pokers:");
            System.out.println(player.players[0]+" : "+player.players[0].ownPokers);
            System.out.println(player.players[1]+" : "+player.players[0].ownPokers);
        }
}
