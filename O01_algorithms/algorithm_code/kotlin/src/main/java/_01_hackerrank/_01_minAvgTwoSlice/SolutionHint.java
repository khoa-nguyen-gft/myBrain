package _01_hackerrank._01_minAvgTwoSlice;

class SolutionHint {
    public static int solution(int[] A) {
        int startingPosition = 0;
        double minAvg = (A[0] + A[1]) / 2.0;

        for (int i = 2; i < A.length; i++) {
            double avg2 = (A[i - 1] + A[i]) / 2.0;
            double avg3 = (A[i - 2] + A[i - 1] + A[i]) / 3.0;

            double currentMinAvg = Math.min(avg2, avg3);

            if (currentMinAvg < minAvg) {
                minAvg = currentMinAvg;
                startingPosition = minAvg == avg2 ? i - 1 : i - 2;
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

