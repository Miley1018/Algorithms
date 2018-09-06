package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mileygao on 8/14/17.
 */
public class C41HasPathShortest {
    private boolean[] marked;
    private int[] pathTo;
    private final int s;
    private List<Integer> l;
    public C41HasPathShortest(C41Graph g, int s){
        this.s = s;
        marked = new boolean[g.V()];
        pathTo = new int[g.V()];
        l = new ArrayList<>();
        pathTo[s] = s;
        marked[s] = true;
        l.add(s);
        while (!l.isEmpty()){
            int t = l.get(0);
            l.remove(0);
            bfs(g,t);
        }
    }
    private void bfs(C41Graph g, int v){
        for (int i:g.adj(v)){
            if (!marked[i]) {
                marked[i] = true;
                pathTo[i] = v;
                l.add(i);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public List<Integer> pathTo(int v){
        List<Integer> list = new ArrayList<>();
        for (int i = v; i!=s; i = pathTo[i]){
            list.add(i);
        }
        list.add(s);
        return list;
    }
    public static void main(String[] args){
        int[] a = {13,13,0,5,4,3,0,1,9,12,6,4,5,4,0,2,11,12,9,10,0,6,7,8,9,11,5,3};
        C41Graph g = new C41Graph(a);
        C41HasPathShortest bfs = new C41HasPathShortest(g,0);
        System.out.println(bfs.pathTo(3));
    }
}
