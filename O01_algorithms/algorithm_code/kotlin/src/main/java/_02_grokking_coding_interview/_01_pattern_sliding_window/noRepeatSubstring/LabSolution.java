package _02_grokking_coding_interview._01_pattern_sliding_window.noRepeatSubstring;

import java.util.HashMap;
import java.util.Map;

public class LabSolution {
    public static void main(String[] args) {
        System.out.println(LabNoRepeatSubstring.findLength("aabccbb")); //3
        System.out.println(LabNoRepeatSubstring.findLength("abbbb")); //2
        System.out.println(LabNoRepeatSubstring.findLength("abccde")); //3
    }
}

class LabNoRepeatSubstring {
    public static int findLength(String str) {
        int maxLength = 0;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            char rightChar = str.charAt(windowEnd);

            System.out.println("map: " + map);
            System.out.println("windowStart: " + windowStart);
            System.out.println("windowEnd: " + windowEnd);
            System.out.println("rightChar: " + rightChar);

            if (map.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, map.get(rightChar) + 1);
            }
            map.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}