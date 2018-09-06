package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mileygao on 3/7/17.
 */
public class testFanxing {
    public List<courses> courseAll;
    testFanxing(){
        this.courseAll = new ArrayList<courses>();
    }

    public void Add(){
        courses[] cr = {new courses("4","Japan"), new courses("5","Korean")};
        courseAll.addAll(Arrays.asList(cr));
        for (courses c : courseAll){
            System.out.println(c.i+c.coursesname);
        }

    }

    public void AddChild(){
        courseChild cc= new courseChild();// why not ("6","")
        cc.i="6";
        cc.coursesname="America";
        System.out.println(cc.i+cc.coursesname);
    }

    public static void main(String[] args){
        testFanxing tf = new testFanxing();
        tf.Add();
        tf.AddChild();

    }


}
