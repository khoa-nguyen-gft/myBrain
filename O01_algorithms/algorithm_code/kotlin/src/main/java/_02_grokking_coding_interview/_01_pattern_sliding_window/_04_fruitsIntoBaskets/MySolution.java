package _02_grokking_coding_interview._01_pattern_sliding_window._04_fruitsIntoBaskets;

import java.util.HashMap;
import java.util.Map;

public class MySolution {
    public static void main(String[] args) {
        System.out.println(FruitsIntoBaskets.findLength(new char[]{'A', 'B', 'C', 'A', 'C'})); //3
        System.out.println(FruitsIntoBaskets.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'})); //5
    }
}

class FruitsIntoBaskets {

    public static int findLength(char[] chars) {
        int startWindow = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int endWindow = 0; endWindow < chars.length; endWindow++) {
            char rightChar = chars[endWindow];
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.size() > 2) {
                char leftChar = chars[startWindow];
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                startWindow++;
            }
            maxLength = Math.max(maxLength, endWindow - startWindow + 1);
        }

        System.out.println(map);

        return maxLength;
    }
}