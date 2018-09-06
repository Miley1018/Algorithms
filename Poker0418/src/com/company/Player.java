package com.company;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mileygao on 4/18/17.
 */
public class Player {
    private int id;
    private String name;
    List<Poker> ownPokers = new ArrayList<>();
    public Player[] players = new Player[2];
    public Player(){

    }
    private Player(String name, int id){
        this.name = name;
        this.id = id;
    }
    public void create(){                        // -------------------------------------no static now?
        int i = 1;
        Scanner sc = new Scanner(System.in);
        while (i<=2){
            System.out.println("Type in No." + i + " player's id and name:");
            try {
                System.out.println("Type in id:");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Type in name:");
                name =  sc.nextLine();
                players[i-1] = new Player(name,id);
                i = i+1;
            } catch (InputMismatchException e){
                System.out.println("Type in int");
                sc.nextLine();
                continue;
            }
        }
        System.out.println("Welcom player: "+players[0].name);
        System.out.println("Welcom player: "+players[1].name);
    }

    @Override
    public String toString() {
        return name;
    }
}
