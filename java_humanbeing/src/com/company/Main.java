package com.company;

import java.util.*;

public class Main{
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
        System.out.println("change 1 to:"+courseToselect.get(0).name);      // why cant (Course)courseToselect.get(0).name?
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

    public void contains(){
        Courses cr = new Courses("2","Geo");
        boolean a = courseToselect.contains(cr);
        System.out.println("contains or not: "+a);

    }

    static class comparator1 implements Comparator<Courses>{
        @Override
        public int compare(Courses o1, Courses o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static void main(String[] args) {
        Main a = new Main();
        a.add();
        Collections.sort(a.courseToselect);  //             ----------------------------why
        Collections.sort(a.courseToselect,a.comparator1());   //             ----------------------------why
        a.modify();
        a.get();
        a.contains();;
        a.iteratorTest();
        a.testForech();
        a.delete();
        System.out.println("------");
        a.iteratorTest();
    }
}
