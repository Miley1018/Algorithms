package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/28/18.
 */
public class ZKnapSack02 {
    public int maxWeight(int[] weights, int w) {
        if (weights == null || weights.length == 0 || w <= 0) {
            return 0;
        }
        int[] M = new int[w + 1];
        int[] temp;
        for (int i = 0; i < weights.length; i++) {
            temp = M;
            for (int wi = 0; wi <= w; wi++) {
                if (wi == 0) {
                    M[wi] = 0;
                } else {
                    M[wi] = temp[wi];
                    if (wi >= weights[i]) {
                        M[wi] = Math.max(wi + temp[wi - weights[i]], M[wi]);
                    }
                }
            }
        }
        return M[w];
    }
    public static void main(String[] args) {
        ZKnapSack02 knapSack02 = new ZKnapSack02();
        int[] weights = {2, 5, 3};
        int[] values = {4, 3};
        int[] weights1 = {3, 4};
        int[] values1 = {0, 1, 3};
        List<int[]> weightsGroups = new ArrayList<>();
        weightsGroups.add(weights);
        weightsGroups.add(weights1);
        List<int[]> valuesGroups = new ArrayList<>();
        valuesGroups.add(values);
        valuesGroups.add(values1);
        System.out.println(knapSack02.maxWeight(weights, 6));
        //System.out.println(knapSack01.groupMaxValue(weightsGroups, valuesGroups, 4));
    }
}
