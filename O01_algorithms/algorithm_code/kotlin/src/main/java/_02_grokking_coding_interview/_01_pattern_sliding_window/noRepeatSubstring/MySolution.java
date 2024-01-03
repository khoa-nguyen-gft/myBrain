package _02_grokking_coding_interview._01_pattern_sliding_window.noRepeatSubstring;

import java.util.HashSet;
import java.util.Set;

public class MySolution {
    public static void main(String[] args) {
        System.out.println(NoRepeatSubstring.findLength("aabccbb")); //3
        System.out.println(NoRepeatSubstring.findLength("abbbb")); //2
        System.out.println(NoRepeatSubstring.findLength("abccde")); //3
    }
}

class NoRepeatSubstring {

    public static int findLength(String str) {
        int maxLength = 0;
        int startWindow = 0;
        Set<Character> set = new HashSet<>();
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightCharacter = str.charAt(endWindow);
            if (!set.contains(rightCharacter)) {
                set.add(rightCharacter);
                maxLength = Math.max(maxLength, endWindow - startWindow + 1);
            } else{
                startWindow = endWindow;
                set.clear();
            }

//            System.out.println("sub String: " + str.substring(startWindow, endWindow + 1));
//            System.out.println("set: " + set);
//            System.out.println("maxLength: " + maxLength);

        }
        return maxLength;
    }
}