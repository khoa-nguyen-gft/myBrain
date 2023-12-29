package _00_algorithm_testing_comapny._006_minimum_number_of_characters_to_delete;

//References: https://www.linkedin.com/pulse/best-solutions-microsoft-interview-tasks-min-obtain-molchevskyi/
public class SolutionHint {
    public static int solution(String s) {
        final char CHAR_A = 'A';
        int num_Bs = 0, min_dels = 0;

        for (char c : s.toCharArray()) {
            System.out.println("C: " + c);
            System.out.println("min_dels: " + min_dels);
            System.out.println("num_Bs: " + num_Bs);

            if (CHAR_A == c) {
                // minimum deletions with this character included
                // is equal to the count of all Bs before it
                min_dels = Math.min(num_Bs, min_dels + 1);
            } else {
                num_Bs++;
                // there is no need to exclude the last B at the end of the string,
                // the min_dels does not change
            }
        }
        return min_dels;
    }


    public static void main(String[] args) {
        System.out.println(solution("BAAABAB")); //2
        System.out.println(solution("BBABAA")); //3
        System.out.println(solution("AABBBB")); //0
    }
}
