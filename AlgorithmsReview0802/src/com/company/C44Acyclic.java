package com.company;

import java.util.*;

/**
 * Created by mileygao on 8/17/17.
 */
public class C44Acyclic {
    private boolean[] marked;
    private List<Integer> list ;
    private double[] disTo;
    private C44WeightedDiEdge[] edgeTo;
    public C44Acyclic(C44WeightedDiGraph g, int s){
        topo(g);
        disTo = new double[g.V()];
        edgeTo = new C44WeightedDiEdge[g.V()];
        for (int i = 0; i<g.V();i++){
            disTo[i] = Double.POSITIVE_INFINITY;
        }
        disTo[s] = 0.0;
        for (int i:list){
            for (C44WeightedDiEdge e:g.adj(i)){
                int w = e.to();
                System.out.println(e);
                System.out.println(disTo[w]+"---"+disTo[i]+"---"+e.weight());
                if (disTo[w]>disTo[i]+e.weight()){
                    disTo[w]=disTo[i]+e.weight();

                    edgeTo[w] = e;
                }
            }
        }
    }
    private List<Integer> topo(C44WeightedDiGraph g){
        marked = new boolean[g.V()];
        list = new  ArrayList<>();
        for (int i = 0; i<g.V();i++){
            if (!marked[i]){
                dfs(g,i);
            }
        }
        Collections.reverse(list);
        return list;
    }
    private void dfs(C44WeightedDiGraph g, int v){
        marked[v] = true;
        for (C44WeightedDiEdge e :g.adj(v)){
            int w = e.to();
            if (!marked[w]){
                dfs(g,w);
            }
        }
        list.add(v);
    }
    public List<C44WeightedDiEdge> pathTo(int v){
        List<C44WeightedDiEdge> list1 = new ArrayList<>();
        for (C44WeightedDiEdge e = edgeTo[v]; e!=null;e = edgeTo[e.from()]){
            System.out.println(e);
            list1.add(e);
        }
        return list1;
    }
    public static void main(String[] args){
        String a = "8 " +
                "13 " +
                "5 4 0.35 " +
                "4 7 0.37 " +
                "5 7 0.28 " +
                "5 1 0.32 " +
                "4 0 0.38 " +
                "0 2 0.26 " +
                "3 7 0.39 " +
                "1 3 0.29 " +
                "7 2 0.34 " +
                "6 2 0.40 " +
                "3 6 0.52 " +
                "6 0 0.58 " +
                "6 4 0.93 ";
        String[] aa = a.split(" ");
//        C44WeightedDiGraph g = new C44WeightedDiGraph(aa);
//        C44Acyclic sp = new C44Acyclic(g,5);
//        System.out.println(sp.pathTo(2));
//        System.out.println("Hello World");
//        LinkedHashMap<String, List<String>> hMap =  new LinkedHashMap<>();
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        hMap.put("1", list);
//        List<List<String>> l = new ArrayList<List<String>>(hMap.values());
//        System.out.print(l.get(0));
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        int cnt = 0;
        int size = map.size();
        while (map.size() < 4) {
            map.put("c", 3);
            map.put("d", 4);
            map.put("e", 4);
            map.remove("a");
            System.out.println(map);
            size = map.size();
            System.out.println(size);
        }
    }
}
