package _00_algorithm_testing_comapny._011_maximum_positive_value;

public class SolutionHint {
    public static int solution(int value) {
        String strValue = String.valueOf(value);
        String FIVE = "5";

        if (strValue.replaceAll(FIVE, "").length() + 1 == strValue.length()) {
            return value;
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < strValue.length(); i++) {
            if (strValue.charAt(i) == '5') {
                int modifiedValue = Integer.parseInt(strValue.substring(0, i) + strValue.substring(i + 1));
                maxValue = Math.max(maxValue, modifiedValue);
            }
        }

        return maxValue;
    }
    public static void main(String[] args) {
        System.out.println(solution(15958));  // Output: 1958
        System.out.println(solution(-5859));  // Output: -589
        System.out.println(solution(-5000));  // Output: -5000
        System.out.println(solution(5000));   // Output: 5000
        System.out.println(solution(12345));  // Output: 12345
        System.out.println(solution(123455)); // Output: 12345
    }
}
