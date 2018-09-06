package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mileygao on 4/5/17.
 */
public class TicTacToe {
    public void judge(String[][] a, String pp, Map<String,String> pwithc){
        int cn1 = 0;
        int cn2 = 0;
        int cn3 = 0;
        int cn4 = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (a[i][j] == pwithc.get(pp)){
                    cn1++;
                }
            }
            if (cn1 == 3){
                break;
            }else{
                cn1=0;
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (a[j][i]==pwithc.get(pp)){
                    cn2++;
                }
            }
            if (cn2 == 3){
                break;
            }else{
                cn2=0;
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if ((i==j)&&(a[i][j]==pwithc.get(pp))){
                    cn3++;
                }
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if ((i+j == 2)&&(a[i][j]==pwithc.get(pp))){
                    cn4++;
                }
            }
        }

        if ((cn1 == 3)|| (cn2 == 3)||(cn3 == 3)||(cn4 == 3)){
            System.out.println(pp+"win");
            System.exit(0);
        }
        boolean isbreak = false;
        boolean isfull = true;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (a[i][j] == "-"){
                    isbreak = true;
                    break;
                }
            }
            if (isbreak==true){
                isfull=false;
                break;
            }
        }

        if (isfull==true){
            System.out.println("even!");
            System.exit(0);
        }

    }


    public static void main(String[] args){
        TicTacToe ttt = new TicTacToe();
        String[][] a = new String[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                a[i][j] = "-";
            }
        }
        Chess chess = new Chess(a);
        Players ppp = new Players();
        Scanner sc = new Scanner(System.in);
        String[] pp = new String[2];
        pp[0] = "p1";
        pp[1] = "p2";
        Map<String,String> pwithc= new HashMap<String,String>();
        pwithc.put(pp[0],"o");
        pwithc.put(pp[1],"x");
        for (int div = 0; div<2; div = (div+1)%2){
                while (true){
                    System.out.println(pp[div]+"puts chess to:");
                    int x = sc.nextInt();
                    int y =sc.nextInt();
                    if (ppp.put(pp[div],x,y,a) == false){
                        continue;
                    }else{
                        chess.display();
                        break;
                    }
                }
                ttt.judge(a,pp[div],pwithc);
        }
    }
}
