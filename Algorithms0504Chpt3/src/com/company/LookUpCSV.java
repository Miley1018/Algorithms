package com.company;

import edu.princeton.cs.algs4.In;

import java.util.Scanner;

/**
 * Created by mileygao on 5/11/17.
 */
public class LookUpCSV {
    public static void main(String[]  args){
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valueField = Integer.parseInt(args[2]);
        STWithNonSequentialNode3 st = new STWithNonSequentialNode3();
        while (in.hasNextLine()){
            String line = in.readLine();
            System.out.println(line);
            String[] tokens = line.split(",");
            for (int i = 0; i <tokens.length; i++){
                System.out.print(tokens[i] + " ");
            }
            System.out.println();
            String key = tokens[keyField];
            String value = tokens[valueField];
            st.put(key,value);
        }
        int i = 2;
        Scanner sc = new Scanner(System.in);
        while(i>0){
            String key = sc.next();
            if (st.contain(key)){
                System.out.println(st.get(key));
            }
            i--;
        }

    }
}
