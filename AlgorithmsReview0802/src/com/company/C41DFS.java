package com.company;

/**
 * Created by mileygao on 8/14/17.
 */
public class C41DFS {
    private boolean[] marked;
    private int cnt ;
    public C41DFS(C41Graph g,int s){
        marked = new boolean[g.V()];
        dfs(g,s);
    }
    private void dfs(C41Graph g, int v){
        marked[v] = true;
        cnt++;
        for (int i:g.adj(v)){
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }
    public boolean connected(int j){
        return marked[j];
    }
    public int count(){
        return cnt;
    }
    public static void main(String[] args){
        int[] a = {13,13,0,5,4,3,0,1,9,12,6,4,5,4,0,2,11,12,9,10,0,6,7,8,9,11,5,3};
        C41Graph g = new C41Graph(a);
        C41DFS dfs = new C41DFS(g,0);
        if (dfs.cnt!=g.V()){
            System.out.println("Not ");
        }
        System.out.println("Connected");
        System.out.println(g);
    }
}
