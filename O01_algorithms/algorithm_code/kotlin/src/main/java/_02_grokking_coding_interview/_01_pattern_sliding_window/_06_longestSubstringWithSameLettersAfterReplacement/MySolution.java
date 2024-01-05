package _02_grokking_coding_interview._01_pattern_sliding_window._06_longestSubstringWithSameLettersAfterReplacement;

import java.util.HashMap;
import java.util.Map;

public class MySolution {
    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2)); // 5
        System.out.println(findLength("abbcb", 1)); // 4
        System.out.println(findLength("abccde", 1)); // 3
    }

    static int findLength(String str, int k) {
        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int maxRepeatLetterCount = 0;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(rightChar));

//            System.out.println("windowEnd - windowStart + 1 - maxRepeatLetterCount = " + (windowEnd - windowStart + 1 - maxRepeatLetterCount));
//            System.out.println("windowEnd: " + windowEnd );
//            System.out.println("windowStart: " + windowStart );
//            System.out.println("maxRepeatLetterCount: " + maxRepeatLetterCount );
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
