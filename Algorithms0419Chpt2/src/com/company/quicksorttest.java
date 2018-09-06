package com.company;
import java.util.*;

/**
 * Created by mileygao on 6/5/17.
 */
public class quicksorttest {
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        if (intervals == null ||intervals.length ==0||intervals.length ==1){
            result[0]=-1;
            return result;
        }
        Map map = new HashMap<>();
        for (int i = 0; i <intervals.length;i++){
            map.put(intervals[i].start,i);
        }
        sort(intervals);
        for (int i = 0; i <intervals.length;i++){
            int j = search(intervals,intervals[i].end,i,intervals.length-1);
            if (j<=intervals.length-1){
                result[(Integer) map.get(intervals[i].start)] = (Integer) map.get(intervals[j].start);
            }else{
                result[(Integer) map.get(intervals[i].start)] = -1;
            }
        }
        return result;
    }
    public int search(Interval[] intervals, int num, int lo, int hi){
        if (lo>hi){
            return lo;
        }
        int mid = (lo+hi)/2;
        if (intervals[mid].start == num){
            return mid;
        }else if (intervals[mid].start > num){
            return search(intervals,num,lo,mid-1);
        }else{
            return search(intervals,num,mid+1,hi);
        }
    }
    public void sort(Interval[] intervals){
        sort(intervals,0,intervals.length-1);
    }
    public void sort(Interval[] intervals,int lo, int hi){
        if (lo>=hi){
            return;
        }
        int i = partition2(intervals,lo,hi);
        sort(intervals,lo,i-1);
        sort(intervals,i+1,hi);
    }
    public int partition2(Interval[] intervals,int lo, int hi){
        Interval v = intervals[lo];
        int i = lo;
        int j = hi+1;
        while (i<j){
            while (intervals[++i].start<v.start){
                if (i==hi){
                    break;
                }
            }
            while (intervals[--j].start>v.start){}
            if(i>=j){
                break;
            }
            exch2(intervals,i,j);
        }
        exch2(intervals,lo,j);
        return j;
    }
    public void exch2(Interval[] intervals, int i, int j){
        Interval t = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = t;
    }
    public static void main(String[] args){
        quicksorttest a  = new quicksorttest();
        Interval[] b = {new Interval(0,1),new Interval(2,3),new Interval(1,2)};
        //a.sort(b);
        Arrays.sort(b, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                Integer a1 = o1.start;
                return a1.compareTo(o2.start);
            }
        });
        for(Interval i:b){
            System.out.println(i.start);
        }
        /*for (int i:a.findRightInterval(b)) {
            System.out.println(i);
        }*/
    }
}
