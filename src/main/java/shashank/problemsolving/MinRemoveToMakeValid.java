package shashank.problemsolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> positions = new ArrayList<>();
        for(int i=0; i< s.toCharArray().length;i++){
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                else{
                    positions.add(i);
                }
            }
        }
        while(!stack.isEmpty()) {
            positions.add(stack.pop());
        }
        positions.sort(Integer::compareTo);
        StringBuilder builder = new StringBuilder();
        for(int i=0 ; i < s.toCharArray().length; i++) {
            if(!positions.contains(Integer.valueOf(i))){
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
