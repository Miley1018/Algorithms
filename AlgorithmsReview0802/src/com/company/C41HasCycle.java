package com.company;

import java.util.Arrays;

/**
 * Created by mileygao on 8/14/17.
 */
public class C41HasCycle {
    private boolean[] marked;
    private boolean hasCycle ;
    public C41HasCycle(C41Graph g){
        marked = new boolean[g.V()];
       for (int i = 0; i<g.V();i++){
           if (!marked[i]){
               dfs(g,i,i);
           }
       }
    }
    private void dfs(C41Graph g, int v, int before){
        marked[v] = true;
        for (int i:g.adj(v)){
            if (!marked[i]){
                dfs(g,i,v);
            }else if (i!=before){
                hasCycle = true;
            }
        }
    }
    public boolean hasCycle(){
        return hasCycle;
    }
    public static void main(String[] args) {
        int[] a = {13, 10, 0, 5,  0, 1, 5, 4, 0, 2, 11, 12, 9, 10, 0, 6, 7, 8, 9, 11, 5, 3};
        C41Graph g = new C41Graph(a);
        C41HasCycle cc = new C41HasCycle(g);


        System.out.println(cc.hasCycle());
    }
}
