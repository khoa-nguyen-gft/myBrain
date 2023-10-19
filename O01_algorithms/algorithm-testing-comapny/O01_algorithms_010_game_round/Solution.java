package O01_algorithms.O01_algorithms_010_game_round;

public class Solution {
    public static int solution(String A, String B) {
        int hourA = Integer.valueOf(A.substring(0, 2));
        int minuteA = Integer.valueOf(A.substring(A.length() - 2));

        int hourB = Integer.valueOf(B.substring(0, 2));
        int minuteB = Integer.valueOf(B.substring(A.length() - 2));

        var minus = 0;

        // round start minutes
        if (minuteA % 15 != 0) {
            minuteA = minuteA + (15 - (minuteA % 15));
        }

        if (hourB < hourA) {
            hourB += 24;
        }

        // minus 2 hours
        minus = (hourB * 60 + minuteB) - (hourA * 60 + minuteA);

        return minus / 15;
    }

    public static void main(String[] args) {
        System.out.println(solution("12:01", "12:44")); //1
        System.out.println(solution("20:00", "06:00")); //40
        System.out.println(solution("00:00", "23:59")); //95
        System.out.println(solution("08:00", "06:00")); //88
        System.out.println(solution("12:03", "12:03")); //00

    }
}
