package _00_algorithm_testing_comapny._016_given_array_A_returns_the_minimum_number;

import java.util.*;

public class Solution {

    public static int solution(int[] A) {
        // Count the occurrences of each value in the array
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : A) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int moves = 0;
        for (int num : count.keySet()) {

            int occurrences = count.get(num);
            // Calculate the difference between the occurrences and the value itself
            int diff = Math.min(Math.abs(occurrences - num), Math.abs(occurrences));
            moves += diff;
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 1, 3, 4, 4, 4};
        System.out.println(solution(A1)); // Output: 3

        int[] A2 = {1, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(solution(A2)); // Output: 4

        int[] A3 = {1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4};
        System.out.println(solution(A3)); // Output: 5

        int[] A4 = {10, 10, 10};
        System.out.println(solution(A4)); // Output: 3
    }
}
