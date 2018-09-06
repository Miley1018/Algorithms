package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/14/18.
 */
public class ZKnapSack01 {
    public int maxWeight01(int[] weights, int W) {
        if (weights == null || weights.length == 0 || W < 1) {
            return 0;
        }
        int[] M = new int[W + 1];
        int[] temp = new int[W + 1];
        for (int i = 0; i <= weights.length; i ++) {
            temp = M;
            M = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                if (w == 0 || i == 0) {
                    M[w] = 0;
                } else {
                    M[w] = Math.max(w >= weights[i - 1] ? (temp[w - weights[i - 1]] + weights[i - 1]) : temp[w], temp[w]);
                }
            }
        }
        return M[W];
    }
    public int maxWeight01FollowUpExactlyWays(int[] weights, int W) {
        if (weights == null || weights.length == 0 || W < 1) {
            return 0;
        }
        int[] M = new int[W + 1];
        int[] temp = new int[W + 1];
        for (int i = 0; i <= weights.length; i ++) {
            temp = M;
            M = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                if (w == 0) {
                    M[w] = 1;
                } else if (i == 0) {
                    M[w] = 0;
                } else {
                    M[w] = (w >= weights[i - 1] ? temp[w - weights[i - 1]] : 0) + temp[w];
                }
            }
        }
        return M[W];
    }
    public int maxWeightUnbounded(int[] weights, int W) {
        if (weights == null || weights.length == 0 || W < 1) {
            return 0;
        }
        int[][] M = new int[W + 1][weights.length + 1];
        for (int w = 0; w <= W; w ++) {
            for (int i = 0; i <= weights.length; i ++) {
                if (w == 0 || i == 0) {
                    M[w][i] = 0;
                } else {
                    int max = 0;
                    for (int k = 0; k <= w / weights[i - 1]; k ++) {
                        max = Math.max(max, M[w - k * weights[i - 1]][i - 1] + k * weights[i - 1]);
                    }
                    M[w][i] = max;
                }
            }
        }
        return M[W][weights.length];
    }
    public int exactlyWaysUnbounded(int[] weights, int W) {
        if (weights == null || weights.length == 0 || W < 1) {
            return 0;
        }
        int[][] M = new int[W + 1][weights.length + 1];
        for (int w = 0; w <= W; w ++) {
            for (int i = 0; i <= weights.length; i ++) {
                if (w == 0) {
                    M[w][i] = 1;
                }

                else if (i == 0) {
                    M[w][i] = 0;
                } else {
                    int cnt = 0;
                    for (int k = 0; k <= w / weights[i - 1]; k ++) {
                        cnt += M[w - k * weights[i - 1]][i - 1];
                    }
                    M[w][i] = cnt;
                }
            }
        }
        return M[W][weights.length];
    }

    public int minimumExactlyFilled01(int[] weights, int W) {
        if (weights == null || weights.length == 0 || W < 1) {
            return 0;
        }
        int[] M = new int[W + 1];
        int[] temp = new int[W + 1];
        for (int i = 0; i <= weights.length; i ++) {
            temp = M;
            M = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                if (w == 0) {
                    M[w] = 0;
                } else if (i == 0) {
                    M[w] = Integer.MAX_VALUE;
                } else {
                    M[w] = Math.min((w >= weights[i - 1] ? (temp[w - weights[i - 1]] ==  Integer.MAX_VALUE ? Integer.MAX_VALUE : temp[w - weights[i - 1]] + 1): Integer.MAX_VALUE), temp[w]);
                }
            }
        }
        return M[W];
    }

    public int classic01MaxValue(int[] weights, int[] values, int W) {
        if (weights == null || weights.length == 0 || W < 1) {
            return 0;
        }
        int[] M = new int[W + 1];
        int[] temp = new int[W + 1];
        for (int i = 0; i <= weights.length; i ++) {
            temp = M;
            M = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                if (w == 0) {
                    M[w] = 0;
                } else if (i == 0) {
                    M[w] = 0;  // ------------------------?? base case? w == 0? /Integer.MIN_VALUE
                } else {
                    M[w] = Math.max((w >= weights[i - 1] ? (temp[w - weights[i - 1]] + values[i - 1]): 0), temp[w]);
                }
            }
        }
        return M[W];
    }

    public int classic01MaxValueUnbounded(int[] weights, int[] values, int W) {
        if (weights == null || weights.length == 0 || W < 1) {
            return 0;
        }
        int[] M = new int[W + 1];
        int[] temp = new int[W + 1];
        for (int i = 0; i <= weights.length; i ++) {
            temp = M;
            M = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                if (w == 0) {
                    M[w] = 0;
                } else if (i == 0) {
                    M[w] = 0;  // ------------------------?? base case? w == 0? /Integer.MIN_VALUE
                } else {
                    int max = -1;
                    for (int k = 0; k <= (weights[i - 1] == 0? 0 : w / weights[i - 1]); k ++) {
                        max = Math.max(max, temp[w - k * weights[i - 1]] + k * values[i - 1]);
                    }
                    M[w] = max;
                }
            }
        }
        return M[W];
    }
    public int classic01MaxValueUnbounded2(int[] weights, int[] values, int W) {
        if (weights == null || weights.length == 0 || W < 1) {
            return 0;
        }
        int[] Cur = new int[W + 1];
        int[] Prev = new int[W + 1];
        for (int i = 0; i <= weights.length; i ++) {
            Prev = Cur;
            Cur = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                if (w == 0) {
                    Cur[w] = 0;
                } else if (i == 0) {
                    Cur[w] = 0;  // ------------------------?? base case? w == 0? /Integer.MIN_VALUE
                } else {
                    Cur[w] = Math.max(Prev[w], (w >= weights[i - 1] ? Cur[w - weights[i - 1]] + values[i - 1] : Prev[w]));
                }
            }
        }
        return Cur[W];
    } // space ???????????????????/

    public int groupMaxValue(List<int[]> weights, List<int[]> values, int W) {
        if (weights == null || weights.size() == 0 || W < 1) {
            return 0;
        }
        int[] Cur = new int[W + 1];
        int[] temp = new int[W + 1];
        for (int i = 0; i <= weights.size(); i ++) {
            temp = Cur;
            Cur = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                if (w == 0 || i == 0) {
                    Cur[w] = 0;
                } else {
                    int max = temp[w];
                    for (int m = 0; m < weights.get(i - 1).length; m ++) {
                        max = Math.max(max,  (w >= weights.get(i - 1)[m] ? temp[w - weights.get(i - 1)[m]] + values.get(i - 1)[m] : 0));
                    }
                    Cur[w] = max;
                }
            }
        }
        return Cur[W];
    }

    public int Knap2DWeight(int[] weights1, int[] weights2, int[] values, int W1, int W2) {
        if (weights1 == null || weights1.length == 0 || W1 < 1 || W2 < 1) {
            return 0;
        }
        int[][] Cur = new int[W1 + 1][W2 + 1];
        int[][] temp = new int[W1 + 1][W2 + 1];
        for (int i = 0; i < values.length; i ++) {
            temp = Cur;
            Cur = new int[W1 + 1][W2 + 1];
            for (int w1 = 0; w1 <= W1; w1++) {
                for (int w2 = 0; w2 <= W2; w2 ++) {
                    if (w1 == 0 || w2 == 0 || i == 0) {
                        Cur[w1][w2] = 0;
                    } else {
                        int valueWithCur = w1 >= weights1[i] && w2 >= weights2[i] ? temp[w1 - weights1[i]][w2 - weights2[i]] + values[i] : 0;
                        Cur[w1][w2] = Math.max(valueWithCur, temp[w1][w2]);
                    }
                }
            }
        }
        return Cur[W1][W2];
    }

    public int Knap2DMItems(int[] weights1, int[] values, int W, int M) {
        if (weights1 == null || weights1.length == 0 || W < 1 || M < 1) {
            return 0;
        }
        int[][] Cur = new int[M + 1][W + 1];
        int[][] pre = new int[M + 1][W + 1];
        int[][] temp;
        for (int i = 0; i < values.length; i ++) {
            temp = pre;
            pre = Cur;
            Cur = temp;
            for (int w = 0; w <= W; w++) {
                for (int m = 0; m <= M; m ++) {
                    if (w == 0 || m == 0 || i == 0) {
                        Cur[w][m] = 0;
                    } else {
                        int valueWithCur = w >= weights1[i] && m >= 1 ? pre[w - weights1[i]][m - 1] + values[i] : 0;
                        Cur[w][m] = Math.max(valueWithCur, pre[w][m]);
                    }
                }
            }
        }
        return Cur[W][M];
    }
    public static void main(String[] args) {
        ZKnapSack01 knapSack01 = new ZKnapSack01();
        int[] weights = {2, 5};
        int[] values = {4, 3};
        int[] weights1 = {3, 4};
        int[] values1 = {0, 1, 3};
        List<int[]> weightsGroups = new ArrayList<>();
        weightsGroups.add(weights);
        weightsGroups.add(weights1);
        List<int[]> valuesGroups = new ArrayList<>();
        valuesGroups.add(values);
        valuesGroups.add(values1);
        System.out.println(knapSack01.Knap2DMItems(weights, values, 7, 6));
        //System.out.println(knapSack01.groupMaxValue(weightsGroups, valuesGroups, 4));
    }
}
