package shashank.problemsolving;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberIII {

    public static int[] singleNumber(int[] nums) {

        // Leetcode - 260
        /*
        Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
        Find the two elements that appear only once. You can return the answer in any order.
        You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
         */

        int ans[] = new int[2];
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans[count++] = entry.getKey();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int a[] = singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(a[0] + " " + a[1]);
    }
}
