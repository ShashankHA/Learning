package shashank.problemsolving;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        // leetcode 277
        // The idea is to calculate the *s and /s first, and use a stack to store all the operands for a final sum operation.
        String s = "4+5*5+2-2";
        System.out.println(solve(s));  // Answer should be 24
    }

    private static int solve(String s) {
        Stack<Integer> stack = new Stack<>();
        int currVal = 0;
        char currSign = '+';
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                currVal = currVal * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) || i == s.length() - 1) {
                if (currSign == '+') {
                    stack.push(currVal);
                } else if (currSign == '-') {
                    stack.push(-currVal);
                } else if (currSign == '*') {
                    stack.push(stack.pop() * currVal);
                } else if (currSign == '/') {
                    stack.push(stack.pop() / currVal);
                }
                currVal = 0;
                currSign = s.charAt(i);
            }
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
