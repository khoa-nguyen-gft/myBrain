import java.util.Arrays;

public class SolutionHint {
    public static int solution(int[] A) {
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int length = A.length;

        for (int i = 0; i < length - 2; i++) {
            if ((long)A[i] + A[i + 1] > A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 10, 2, 5, 1, 8, 20 }));
        System.out.println(solution(new int[] { 2147483647, 2147483647, 2147483647 }));
    }
}
