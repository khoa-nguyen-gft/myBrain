package _02_grokking_coding_interview._01_pattern_sliding_window._06_longestSubstringWithSameLettersAfterReplacement;

import java.util.HashMap;
import java.util.Map;

public class LabSolution {
    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2)); // 5
        System.out.println(findLength("abbcb", 1)); // 4
        System.out.println(findLength("abccde", 1)); // 3
    }

    static int findLength(String str, int k) {
        int startWindow = 0;
        int maxLength = Integer.MIN_VALUE;
        int maxRepeatLetterCount = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightChar = str.charAt(endWindow);
            char leftChar = str.charAt(startWindow);

            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(rightChar));

            if (endWindow - startWindow + 1 - maxRepeatLetterCount > k) {
                map.put(leftChar, map.get(leftChar) - 1);
                startWindow++;
            }
            maxLength = Math.max(maxLength, endWindow - startWindow + 1);
        }

        return maxLength;
    }
}
