package shashank.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    // leetcode 77
    public static void main(String[] args) {
        int a[] = {1, 2, 3,4};
        int n = 4;
        int k = 2;
        // return all 2 letter combinations
        // ans -- > [1 2, 1 3, 1 4, 2 3, 2 4, 3 4]
        List<List<Integer>> answer = new ArrayList<>();
        combination(a, 0, k, new ArrayList<>(), answer);
        System.out.println(answer);
    }

    private static void combination(int a[], int start, int length, List<Integer> current, List<List<Integer>> answer) {

        if (current.size() == length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < a.length; i = i + 1) {
            current.add(a[i]);
            combination(a, i + 1, length, current, answer);
            current.remove(current.size() - 1);
        }
    }
}
