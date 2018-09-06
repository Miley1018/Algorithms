package com.company;

/**
 * Created by mileygao on 4/14/17.
 */
public class Courses implements Comparable<Courses>{
    String num;
    String name;
    public Courses(String num, String name){
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return num+": "+name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){return true;}
        if (obj == null){return false;}
        if (! (obj instanceof Courses)){return false;}
        Courses cr = (Courses)obj;
        if (this.name == null){
            if (cr.name == null){
                return true;
            }else{
                return false;
            }
        }else{
            if (this.name.equals((cr.name)))
            {
            return true;
            } else{
            return false;}
        }
    }

    @Override
    public int compareTo(Courses o) {
        return this.num.compareTo(o.num);
    }
}
