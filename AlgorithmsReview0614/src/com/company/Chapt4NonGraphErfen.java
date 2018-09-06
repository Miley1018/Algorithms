package com.company;

/**
 * Created by mileygao on 6/22/17.
 */
public class Chapt4NonGraphErfen {
    private boolean[] marked;
    private boolean[] color;
    private boolean isErfen;
    public Chapt4NonGraphErfen(Chapt4NonGraph graph){
        marked = new boolean[graph.V()];
        isErfen = true;
        color = new boolean[graph.V()];
        for (int i = 0; i<graph.V();i++) {
            if(!marked[i]) {
                dfs(graph, i);
            }
        }
    }
    private void dfs(Chapt4NonGraph graph,int v){
        marked[v] = true;
        for (int w:graph.adj(v)){
            if (!marked[w]){
                color[w]=!color[v];
                dfs(graph,w);
            }else if(color[w]==color[v]){
                isErfen=false;
            }
        }
    }
    public boolean isErfen(){
        return isErfen;
    }
    public static void  main(String[] args){
        String g = "13 13 0 5 0 1 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        Chapt4NonGraph graph = new Chapt4NonGraph(a);
        Chapt4NonGraphErfen search = new Chapt4NonGraphErfen(graph);
        System.out.println(search.isErfen());
    }
}
