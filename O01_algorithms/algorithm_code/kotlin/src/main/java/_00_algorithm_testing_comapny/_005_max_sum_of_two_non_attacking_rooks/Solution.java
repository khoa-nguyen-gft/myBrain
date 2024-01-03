package _00_algorithm_testing_comapny._005_max_sum_of_two_non_attacking_rooks;

public class Solution {
    public static int solution(int[][] A) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            var row = A[i];
            for (int j = 0; j < row.length; j++) {
                var currentItem = A[i][j];
                var nextValue = nextValue(i, j, A);
                if (maxValue < currentItem + nextValue) {
                    maxValue = currentItem + nextValue;
                }
                System.out.print("currentItem: " + currentItem);
                System.out.print(" maxValue: " + maxValue);

            }
            System.out.println("");
        }
        return maxValue;
    }

    public static int nextValue(int row, int column, int[][] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (row != i) {
                for (int j = 0; j < A[i].length; j++) {
                    if (column != j && A[i][j] > max) {
                        max = A[i][j];
                    }
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 4}, {2, 3}}));//6
        System.out.println(solution(new int[][]{{15, 1, 5}, {16, 3, 8}, {2, 6, 4}}));//23
        System.out.println(solution(new int[][]{{12, 12}, {12, 12}, {0, 7}}));//24
        System.out.println(solution(new int[][]{{1, 2, 14}, {8, 3, 15}}));//22
    }
}
