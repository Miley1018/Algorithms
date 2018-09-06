package com.company;

import java.util.*;

/**
 * Created by mileygao on 3/9/17.
 */
public class Game {
    List<String> player1Poker = new ArrayList<String>();
    List<String> player2Poker = new ArrayList<String>();

    List<String> shufflePoker(List<String> list){
        Collections.shuffle(list);
        return list;
    }

    void dealing(List<String> pokerShuffled){
        Random a = new Random();
        for (int i = 0; i<2;i++){
            int p1 = a.nextInt();
            player1Poker.add(pokerShuffled.get(p1));
            int p2 = a.nextInt();
            player2Poker.add(pokerShuffled.get(p2));
        }
    }

    class comparePoker implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    }

}
