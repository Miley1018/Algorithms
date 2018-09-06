package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/15/17.
 */
public class C42StrongCC {
    private int[] id;
    private boolean[] marked;
    private int cnt;
    private boolean[] marked1;
    private List<Integer> order;
    public C42StrongCC(C42DiGraph g){
        id = new int[g.V()];
        marked = new boolean[g.V()];
        order = new ArrayList<>();
        marked1 = new boolean[g.V()];
       for (int i = 0; i<g.V();i++){
           if (!marked[i]){
               dfs1(g.reverse(),i);
           }
       }
       List<Integer> topo = new ArrayList<>();
        for (int i = order.size()-1;i>=0;i--){
            topo.add(order.get(i));
        }
        for (int i:topo){
            if (!marked1[i]){
                cnt++;
                dfs(g,i);
            }
        }
    }
    private void dfs1(C42DiGraph g, int v){
        marked[v] = true;
        for (int i:g.adj(v)){
            if (!marked[i]){
                dfs1(g,i);
            }
        }
        order.add(v);
    }
    private void dfs(C42DiGraph g, int v){
        marked1[v] = true;
        id[v] = cnt;
        for (int i:g.adj(v)){
            if (!marked1[i]){
                dfs(g,i);
            }
        }
    }
    public int count(){
        return cnt;
    }
    public int id(int v){
        return id[v];
    }
    public static void main(String[] args){
        int[] a  = {13,22,4,2,2, 3,
                3, 2,
                6, 0,
                0, 1,
                2, 0,
                11, 12,
                12, 9,
                9 ,10,
                9 ,11,
                8 ,9,
                10 ,12,
                11 ,4,
                4 ,3,
                3 ,5,
                7 ,8,
                8 ,7,
                5 ,4,
                0 ,5,
                6 ,4,
                6 ,9,
                7 ,6};
        C42DiGraph dg = new C42DiGraph(a);
        C42StrongCC dfs = new C42StrongCC(dg);
        System.out.println(dfs.count()+"--"+dfs.cnt);
        List<Integer>[] t = new ArrayList[dfs.cnt];
        for (int i = 0 ; i<dfs.cnt;i++){
            t[i] = new ArrayList<>();
        }
        for (int i = 0; i<dg.V();i++){
            t[dfs.id(i)-1].add(i);
        }
        for (int i = 0; i<dfs.cnt;i++){
            for (int j:t[i]) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
