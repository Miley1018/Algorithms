package com.company;

/**
 * Created by mileygao on 6/22/17.
 */
public class Chapt4NonGraphCC {
    private int cnt;
    private int[] id;
    private boolean hasCycle = false;
    public Chapt4NonGraphCC(Chapt4NonGraph graph){
        id = new int[graph.V()];
        cnt = 0;
        for (int v = 0; v<graph.V();v++){
            if (id[v]==0) {
                id[v] = ++cnt;
                dfs(graph,v);
            }
        }
    }
    public void dfs(Chapt4NonGraph graph,int v) {
        for (int w:graph.adj(v)){
            if (id[w]==0){
                id[w] = cnt;
                dfs(graph,w);
            }
        }
        /*for (int w : graph.adj(v)) {
            if (w != v) {
                if (id[w] == 0) {
                    id[w] = cnt;
                    dfs(graph, w);
                } else {
                    System.out.println("id:"+id[w]);
                    System.out.println(v + "   " + w);
                    hasCycle = true;
                }
            }
        }
        */
    }
    public boolean hasCycle(){
        return hasCycle;
    }
    public int count(){
        return cnt;
    }
    public int id(int v){
        return id[v];
    }
    public boolean connected(int v, int w){
        return id[v] == id[w];
    }
    public static void  main(String[] args){
        String g = "13 10 0 5 0 1 6 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        Chapt4NonGraph graph = new Chapt4NonGraph(a);
        Chapt4NonGraphCC search = new Chapt4NonGraphCC(graph);
        System.out.println(search.count());
        System.out.println(search.id(5));
        System.out.println(search.id(6));
        System.out.println(search.hasCycle());
    }
}
