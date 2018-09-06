package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 6/28/17.
 */
public class DDChapt4NonGraphCC {
    private int[] id;
    private boolean[] marked;
    private int cnt ;
    public DDChapt4NonGraphCC(DDChapt4NonGraph graph){
        id = new int[graph.V()];
        marked = new boolean[graph.V()];
        for (int i = 0; i<graph.V();i++){
            if (!marked[i]){
                cnt++;
                dfs(graph,i);
            }
        }
    }
    private void  dfs(DDChapt4NonGraph graph, int v){
        marked[v] = true;
        id[v] = cnt;
        for (int w:graph.adj(v)){
            if (!marked[w]){
                dfs(graph,w);
            }
        }
    }
    public int count(){
        return cnt;
    }

    public static void  main(String[] args){
        String g = "13 13 0 5 4 3 0 1 9 12 6 4 5 4 0 2 11 12 9 10 0 6 7 8 9 11 5 3";
        String[] a = g.split(" ");
        DDChapt4NonGraph graph = new DDChapt4NonGraph(a);
        DDChapt4NonGraphCC search = new DDChapt4NonGraphCC(graph);
        System.out.println(search.count());
        int i = search.count();
        List<Integer>[] lists =new List[i];
        for (int t = 0; t<i; t++){
            lists[t] = new ArrayList<>();
        }
        for (int t = 0; t<graph.V();t++){
            lists[search.id[t]-1].add(t);
        }
        for (int t = 0; t<i; t++){
            System.out.print(t+":");
            for (int w:lists[t]){
                System.out.print(w);
            }
            System.out.println();
        }
    }
}
