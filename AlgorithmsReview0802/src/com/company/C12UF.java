package com.company;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by mileygao on 8/2/17.
 */
public class C12UF {
    private int[] id ;
    private int N;
    private int[] size;
    public C12UF(int n){
        N= n;
        id = new int[n];
        size = new int[n];
        for (int i = 0; i<n; i++){
            id[i] = i;
        }
    }
    public int find(int i){
        int t = i;
        while (i!=id[i]){
            i = id[i];
        }
        int q = i;
        i = t;
        while (i!=id[i]){
            int p = id[i];
            id[i]= q;
            i = p;
        }
        return q;
    }
    public void union(int i, int j){
        int x = find(i);
        int y = find(j);
        if (x!=y){
            N--;
            if (size[x]<size[y]){
                id[x] = y;
                size[y]+=size[x];
            }else {
                id[y] = x;
                size[x]+=size[y];
            }
        }
    }
    public int count(){
        return N;
    }
    public boolean connected(int i, int j){
        int t = find(i);
        int e = find(j);
        return t==e;
    }

    public Map<String, List<String[]>> spiral(Map<String, List<String[]>> map) {
        // Write your solution here
        if (map == null || map.size() <= 1) {
            return map;
        }
        int entryCount = 0;
        boolean isBreak;
        while (entryCount < map.size()) {
            isBreak = false;
            String[] keys = Arrays.copyOf(map.keySet().toArray(), map.keySet().toArray().length, String[].class);
            String from = keys[entryCount];
            System.out.println("from:" + from);
            List<String[]> list = map.get(from);
            if (list.size() == 0) {
                entryCount++;
                continue;
            }
            for (String[] i : list) {
                String to = i[0];
                if (map.containsKey(to)) {
                    System.out.println("to:" + to);
                    List<String[]> nextList = map.get(to);
                    if (nextList.size() == 0) {
                        continue;
                    }
                    String[] j = nextList.get(0);
                    String nextTo = j[0];
                    list.remove(i);
                    nextList.remove(j);
                    if (Integer.parseInt(j[1]) > Integer.parseInt(i[1])) {
                        String[] newArray1 = {nextTo, i[1]};
                        String[] newArray2 = {nextTo, (Integer.parseInt(j[1]) - Integer.parseInt(i[1])) + ""};
                        map.get(from).add(newArray1);
                        map.get(to).add(newArray2);
                    } else {
                        String[] newArray1 = {nextTo, j[1]};
                        map.get(from).add(newArray1);
                        if (Integer.parseInt(j[1]) != Integer.parseInt(i[1])) {
                            String[] newArray2 = {to, (Integer.parseInt(i[1]) - Integer.parseInt(j[1])) + ""};
                            map.get(from).add(newArray2);
                        }
                    }
                    entryCount = 0;
                    isBreak = true;
                    printMap(map);
                    break;
                } else {
                    continue;
                }
            }
            if (isBreak) {
                continue;
            }
            entryCount++;
        }
        printMap(map);
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, List<String[]>> entry: map.entrySet()) {
            String from = entry.getKey();
            List<String[]> list = entry.getValue();
            if (list.size() == 0) {
                set.add(from);
                continue;
            }
            Map<String, Integer> mapHelper = new HashMap<>();
            for (String[] i: list) {
                mapHelper.put(i[0], mapHelper.getOrDefault(i[0], 0) + Integer.parseInt(i[1]));
            }
            List<String[]> listNew = new ArrayList<>();
            for (Map.Entry<String, Integer> arrayEntry: mapHelper.entrySet()) {
                String[] newA = {arrayEntry.getKey(), arrayEntry.getValue() + ""};
                listNew.add(newA);
            }
            map.put(from, listNew);
        }
        for (String i: set) {
            map.remove(i);
        }
        printMap(map);
        return map;
    }

    private void printMap(Map<String, List<String[]>> map) {
        for (Map.Entry<String, List<String[]>> entry : map.entrySet()) {
            System.out.println( "------------------------");
            System.out.println(entry.getKey() + ":");
            List<String[]> list = entry.getValue();
            for (String[] i : list) {
                System.out.println(i[0] + "--" + i[1]);
            }
        }
    }
    public static void main(String[] args){
        C12UF uf = new C12UF(10);
        int n = 10;
        Scanner sc = new Scanner(System.in);
//        while (n>0){
//            System.out.println(n);
//            int i = sc.nextInt();
//            int j = sc.nextInt();
//            uf.union(i,j);
//
//            n--;
//        }
//        System.out.println(uf.count());
        Map<String, List<String[]>> map = new HashMap<>();

        List<String[]> list1 = new ArrayList<>();
        String[] array1 = {"c","20"};
        String[] array2 = {"b","30"};
        String[] array5 = {"e","10"};
        list1.add(array1);
        list1.add(array2);
        list1.add(array5);
        map.put("a", list1);

        List<String[]> list2 = new ArrayList<>();
        String[] array3 = {"c","10"};
        list2.add(array3);
        map.put("b", list2);
        uf.spiral(map);

        List<String[]> list3 = new ArrayList<>();
        String[] array4 = {"c","50"};
        list3.add(array4);
        map.put("e", list3);

        uf.spiral(map);

        for (Map.Entry<String, List<String[]>> entry : map.entrySet()) {
            System.out.println( "------------------------");
            System.out.println(entry.getKey() + ":");
            List<String[]> list = entry.getValue();
            for (String[] i : list) {
                System.out.println(i[0] + "--" + i[1]);
            }
        }
    }
}
