package O01_algorithms.O01_algorithms_002_find_a_pair_of_char_in_string_array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SolutionHint {
     public static int[] solution(String[] S) {
        int N = S.length;
        int M = S[0].length();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (S[i].charAt(k) == S[j].charAt(k)) {
                        return new int[]{i, j, k};
                    }
                }
            }
        }
        return new int[]{};
    }

        public static void main(String[] args) {
        System.out.println(
                Arrays.stream(solution(new String[] { "abc", "bca", "dbe" })).boxed().collect(Collectors.toList())); //[0, 2, 1]
        System.out.println(
                Arrays.stream(solution(new String[] {"zzzz", "ferz", "zdsr", "fgtd"})).boxed().collect(Collectors.toList())); //[0, 1, 3]
        System.out.println(
                Arrays.stream(solution(new String[] { "gr", "sd", "rg"})).boxed().collect(Collectors.toList())); //[]
       System.out.println(
                Arrays.stream(solution(new String[] { "bdafg", "ceagi"})).boxed().collect(Collectors.toList())); //[0, 1, 2]
    }
}
