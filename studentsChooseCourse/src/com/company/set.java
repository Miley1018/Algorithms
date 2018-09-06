package com.company;

import java.util.*;

/**
 * Created by mileygao on 3/7/17.
 */
public class set {
    public List<courses> courses;
    set(){
        courses = new ArrayList<courses>();
    }

    public void testContains(){
        courses a = courses.get(0);
        System.out.println("get this course:"+a.coursesname+".contains or not:"+courses.contains(a));
        courses b = new courses(a.i,a.coursesname);
        System.out.println("get this course:"+b.coursesname+".contains or not:"+courses.contains(b));
    }

    public void Add(){
        courses[] a = {new courses("10","English"),new courses("12","English2"),new courses("13","English"),new courses("14","English412"), new courses("11","Chinese"),new courses("12","Math")};
        courses.addAll(Arrays.asList(a));
    }

    public void Foreach(){
        for (courses cr:courses){
            System.out.println(cr.i+cr.coursesname);
        }
    }

    public static void main(String[] args){
        students a = new students("1","miley");
        Scanner sc = new Scanner(System.in);
        set s = new set();
        s.Add();
        s.Foreach();
        for (int i = 0; i<2;i++){
            System.out.println("pls type in 10/11/12 to choose 2 courses:");
            String courseid = sc.next();

            for (courses cr: s.courses){
                if (cr.i.equals(courseid)){
                    a.courses.add(cr);
                }
            }

        }

        /*List<String> test = new ArrayList<String>();
        test.add("1000");
        test.add("1");
        test.add("3");
        Collections.sort(test);
        for (String aa:test){
            System.out.println(aa);
        }*/

        for (courses cr: a.courses){
            System.out.println(cr.i+cr.coursesname);
        }

        s.testContains();
    }

}
