package _00_algorithm_testing_comapny._011_maximum_positive_value;


public class Solution {
    public static int solution(int value) {

        var strValue = String.valueOf(value);
        var FIVE = '5';
        var maxValue = Integer.MIN_VALUE;

        if (strValue.replaceAll(String.valueOf(FIVE), "").length() + 1 == strValue.length()) {
            return value;
        }

        for (int i = 0; i < strValue.length(); i++) {
            if (strValue.charAt(i) == FIVE) {
                var firstString = strValue.substring(0, i);
                var secondString = strValue.substring(i + 1, strValue.length());
                maxValue = Math.max(maxValue, Integer.valueOf(firstString + secondString));

            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(solution(15958));//1958
        System.out.println(solution(-5859));//-589
        System.out.println(solution(-5000));//-5000
        System.out.println(solution(5000));//5000
        System.out.println(solution(12345));//12345
        System.out.println(solution(123455));//12345
    }
}
