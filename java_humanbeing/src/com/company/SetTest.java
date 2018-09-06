package com.company;

import java.util.*;

/**
 * Created by mileygao on 4/14/17.
 */
public class SetTest {
    List<Courses> courseToselect = new ArrayList<Courses>();

    public void add(){
        Courses cr1 = new Courses("1","English");
        courseToselect.add(cr1);
        Courses temp1 = (Courses) courseToselect.get(0);
        System.out.println("add:"+temp1);

        Courses cr2 = new Courses("2","Math");
        courseToselect.add(cr2);
        Courses temp2 = (Courses) courseToselect.get(1);
        System.out.println("add:"+temp2);

        Courses[] multi = {new Courses("3","lib"), new Courses("4","Music")};
        courseToselect.addAll(Arrays.asList(multi));
        Courses temp3 = (Courses) courseToselect.get(2);
        Courses temp4 = (Courses) courseToselect.get(3);
        System.out.println("add:"+temp3.num+"      "+temp3.name+" "+temp4);
    }

    public void modify(){
        Courses cr0 = new Courses("1","Geo");
        courseToselect.set(0,cr0);
        System.out.println("change 1 to:"+courseToselect.get(0));
    }

    public void get(){
        System.out.println("as follows: ");
        for (int i =0; i <courseToselect.size();i++){
            Courses temp = (Courses) courseToselect.get(i);
            System.out.println(temp.num+temp.name);
        }
    }

    public void iteratorTest(){
        Iterator it = courseToselect.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public void testForech(){
        for (Object i: courseToselect){
            Courses temp = (Courses)i;
            System.out.println(temp.num+temp.name);
        }
    }

    public void delete(){
        courseToselect.remove(0);
        Courses temp1 = (Courses) courseToselect.get(0);
        Courses temp2 = (Courses) courseToselect.get(1);
        courseToselect.removeAll(Arrays.asList(temp1,temp2));
    }

    public void testContains(){
        Courses cr = courseToselect.get(0);
        Courses cr2 = new Courses(cr.num,cr.name);
        System.out.println("contains or not:"+courseToselect.contains(cr));
        System.out.println("contains or not 2:"+courseToselect.contains(cr2));
    }

    public static void main(String[] args){
        SetTest a = new SetTest();
        a.add();
        a.modify();
        a.get();
        a.iteratorTest();
        a.testForech();
        Students first = new Students("1","xiaoming");
        System.out.println("welcome");
        Scanner sc = new Scanner(System.in);
        for (int i =0;i<3;i++){
            System.out.println("type in id");
            String id = sc.nextLine();
            for (Courses cr: a.courseToselect){
                if (cr.num.equals(id)){
                    first.courses.add(cr);
                }
            }
        }
        for(Courses cr: first.courses){
            System.out.println(cr);
        }

        a.testContains();
    }
}
