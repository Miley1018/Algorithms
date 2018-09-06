package com.company;

import java.util.*;

/**
 * Created by mileygao on 8/14/17.
 */
public class C42HasCycle {
    private boolean has;
    private boolean[] onstack;
    private boolean[] marked;
    public C42HasCycle(C42DiGraph g){
        marked = new  boolean[g.V()];
        onstack = new boolean[g.V()];
        for (int i = 0; i<g.V();i++){
            if (!marked[i]){
              dfs(g,i);
            }
        }
    }
    private void dfs(C42DiGraph g, int v){
            marked[v] = true;
            onstack[v] = true;

            for (int i : g.adj(v)) {
                if (onstack[i]) {
                    has = true;
                    return;
                } else {
                    dfs(g, i);
                }
            }
            onstack[v] = false;
    }
    public boolean hasCycle(){
        return has;
    }
    public static int maxV(int[] values, int[] weights,int maxWeight){
        int n = values.length;
        int[][] a = new int[n+1][maxWeight+1];
        for (int i = 1; i<n+1;i++){
            for (int j = 1; j<maxWeight+1;j++){
                a[i][j] = Math.max(a[i-1][j],j<weights[i-1]?0:a[i][j-weights[i-1]]+values[i-1]);
            }
        }
        return a[n][maxWeight];
    }
    public static int maxVLessSpace(int[] values, int[] weights,int maxWeight){
        int n = values.length;
        int[] a = new int[maxWeight+1];
        for (int i = 1; i<n+1;i++){
            for (int j = 1; j<maxWeight+1;j++){
                a[j] = Math.max(a[j],j<weights[i-1]?0:a[j-weights[i-1]]+values[i-1]);
            }
        }
        return a[maxWeight];
    }

    public static void main(String[] args){
        int [] values = {2,5};
        int[] weights = {1,2};
        System.out.println("maxV:" + maxVLessSpace(values,weights,11));
        int[] a  = {13,22,4,2,
                3, 2,
                6, 0,
                0, 1,

                11, 12,

                9 ,10,
                9 ,11,
                8 ,9,
                10 ,12,
                11 ,4,

                3 ,5,
2,3,
                8 ,7,
                5 ,4,
                0 ,5,
                6 ,4,
                6 ,9,
                7 ,6};
        C42DiGraph dg = new C42DiGraph(a);
        C42HasCycle cycle = new C42HasCycle(dg);
        List<Integer> aa ;
        int[]  q  = {1,2};
        int[]  p  = {1,2};
        int[][] ops ={{3,2},{2,2}};
        String [] t = {"1","3"};
        String tt = new String(String.join("",t));
        List<Integer> list = new ArrayList<>();

        System.out.println("a");
    }

}
