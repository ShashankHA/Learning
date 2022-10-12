package shashank.problemsolving;

import java.util.*;

public class SubArrayWithSum {
    public static void main(String[] args) {
        // leetcode - 560 - Subarray with sum k
        int a[] = {2, 3, 4, 1, 4, 3, 2};
        int sum = 9;

        System.out.println(findSubArrays(a, sum));
    }

    public static int findSubArrays(int[] a, int k) {
        int cumulativeCount = 0;
        int cumulativeSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int value : a) {
            cumulativeSum += value;
            if (map.containsKey(cumulativeSum - k)) {
                cumulativeCount += map.get(cumulativeSum - k);
            }

            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }

        return cumulativeCount;

    }

}
