package shashank.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    // leetcode 77
    public static void main(String[] args) {
        int a[] = {1, 2, 3};
        // ans -- > [1 2 3, 1 3 2, 2 1 3, 2 3 1, 3 1 2, 3 2 1 ]
        List<List<Integer>> answer = new ArrayList<>();
        permutation(a, 0, a.length, new ArrayList<>(), answer);
        System.out.println(answer);
    }

    private static void permutation(int a[], int start, int length, List<Integer> current, List<List<Integer>> answer) {

        if (current.size() == length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        int count = 0;
        for (int i = start; count < length; i = (i + 1)%length) {
            if(!current.contains(a[i])) {
                current.add(a[i]);
                permutation(a, (i + 1) % length, length, current, answer);
                current.remove(current.size() - 1);
            }
            count++;
        }
    }
}
