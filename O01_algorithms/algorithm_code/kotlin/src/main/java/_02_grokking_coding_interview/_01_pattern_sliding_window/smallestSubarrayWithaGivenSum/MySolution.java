package _02_grokking_coding_interview._01_pattern_sliding_window.smallestSubarrayWithaGivenSum;

public class MySolution {
    public static void main(String[] args) {
        System.out.println(findMinSizeSubArraySum(7, new int[]{2, 1, 5, 2, 3, 2})); //2
        System.out.println(findMinSizeSubArraySum(7, new int[]{2, 1, 5, 2, 8})); //1
        System.out.println(findMinSizeSubArraySum(8, new int[]{3, 4, 1, 1, 6})); //3
    }

    private static int findMinSizeSubArraySum(int maxValue, int[] arrays) {

        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int startWindow = 0;
        for (int endWindow = 0; endWindow < arrays.length; endWindow++) {
            sum += arrays[endWindow];
            while (sum >= maxValue) {
                minLength = Math.min(endWindow - startWindow + 1, minLength);
                sum -= arrays[startWindow];
                startWindow++;
//                System.out.println("minLength = " + minLength);
//                System.out.println("startWindow = " + startWindow);
//                System.out.println("endWindow = " + endWindow);
//                System.out.println("sum = " + sum);
            }
        }
        return minLength;
    }
}
