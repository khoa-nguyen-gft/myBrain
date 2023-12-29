package _00_algorithm_testing_comapny._007_shortest_unique_substring_of_String;

public class Solution {
    public static int solution(String s) {
        var length = s.length();
        for (int lengthSubString = 1; lengthSubString < length; lengthSubString++) {
            for (int startIndex = 0; startIndex < length; startIndex++) {
                if (startIndex + lengthSubString < length) {
                    var subString = s.substring(startIndex, startIndex + lengthSubString);
                    var count = countOccurrences(s, subString);
                    if (count == 1) {
                        return subString.length();
                    }
                }
            }
        }
        return 0;
    }

    public static int countOccurrences(String str, String subStr) {
        int count = 0;
        var fromIndex = 0;
        while (fromIndex != -1) {
            fromIndex = str.indexOf(subStr, fromIndex);
            if (fromIndex != -1) {
                count++;
                fromIndex += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("abaaba")); //2
        System.out.println(solution("zyzyzyz")); //5
        System.out.println(solution("aabbbabaaa")); //3

    }
}
