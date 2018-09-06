package com.company;

/**
 * Created by mileygao on 6/23/17.
 */
public class Chapt4NonGraphHasCycle {
    //------------错误！需重写
    private boolean[] marked;
    private boolean hasCycle;
    public Chapt4NonGraphHasCycle(Chapt4NonGraph graph){
        marked = new  boolean[graph.V()];
        for (int v = 0; v<graph.V();v++){
            if (!marked[v]) {
                dfs(graph,v);
            }
        }
    }
    public void dfs(Chapt4NonGraph graph,int v) {

    }
    public boolean hasCycle(){
        return hasCycle;
    }
    public static void  main(String[] args){
        String g = "13 10 0 5 0 1 6 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        Chapt4NonGraph graph = new Chapt4NonGraph(a);
        Chapt4NonGraphHasCycle search = new Chapt4NonGraphHasCycle(graph);
        System.out.println(search.hasCycle());
    }
}
