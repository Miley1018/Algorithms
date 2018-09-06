package com.company;

/**
 * Created by mileygao on 3/7/17.
 */
public class courses {
    String i;
    String coursesname;
    public courses(String i, String courses){
        this.i = i;
        this.coursesname = courses;
    }
    public courses(){

    }
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj == null){
            return false;
        }

        if (!(obj instanceof courses)){
            return false;
        }

        courses a = (courses)obj;
        if (this.coursesname==null){
            if (a.coursesname==null){
                return true;
            }else
                {return false;}
        }else{
            if (this.coursesname.equals(a.coursesname)){
                return true;
            }else {
                return false;
            }
        }
    }
}
