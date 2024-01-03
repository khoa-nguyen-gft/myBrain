package _02_grokking_coding_interview._01_pattern_sliding_window.longestSubstringWithKDistinctCharacters;

import java.util.HashSet;
import java.util.Set;

public class MySolution {
    public static void main(String[] args) {
        System.out.println(LongestSubstringWithKDistinctCharacters.findLength("araaci", 2)); //4
        System.out.println(LongestSubstringWithKDistinctCharacters.findLength("araaci", 1)); //2
        System.out.println(LongestSubstringWithKDistinctCharacters.findLength("cbbebi", 3)); //5
    }
}

class LongestSubstringWithKDistinctCharacters {
    public static int findLength(String str, int size) {

        Set<Character> set = new HashSet<>();
        int startWindow = 0;
        int maxLength = 0;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            set.add(str.charAt(windowEnd));

            if (set.size() > size) {
                maxLength = Math.max(maxLength, windowEnd - startWindow + 1) -1;
                set.remove(str.charAt(startWindow));
                startWindow++;
            }

            System.out.println("sub String: " + str.substring(startWindow, windowEnd + 1));
            System.out.println("set: " + set);
            System.out.println("maxLength: " + maxLength);


        }


        return maxLength;
    }
}