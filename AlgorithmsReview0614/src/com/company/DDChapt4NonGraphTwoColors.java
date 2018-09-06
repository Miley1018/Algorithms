package com.company;

/**
 * Created by mileygao on 6/28/17.
 */
public class DDChapt4NonGraphTwoColors {
    private boolean two = true;
    private boolean[] marked;
    private boolean[] colors;
    public DDChapt4NonGraphTwoColors(DDChapt4NonGraph graph){
        marked = new boolean[graph.V()];
        colors = new boolean[graph.V()];
        for(int i = 0; i<graph.V();i++){
            if (!marked[i]){
                dfs(graph,i);
            }
        }
    }
    private void dfs(DDChapt4NonGraph graph, int v){
        marked[v]= true;
        for (int w:graph.adj(v)){
            if (!marked[w]){
                colors[w] = !colors[v];
                dfs(graph,w);
            }else if(colors[w]==colors[v]){
                two = false;
            }
        }
    }
    public boolean twoColors(){
        return two==true;
    }
    public static void  main(String[] args){
        String g = "13 13 0 5 0 1 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        DDChapt4NonGraph graph = new DDChapt4NonGraph(a);
        DDChapt4NonGraphTwoColors search = new DDChapt4NonGraphTwoColors(graph);
        System.out.println(search.twoColors());
    }
}
