package shashank.problemsolving;

import java.util.Stack;

public class ValidParenthesis {

    // Leetcode 20

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }


    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()) {
            if(!stack.isEmpty()){
                Character top = stack.peek();
                if( top == oppositeOf(c)){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }

        return stack.isEmpty();

    }

    private static Character oppositeOf(Character c) {

        if(c == ')') {
            return '(';
        }

        if(c == '}') {
            return '{';
        }

        if(c == ']') {
            return '[';
        }
        return null;
    }
}
