package _00_algorithm_testing_comapny._002_find_a_pair_of_char_in_string_array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static int[] solution(String[] S) {
        int SLength = S.length;
        int SSize = S[0].length();
        for (int i = 0; i < SLength; i++) {
            for (int j = i + 1; j < SLength; j++) {
                System.out.println("A: " + S[i] + " B: " + S[j]);
                String firstItem = S[i];
                String secondItem = S[j];
                for (int k = 0; k < SSize; k++) {
                    System.out.println(" " + firstItem.charAt(k) + " == " + secondItem.charAt(k));
                    if (firstItem.charAt(k) == secondItem.charAt(k)) {
                        return new int[]{i, j, k};
                    }
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.stream(solution(new String[]{"abc", "bca", "dbe"})).boxed().collect(Collectors.toList())); //[0, 2, 1]
        System.out.println(
                Arrays.stream(solution(new String[] {"zzzz", "ferz", "zdsr", "fgtd"})).boxed().collect(Collectors.toList())); //[0, 1, 3]
        System.out.println(
                Arrays.stream(solution(new String[] { "gr", "sd", "rg"})).boxed().collect(Collectors.toList())); //[]
        System.out.println(
                Arrays.stream(solution(new String[] { "bdafg", "ceagi"})).boxed().collect(Collectors.toList())); //[0, 1, 2]
    }
}
