package O01_algorithms.O01_algorithms_003_find_first_unique_number;

import java.util.*;

public class Solution {

    public static int solution(int[] n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : n) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        System.out.println(map);
        for (int i : n) {
            if (map.containsKey(i) && map.get(i).equals(1)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 10, 5, 4, 2, 10}));
        System.out.println(solution(new int[]{456, 7, 3, 2, 2, 2, 31}));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 4, 4}));

    }
}

