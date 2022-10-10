package shashank.problemsolving;

import java.util.Arrays;

public class LargestNumber {
    // Leetcode - 179

    public static void main(String[] args) {

        /**
         * O/P: 654
         */
        System.out.println(largestNumber(new int[]{4, 5, 6}));
    }


    public static String largestNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));

        // An extreme edge case that you have only a bunch of 0 in your int array
        if (strs[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();

    }

}
