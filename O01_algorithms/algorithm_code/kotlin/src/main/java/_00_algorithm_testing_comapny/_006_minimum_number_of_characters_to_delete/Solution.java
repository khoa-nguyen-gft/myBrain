package O01_algorithms.O01_algorithms_006_minimum_number_of_characters_to_delete;

public class Solution {
    public static int solution(String s) {
        final char charA = 'A';
        int minDels = 0;
        int numberBs = 0;
        System.out.println(s);

        for (char c : s.toCharArray()) {
            if (c == charA) {
                minDels = Math.min(numberBs, minDels + 1);
            } else {
                numberBs++;
            }
        }
        return minDels;
    }

    public static void main(String[] args) {
        System.out.println(solution("BAAABAB")); //2
        System.out.println(solution("BBABAA")); //3
        System.out.println(solution("AABBBB")); //0
    }
}
