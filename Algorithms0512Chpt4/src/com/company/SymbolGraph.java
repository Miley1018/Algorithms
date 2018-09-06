package com.company;

import edu.princeton.cs.algs4.In;

/**
 * Created by mileygao on 5/15/17.
 */
public class SymbolGraph {
    private ST<String,Integer> st;
    private String[] keys;
    private Graph2 graph2;
    public SymbolGraph(String stream, String gap){
         st = new ST();
         In in = new In(stream);
         while (in.hasNextLine()){
             String[] s = in.readLine().split(gap);
             for (int i =0; i <s.length; i ++){
                 if (!st.contains(s[i])) {
                     st.put(s[i], st.size());
                 }
             }
         }
         keys = new String[st.size()];
         for (String s: st.keys()){
            keys[st.get(s)] = s;
         }
         graph2 = new Graph2(st.size());
         in = new In(stream);
         while (in.hasNextLine()) {
             String[] s = in.readLine().split(gap);
             int v = st.get(s[0]);
             for (int i = 1; i < s.length; i++) {
                 graph2.addEdge(v,st.get(s[i]));
             }
         }
    }
    public boolean contains(String s){
        return st.contains(s);
    }
    public int index(String s){
        return st.get(s);
    }
    public String name(int v){
        return keys[v];
    }
    public Graph2 G(){
        return graph2;
    }
    public static void main(String[] args){
        SymbolGraph sg = new SymbolGraph(args[0],args[1]);
        System.out.println(sg.G());
        String now = args[2];
        BreadthFirstSearch2 bfs = new BreadthFirstSearch2(sg.graph2,sg.index(now));
        String x = "d";
        if (sg.contains(x)){
            if (bfs.hasPathTo(sg.index(x))){
                for (int i : bfs.pathTo(sg.index(x))){
                    System.out.println(sg.name(i));
                }
            }else {
                System.out.println("not connected");
            }
        }else {
            System.out.println("not existed");
        }
    }
}
