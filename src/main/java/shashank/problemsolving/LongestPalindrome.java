package shashank.problemsolving;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println("Result = " + longestPalindrome("cbbd"));
    }

    static int resLength;
    static int resStart;

    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;

        for (int i = 0; i < s.length(); i++) {
            checkForPalindome(s, i, i);
            checkForPalindome(s, i, i + 1);
        }

        return s.substring(resStart, resStart + resLength);


    }

    public static void checkForPalindome(String s, int start, int end) {

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        if (resLength < (end - start - 1)) {
            resLength = end - start - 1;
            resStart = start + 1;
        }

    }
}