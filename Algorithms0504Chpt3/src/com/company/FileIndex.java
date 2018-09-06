package com.company;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

import java.util.Scanner;

/**
 * Created by mileygao on 5/11/17.
 */
public class FileIndex {
    public static void main(String[] args){
        STWithNonSequentialNode3<String, Queue> st = new STWithNonSequentialNode3();
        STWithNonSequentialNode3<String, Queue > ts = new STWithNonSequentialNode3<>();
        In in = new In(args[0]);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[0];
            for (int i = 1; i < tokens.length; i++) {
                if (!st.contain(key)){
                    st.put(key, new Queue<String>());
                }
                String value = tokens[i];
                if (!ts.contain(value)){
                    ts.put(value,new Queue<String>());
                }
                st.get(key).enqueue(value);
                ts.get(value).enqueue(key);
            }
        }
        int i = 0;
        Scanner sc = new Scanner(System.in);
        while (i < 2){
            String a = sc.next();
            if (ts.contain(a)){
                System.out.println(ts.get(a));
            }
            if (st.contain(a)){
                System.out.println(st.get(a));
            }
        }

    }
}
