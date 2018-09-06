package com.company;

import java.util.*;


/**
 * Created by mileygao on 3/7/17.
 */
public class MapTest {
    public Map<String,students> students;
    public MapTest(){
        students = new HashMap<String,students>();
    }

    public void put(){
        Scanner sc = new Scanner(System.in);
        System.out.println("this time how many?");
        String x = sc.nextLine();
        for (int i = 0; i<Integer.parseInt(x);i++){
        System.out.println("student id?");
        String id = sc.nextLine();
        students a = students.get(id);
        if (a==null){
            System.out.println("student name?");
            String name = sc.nextLine();
            students b = new students(id,name);
            students.put(id,b);
        }else{
            System.out.println("id is taken");
            i=i-1;
            continue;
        }}
    }

    public void keySetTest(){
        Set<String> ks = new HashSet<String>();
        ks = students.keySet();
        for (String id : ks){
            if (students.get(id)!=null){
            students a = students.get(id);
            System.out.println(id+a.name);}
        }
        System.out.println("total:"+students.size());
    }

    public void deleteTest(){
        while (true){
            System.out.println("id that you wanna delete:");
            Scanner sc = new Scanner(System.in);
            String id = sc.nextLine();
            students a = students.get(id);
            if (a==null){
                System.out.println("not exist");
                continue;
            }else{
            students.remove(id);
            break;}}

    }

    public void entrySetTest(){
        Set<Map.Entry<String,students>> es = students.entrySet();
        for (Map.Entry<String,students> entryset: es){
            System.out.println(entryset.getKey()+entryset.getValue().name);
        }
    }

    public void modifyTest(){
        while (true){
            System.out.println("id that you wanna modify:");
            Scanner sc = new Scanner(System.in);
            String id = sc.nextLine();
            students a = students.get(id);
            if (a==null){
                System.out.println("not exist");
                continue;
            }else{
                System.out.println("id is"+id+", you wanna change name to?");
                String name = sc.nextLine();
                students b = new students(id,name);
                students.put(id,b);
                break;}}
    }

    public static void main(String[] args){
        MapTest mt = new MapTest();
        mt.put();
        mt.keySetTest();
        mt.deleteTest();
        mt.entrySetTest();
        mt.modifyTest();
        mt.entrySetTest();
    }
}
