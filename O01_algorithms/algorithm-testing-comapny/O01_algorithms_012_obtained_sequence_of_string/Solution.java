package O01_algorithms.O01_algorithms_012_obtained_sequence_of_string;

public class Solution {

    public static int solution(String s) {
        int count = 0;

        if (s == null || s.isEmpty()) {
            return 0; // Handle empty or null input string
        }

        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                count++;
            }
            s = swap(s);
        }
        return count;
    }

    public static String swap(String s) {
        return s.substring(1) + s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(solution("abbaa")); //3
    }
}
