package com.company;

import java.util.*;

/**
 * Created by mileygao on 8/22/18.
 */
public class ZSolution {
    private static class Item {
        int qua;
        int wage;
        public Item(int qua, int wage) {
            this.qua = qua;
            this.wage = wage;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Item[] items = new Item[quality.length];
        for (int i = 0; i < quality.length; i++) {
            items[i] = new Item(quality[i], wage[i]);
        }
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return (o1.wage / o1.qua) - (o2.wage / o2.qua);
            }
        });
        PriorityQueue<Item> pq = new PriorityQueue<>(11, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.qua - o1.qua;
            }
        });
        int curSum = 0;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < items.length; i++) {
            if (i < K - 1) {
                pq.offer(items[i]);
                curSum += items[i].qua;
            } else {
                double sum = items[i].wage;
                int preSum = ((double)(items[i].wage / items[i].qua)) * curSum;
                sum += preSum;
                min = Math.min(min, sum);
                pq.offer(items[i]);
                curSum += items[i].qua;
                curSum -= pq.poll().qua;
            }
        }
        return min;
    }
/Users/mileygao/IdeaProjects/AlgorithmsReview0802/src/com/company/ZSolution.java

    public static void main(String [] args) {
        ZSolution zSolution = new ZSolution();
        int[] a = {3,1,10,10,1};
        int[] b = {4,8,2,2,7};
        System.out.println(zSolution.mincostToHireWorkers(a, b, 3));
    }

}
