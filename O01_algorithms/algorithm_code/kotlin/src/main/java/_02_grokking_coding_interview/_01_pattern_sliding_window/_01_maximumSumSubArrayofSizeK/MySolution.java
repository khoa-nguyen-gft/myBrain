package _02_grokking_coding_interview._01_pattern_sliding_window._01_maximumSumSubArrayofSizeK;

public class MySolution {
    public static void main(String[] args) {
        System.out.println(MaxSumSubArraySizeK.MaxSumSubArraySize(3, new int[]{2, 1, 5, 1, 3, 2})); //9
        System.out.println(MaxSumSubArraySizeK.MaxSumSubArraySize(2, new int[]{2, 3, 4, 1, 5})); //7

    }
}


class MaxSumSubArraySizeK {
    public static int MaxSumSubArraySize(int k, int[] array) {
        int sum = 0;
        int maxSum = 0;
        int startWindow = 0;
        for (int endWindow = 0; endWindow < array.length; endWindow++) {

            if (endWindow < k) {
                sum += array[endWindow];
            } else {
                maxSum = Math.max(maxSum, sum);
                sum += array[endWindow];
                sum -= array[startWindow];
                startWindow++;
            }
        }
        return maxSum;
    }
}