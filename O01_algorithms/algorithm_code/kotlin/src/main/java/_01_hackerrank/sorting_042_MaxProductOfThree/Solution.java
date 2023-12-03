package _01_hackerrank.sorting_042_MaxProductOfThree;

import java.util.Arrays;

public class Solution {
    public static int solution(int[] A) {
        // System.out.println(Arrays.toString(A));
        int length = A.length;
        if (length < 3) {
            int n = 1;
            for (int i = 0; i < length; i++) {
                n *= A[i];
            }
            return n;
        }

        int[] B = Arrays.stream(A).sorted().toArray();
        // System.out.println(Arrays.toString(B));

        return Math.max(B[length - 1] * B[length - 2] * B[length - 3], B[0] * B[1] *B[length -1]);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { -3, 1, 2, -2, 5, 6 }));
        System.out.println(solution(new int[] { 4, 7, 3, 2, 1, -3, -5 }));
    }
}
