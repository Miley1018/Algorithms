package com.company;
import java.util.*;
/**
 * Created by mileygao on 3/7/17.
 */
public class students {
    String id;
    String name;
    public Set<courses> courses;
    public students(String id, String name){
        this.id = id;
        this.name = name;
        this.courses = new HashSet<courses>();
    }
}
