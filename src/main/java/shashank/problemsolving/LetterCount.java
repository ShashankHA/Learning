package shashank.problemsolving;

public class LetterCount {
    public static void main(String[] args) {
        System.out.println(calculateCount("AAAAABBCCAA"));   // should print A5B2C2A2
    }

    public static String calculateCount(String input) {
        char prev = input.charAt(0);
        int count = 1;
        StringBuilder builder = new StringBuilder();

        if(input == null ) {
            return null;
        }

        if(input.length() == 1) {
            return "1"+input;
        }

        for(char c : input.substring(1).toCharArray()) {
            if(c == prev) {
                count++;
            }
            else {
                builder.append(prev+""+count);
                count = 1;
            }
            prev = c;
        }
        builder.append(prev+""+count);
        return builder.toString();
    }

}