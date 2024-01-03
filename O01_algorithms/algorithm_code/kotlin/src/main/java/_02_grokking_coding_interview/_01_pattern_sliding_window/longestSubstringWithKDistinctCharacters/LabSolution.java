package _02_grokking_coding_interview._01_pattern_sliding_window.longestSubstringWithKDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

public class LabSolution {
    public static void main(String[] args) {
        System.out.println(LongestSubstringWithKDistinctCharactersLab.findLength("araaci", 2)); //4
        System.out.println(LongestSubstringWithKDistinctCharactersLab.findLength("araaci", 1)); //2
        System.out.println(LongestSubstringWithKDistinctCharactersLab.findLength("cbbebi", 3)); //5
    }
}

class LongestSubstringWithKDistinctCharactersLab {
    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException();
        }

        int startWindow = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightChar = str.charAt(endWindow);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            if (map.size() > k) {
                char leftChar = str.charAt(startWindow);
                startWindow++;
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
            }

            maxLength = Math.max(maxLength, endWindow - startWindow + 1);

            System.out.println(map);
        }

        return maxLength;
    }
}