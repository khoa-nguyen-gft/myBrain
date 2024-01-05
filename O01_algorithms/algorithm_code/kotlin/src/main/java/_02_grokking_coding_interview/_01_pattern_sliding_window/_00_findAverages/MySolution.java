package _02_grokking_coding_interview._01_pattern_sliding_window._00_findAverages;

import java.util.Arrays;

public class MySolution {
    public static void main(String[] args) {
        double[] result = findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println(Arrays.toString(result));
    }

    private static double[] findAverages(int k, int[] ints) {
        double[] result = new double[ints.length - k + 1];
        int startWindow = 0;
        int endWindow = k - 1;
        double sumWindow = 0;
        int resultIndex = 0;
        for (int i = startWindow; i <= endWindow; i++) {
            sumWindow += ints[i];
        }
        result[resultIndex] = sumWindow / k;

        for (startWindow = 0; startWindow < ints.length - k; startWindow++) {
            endWindow += 1;
            sumWindow -= ints[startWindow];
            sumWindow += ints[endWindow];

            System.out.println("startWindow:" + ints[startWindow]);
            System.out.println("endWindow:" + ints[endWindow]);
            System.out.println("sumWindow:" + sumWindow);

            resultIndex++;
            result[resultIndex] = sumWindow / k;
        }
        return result;
    }

}
