package com.company;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mileygao on 4/14/17.
 */
public class Students {
    String id;
    String name;
    Set<Courses> courses;
    public Students(String id, String name){
        this.id = id;
        this.name = name;
        this.courses = new HashSet<Courses>();
    }


}
