package _01_hackerrank.sorting_041_Distinct;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int solution(int[] A) {
        if (A.length == 0 || A.length == 1) return A.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        return map.size();
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{2, 1, 1, 2, 3, 1})); //3
        System.out.println(Solution.solution(new int[]{})); //0
        System.out.println(Solution.solution(new int[]{1})); //1
        System.out.println(Solution.solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        })); //1

        System.out.println(Solution.solution(new int[]{-1, -2, -3, -1, -2})); //1


    }
}
