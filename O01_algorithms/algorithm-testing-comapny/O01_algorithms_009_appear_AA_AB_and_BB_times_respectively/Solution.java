package O01_algorithms.O01_algorithms_009_appear_AA_AB_and_BB_times_respectively;

public class Solution {
    public static int solution(int aa, int ab, int bb) {
        String strAB = "AB";
        String strBB = "BB";
        String strAA = "AA";

        int length = aa + ab + bb;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (sb.indexOf("AAA") != -1 || sb.indexOf("BBB") != -1) {
                String subString = sb.substring(0, sb.length() - 2);
                return subString.length();
            }
            if (ab > 0) {
                sb.append(strAB);
                ab--;
            }
            if (aa > 0) {
                sb.append(strAA);
                aa--;
            }
            if (bb > 0) {
                sb.append(strBB);
                bb--;
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 0, 2)); //10
        System.out.println(solution(1, 2, 1));//8
        System.out.println(solution(0, 2, 0));//4
        System.out.println(solution(0, 0, 10));//2

    }
}
