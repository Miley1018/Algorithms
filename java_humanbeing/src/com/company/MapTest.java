package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mileygao on 4/14/17.
 */
public class MapTest {
    public Map<String,Students> studentsAll = new HashMap<String,Students>();
    public Scanner sc = new Scanner(System.in);
    public void add(){
        System.out.println("this time how many?");

        int i = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j<i;j++){
            System.out.println("student id?");
            String id = sc.nextLine();
            if (studentsAll.get(id) == null){
                System.out.println("student name?");
                String name = sc.nextLine();
                studentsAll.put(id,new Students(id,name));
                System.out.println("put in:"+studentsAll.get(id).id+studentsAll.get(id).name);
            }else{
                System.out.println("already taken, change id:");
                j=j-1;
            }
        }
    }

    public void keySet(){
        Set key =  studentsAll.keySet();
        System.out.println(key);
        for (Object i : key){
            System.out.println(studentsAll.get((String)i).name);

        }
    }

    public void delete(){
        System.out.println("which to delete");
        String id = sc.nextLine();
        if (studentsAll.get(id)==null){
            System.out.println("not exist");
        }else{
            studentsAll.remove(id);
        }
    }

    public void modify(){
        System.out.println("which to modify");
        String id = sc.nextLine();
        if (studentsAll.get(id)==null){
            System.out.println("not exist");
        }else{
            System.out.println("change name to?");
            String name = sc.nextLine();
            studentsAll.put(id,new Students(id,name));
        }
        System.out.println("change to :"+studentsAll.get(id).id+studentsAll.get(id).name);
    }

    public void entrySet(){
        Set<Map.Entry<String,Students>> entry = studentsAll.entrySet();
        for (Map.Entry<String,Students> a : entry){
            System.out.println(a.getKey()+a.getValue().name);
        }

    }

    public static void main(String[] args){
        MapTest mapTest = new MapTest();
        mapTest.add();
        mapTest.entrySet();
        mapTest.keySet();
        mapTest.delete();
        mapTest.keySet();
        mapTest.modify();

    }
}
