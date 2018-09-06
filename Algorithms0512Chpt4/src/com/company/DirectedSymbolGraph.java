package com.company;

import edu.princeton.cs.algs4.In;

/**
 * Created by mileygao on 5/17/17.
 */
public class DirectedSymbolGraph {
    private int count;
    private ST<String,Integer> st;
    private String[] keys;
    private DiGraph diGraph;
    public DirectedSymbolGraph(String stream, String sep){
        In in = new In(stream);
        st = new ST<>();
        while (in.hasNextLine()) {
            String[] s = in.readLine().split(sep);
            for (int i =0; i <s.length; i ++){
                if (!st.contains(s[i])){
                    st.put(s[i],count++);
                }
            }
        }
        keys = new String[count];
        for (String s: st.keys()){
            keys[st.get(s)] = s;
        }
        In in1 = new In(stream);
        diGraph = new DiGraph(count);
        while (in1.hasNextLine()){
            String[] s = in1.readLine().split(sep);
            for (int i =1; i <s.length; i ++){
                diGraph.addEdge(st.get(s[0]),st.get(s[i]));
            }
        }
    }
    public DiGraph G(){
        return diGraph;
    }
    public String name(int v){
        return keys[v];
    }
    public int index(String s){
        return st.get(s);
    }
    public boolean contains(String s){
        return st.get(s)!=null;
    }
    public static void main(String[] args){
        DirectedSymbolGraph symbolDigraph = new DirectedSymbolGraph(args[0],args[1]);
        System.out.println(symbolDigraph.G()+"\n" +symbolDigraph.name(0));
    }
}
