package O01_algorithms.O01_algorithms_014_two_strings_S_and_T_consisting;

public class Solution {
    public static String solution(String S, String T) {
        int n = S.length();
        int m = T.length();

        // Case: Equality
        if (S.equals(T)) {
            return "EQUAL";
        }

        // Case: Insertion
        if (n + 1 == m && T.endsWith(S)) {
            return "INSERT " + T.charAt(0);
        }

        // Case: Removal
        if (n - 1 == m && S.startsWith(T)) {
            return "REMOVE " + S.charAt(n - 1);
        }

        // Case: Swap
        if (n == m) {
            int mismatchCount = 0;
            char firstMismatchS = '\0';
            char firstMismatchT = '\0';

            for (int i = 0; i < n; i++) {
                if (S.charAt(i) != T.charAt(i)) {
                    mismatchCount++;
                    if (mismatchCount == 1) {
                        firstMismatchS = S.charAt(i);
                        firstMismatchT = T.charAt(i);
                    } else if (mismatchCount > 2) {
                        break; // More than one mismatch, cannot be swapped.
                    }
                }
            }
            if (mismatchCount == 2 && firstMismatchS == T.charAt(S.indexOf(firstMismatchT)) && firstMismatchT == S.charAt(T.indexOf(firstMismatchS))) {
                return "SWAP " + firstMismatchS + " " + firstMismatchT;
            }
        }

        // No possible operation
        return "IMPOSSIBLE";
    }


    public static void main(String[] args) {
        System.out.println(solution("gain", "again")); // Output: "INSERT a"
        System.out.println(solution("parks", "park")); // Output: "REMOVE s"
        System.out.println(solution("form", "from")); // Output: "SWAP o r"
        System.out.println(solution("form", "form")); // Output: "EQUAL"
        System.out.println(solution("fift", "fifth")); // Output: "IMPOSSIBLE"
        System.out.println(solution("o", "odd")); // Output: "IMPOSSIBLE"
    }
}
