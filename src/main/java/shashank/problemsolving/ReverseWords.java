package shashank.problemsolving;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("sky is blue"));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String words[] = s.split(" ");
        return Arrays.asList(words).stream()
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .collect(Collectors.joining(" "));
    }

}
