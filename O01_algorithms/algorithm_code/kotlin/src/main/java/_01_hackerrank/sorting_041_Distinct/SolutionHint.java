package _01_hackerrank.sorting_041_Distinct;

import java.util.HashSet;
import java.util.Set;

public class SolutionHint {
    public static int solution(int[] A) {
        Set set = new HashSet();

        for (int i : A) {
            set.add(i);
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1})); //3
        System.out.println(solution(new int[]{})); //0
        System.out.println(solution(new int[]{1})); //1
        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1})); //1
        System.out.println(solution(new int[]{-1, -2, -3, -1, -2})); //1
    }
}