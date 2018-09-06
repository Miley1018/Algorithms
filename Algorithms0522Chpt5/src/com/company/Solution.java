package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mileygao on 6/8/17.
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        int t;
        List<Integer> list=new ArrayList<>();
        if (nums==null){
            return null;
        }
        if (nums.length==1||nums.length==0){
            return list;
        }
        int p ;
        while (i<=nums.length-1){
            if (nums[i]<=0){
                i++;
                continue;
            }
            t = nums[nums[i]-1];
            if (i==nums[i]-1){
                nums[i++] = -1;
                continue;
            }
            if(t==-1){
                nums[nums[i]-1] = 0;
                nums[i]=-2;
                i++;
                continue;
            }
            nums[nums[i]-1]=-1;
            nums[i] = t;
        }
        for (int m = 0; m<nums.length;m++){
            if (nums[m]==0){
                list.add(m+1);
            }
        }
        return list;
    }
    public static void main(String[] args){
        int[] a = {1,1};
        Solution solution = new Solution();
        System.out.println(solution.findDuplicates(a));
    }
}