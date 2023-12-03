package _01_hackerrank.sorting_043_Triangle;

import java.util.Arrays;

public class Solution {

    public static int solution(int[] A) {
        int length = A.length;
        System.out.println(Arrays.toString(A));
        if (length < 3) {
            return 0;
        }
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    int p = A[i];
                    int q = A[j];
                    int r = A[k];
                    if (p + q > r && p + r > q && q + r > p) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 10, 2, 5, 1, 8, 20 }));
    }
}
