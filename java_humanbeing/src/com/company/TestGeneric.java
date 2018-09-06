package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mileygao on 4/14/17.
 */
public class TestGeneric {
    List<Courses> courseToselect = new ArrayList<Courses>();
    public void add(){
        Courses[] two = {new Courses("1","English"), new Courses("2","Math")};
        courseToselect.addAll(Arrays.asList(two));
        Courses temp = courseToselect.get(0);
        System.out.println(temp.num+temp.name);
    }
    public static void  main(String[] args){
        TestGeneric tg = new TestGeneric();
        tg.add();
    }
}
