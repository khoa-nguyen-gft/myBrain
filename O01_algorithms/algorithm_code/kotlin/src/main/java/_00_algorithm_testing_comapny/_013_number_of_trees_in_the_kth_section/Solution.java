package _00_algorithm_testing_comapny._013_number_of_trees_in_the_kth_section;

import java.util.Arrays;

public class Solution {

    public static int solution(int[] array) {
        int count = 0;
        int trees = (int) Math.ceil(Arrays.stream(array).sum() / ((1.0) * array.length));
        for (int i : array) {
            if (i != trees) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 2, 4})); //4
        System.out.println(solution(new int[]{4, 2, 4, 6})); //2
        System.out.println(solution(new int[]{1, 1, 2, 1})); //3

    }
}
