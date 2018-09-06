package com.company;

/**
 * Created by mileygao on 6/28/17.
 */
public class DDChapt4NonGraphHasCycle {
    private boolean has;
    private boolean[] marked;
    public DDChapt4NonGraphHasCycle(DDChapt4NonGraph graph){
        marked = new boolean[graph.V()];
        for (int i = 0; i<graph.V();i++){
            if(!marked[i]){
                dfs(graph,i,i);
            }
        }
    }
    private void dfs(DDChapt4NonGraph graph, int v, int before){
        marked[v] = true;
        for (int w:graph.adj(v)){
            if (!marked[w]){
                dfs(graph,w,v);
            }else if (w!=before){
                has = true;
            }
        }
    }
    public boolean hasCycle(){
        return has == true;
    }
    public static void  main(String[] args){
        String g = "13 13 0 5 0 1 6 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        DDChapt4NonGraph graph = new DDChapt4NonGraph(a);
        DDChapt4NonGraphHasCycle search = new DDChapt4NonGraphHasCycle(graph);
        System.out.println(search.hasCycle());
    }
}
