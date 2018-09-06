package com.company;
import java.util.*;

public class Main {

        public List  coursesToSelect;
        public Main(){
            this.coursesToSelect = new ArrayList();
        }

        public void add(){
            courses cr1 = new courses("1","English");
            coursesToSelect.add(cr1);
            courses a = (courses) coursesToSelect.get(0);
            System.out.println(a.i+a.coursesname);

            courses[] cr2  ={new courses("2","Math"),new courses("3","Music")};
            coursesToSelect.addAll(0,Arrays.asList(cr2));
            courses b = (courses) coursesToSelect.get(0);
            courses c = (courses) coursesToSelect.get(2);
            System.out.println(b.i+b.coursesname);
            System.out.println(c.i+c.coursesname);
        }

        public void Get(){
            int size = coursesToSelect.size();
            for (int i = 0; i< size; i++){
                courses cr = (courses) coursesToSelect.get(i);
                System.out.println(cr.i+cr.coursesname);
            }

            for (Object obj: coursesToSelect){
                courses cr = (courses) obj;
                System.out.println(cr.i+cr.coursesname);
            }

            Iterator i = coursesToSelect.iterator();
            while(i.hasNext()){
                courses cr = (courses) i.next();
                System.out.println(cr.i+cr.coursesname);
            }

        }

    public void Modify(){
        coursesToSelect.set(0,new courses("1","Math"));
        Iterator i = coursesToSelect.iterator();
        while(i.hasNext()){
            courses cr = (courses) i.next();
            System.out.println(cr.i+cr.coursesname);
        }

    }

    public void Delete(){
        coursesToSelect.remove(0);
        Iterator i = coursesToSelect.iterator();
        while(i.hasNext()){
            courses cr = (courses) i.next();
            System.out.println(cr.i+cr.coursesname);
        }


        courses[] cr = {(courses) coursesToSelect.get(0),(courses) coursesToSelect.get(1)};
        coursesToSelect.removeAll(Arrays.asList(cr));
        Iterator j = coursesToSelect.iterator();
        while(j.hasNext()){
            courses crd = (courses) j.next();
            System.out.println(crd.i+crd.coursesname);
        }
    }


    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.add();
        System.out.println("");
        main.Get();
        System.out.println("");
        main.Modify();
        System.out.println("");
        main.Delete();
    }
}
