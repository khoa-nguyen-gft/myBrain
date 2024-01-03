package _00_algorithm_testing_comapny._022_battleships;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] B1 = {".##.#", "#.#..", "#...#", "#.##."};
        int[] count1 = solution.solution(B1);
        System.out.println(Arrays.toString(count1)); // [2, 1, 2]

        String[] B2 = {".#..#", "##..#", "...#."};
        int[] count2 = solution.solution(B2);
        System.out.println(Arrays.toString(count2)); // [1, 1, 1]

        String[] B3 = {"##.", "#.#", ".##"};
        int[] count3 = solution.solution(B3);
        System.out.println(Arrays.toString(count3)); // [0, 0, 2]

        String[] B4 = {"...", "...", "..."};
        int[] count4 = solution.solution(B4);
        System.out.println(Arrays.toString(count4)); // [0, 0, 0]
    }
}
class Solution {
    public int[] solution(String[] B) {
        int[] count = new int[3]; // To store the count of each ship type: [0, 0, 0]

        for (String row : B) {
            for (int i = 0; i < row.length(); i++) {
                char cell = row.charAt(i);
                if (cell == '#') {
                    // Check neighboring cells to determine the ship type
                    if (i + 1 < row.length() && row.charAt(i + 1) == '#') {
                        if (i + 2 < row.length() && row.charAt(i + 2) == '#') {
                            count[2]++; // Destroyer (size 3)
                            i += 2; // Skip the next two cells
                        } else {
                            count[1]++; // Submarine (size 2)
                            i++; // Skip the next cell
                        }
                    } else {
                        count[0]++; // Patrol Boat (size 1)
                    }
                }
            }
        }

        return count;
    }
}
