package _00_algorithm_testing_comapny._005_max_sum_of_two_non_attacking_rooks;

public class SolutionHit {
    public static int solution(int[][] A) {
        int maxValue = Integer.MIN_VALUE;
        int rows = A.length;
        int columns = A[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int currentItem = A[i][j];
                int nextValue = findNextValue(i, j, A);

                int currentSum = currentItem + nextValue;
                if (currentSum > maxValue) {
                    maxValue = currentSum;
                }
            }
        }

        return maxValue;
    }

    public static int findNextValue(int row, int column, int[][] A) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (i != row) {
                for (int j = 0; j < A[i].length; j++) {
                    if (j != column && A[i][j] > max) {
                        max = A[i][j];
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] testCase1 = { { 1, 4 }, { 2, 3 } };
        int[][] testCase2 = { { 15, 1, 5 }, { 16, 3, 8 }, { 2, 6, 4 } };
        int[][] testCase3 = { { 12, 12 }, { 12, 12 }, { 0, 7 } };
        int[][] testCase4 = { { 1, 2, 14 }, { 8, 3, 15 } };

        System.out.println(solution(testCase1)); // Expected output: 6
        System.out.println(solution(testCase2)); // Expected output: 23
        System.out.println(solution(testCase3)); // Expected output: 24
        System.out.println(solution(testCase4)); // Expected output: 22
    }
}
