package _02_grokking_coding_interview.pattern_sliding_window._01_patter_sliding_window.findAverages;

import java.util.Arrays;

public class Solution {

    private static double[] findAverages(int k, int[] ints) {
        double[] result = new double[ints.length - k + 1];
        int windowStart = 0;
        double windowSum = 0;

        for (int windowEnd = 0; windowEnd < ints.length; windowEnd++) {
            windowSum += ints[windowEnd];
            System.out.println("windowEnd = " + windowEnd);

            if (windowEnd >= k - 1) {
                System.out.println("windowSum = " + windowSum);
                System.out.println("windowStart = " + windowStart);
                System.out.println("windowEnd = " + windowEnd);
                System.out.println("------");
                result[windowStart] = windowSum / k;
                windowSum -= ints[windowStart++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double[] result = findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println(Arrays.toString(result));
    }
}
