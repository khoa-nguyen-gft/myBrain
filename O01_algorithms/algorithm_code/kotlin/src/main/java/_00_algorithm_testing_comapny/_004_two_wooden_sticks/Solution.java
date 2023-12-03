package O01_algorithms.O01_algorithms_004_two_wooden_sticks;

public class Solution {
    public static int solution(int A, int B) {
        int lengthWooden = A + B;

        if (lengthWooden < 4) return 0;
        if (lengthWooden == 4) return 1;

        int maxSize = lengthWooden / 4;
        for (int i = maxSize; i > 1; i--) {
            int partOfA = A / i;
            int partOfB = B / i;
            if (partOfA + partOfB == 4) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 21)); //7
        System.out.println(solution(13, 11)); //5
        System.out.println(solution(2, 1)); //0
        System.out.println(solution(1, 8)); //2

    }
}
