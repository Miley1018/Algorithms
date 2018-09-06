package com.company;

/**
 * Created by mileygao on 8/14/17.
 */
public class C41CC {
    private int cnt;
    private int[] id;
    public C41CC(C41Graph g){
        id = new int[g.V()];
        for (int i = 0; i<g.V();i++){
            id[i] = -1;
        }
        for (int i = 0; i<g.V();i++){
            if (id[i]==-1){
                dfs(g,i);
                cnt++;
            }
        }
    }
    private void dfs(C41Graph g, int v){
        id[v] = cnt;
        for (int i:g.adj(v)){
            if (id[i]==-1){
                dfs(g,i);
            }
        }
    }
    public boolean connected(int i, int j) {
        return id[i]==id[j];
    }
    public int count() {
        return cnt;
    }
    public int id(int v) {
        return id[v];
    }
    public static void main(String[] args) {
        int[] a = {13, 13, 0, 5, 4, 3, 0, 1, 9, 12, 6, 4, 5, 4, 0, 2, 11, 12, 9, 10, 0, 6, 7, 8, 9, 11, 5, 3};
        C41Graph g = new C41Graph(a);
        C41CC cc = new C41CC(g);
        System.out.println(cc.count()+cc.id(0)+" --"+cc.id(8)+"--"+cc.connected(0,6));
    }
}