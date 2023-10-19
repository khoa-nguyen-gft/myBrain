package O01_algorithms.O01_algorithms_008_the_start_of_the_journey;

import java.util.Arrays;

public class Solution {
    public static int solution(int[] P, int[] S) {
        Arrays.sort(P);
        var totalSeat = Arrays.stream(S).sum();
        var totalPerson = Arrays.stream(P).sum();
        var assignedSeats = 0;
        var remainingSeats = totalSeat - totalPerson;

        for (int i : P) {
            if (remainingSeats >= i) {
                remainingSeats -= i;
                assignedSeats++;
            }
            if (remainingSeats < i) {
                return P.length - assignedSeats;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 1}, new int[]{1, 5, 1})); //2
        System.out.println(solution(new int[]{4, 4, 2, 4}, new int[]{5, 5, 2, 5})); //3
        System.out.println(solution(new int[]{2, 3, 4, 2}, new int[]{2, 5, 7, 2})); //2
    }
}
