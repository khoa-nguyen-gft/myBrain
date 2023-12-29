package _00_algorithm_testing_comapny._003_find_first_unique_number;

import java.util.HashMap;
import java.util.Map;

public class SolutionHint {
    public static int solution(int[] A) {
        Map<Integer, Integer> counter = new HashMap<>();

        // Count occurrences of each element in the array
        for (int num : A) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        // Find the first unique number in the array
        for (int num : A) {
            if (counter.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 10, 5, 4, 2, 10}));
        System.out.println(solution(new int[]{456, 7, 3, 2, 2, 2, 31}));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 4, 4}));

    }
}
