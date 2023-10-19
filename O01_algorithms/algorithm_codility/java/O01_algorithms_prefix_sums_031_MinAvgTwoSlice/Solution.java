package O01_algorithms.O01_algorithms_031_prefix_sums_MinAvgTwoSlice;

import java.util.Arrays;

public class Solution {

    public static int solution(int[] A) {
        var startingPosition = 0;
        double minAvg = Integer.MAX_VALUE;

        System.out.println(Arrays.toString(A));
        if (A.length == 0) return 0;
        if (A.length == 1) return A[0];

        var length = A.length;
        for (int i = 2; i <= 3; i++) {
            for (int j = 0; j < length; j++) {
                if (j + i <= length) {
                    int[] subArrays = Arrays.copyOfRange(A, j, j + i);
                    double avg = Arrays.stream(subArrays).sum() * (1.0) / subArrays.length;
                    if (minAvg > avg) {
                        minAvg = avg;
                        startingPosition = j;
                        System.out.println("subArrays: " + Arrays.toString(subArrays) + " minAvg: " + minAvg +  " avg " + avg + " startingPosition: " + startingPosition + " i: " + i);
                    }
                }
            }
        }
        return startingPosition;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 2, 2, 5, 1, 5, 8})); //1
        System.out.println(solution(new int[]{10, 10, -1, 2, 4, -1, 2, -1})); //5
        System.out.println(solution(new int[]{-3, -5, -8, -4, -10})); //2
        System.out.println(solution(new int[]{-3, -3, 10, -10, 10, -10, 10, -10, 10, -3, -3, 100, -11})); //3
    }
}


