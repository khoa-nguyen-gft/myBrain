package O01_algorithms.O01_algorithms_001_count_total_numbers_cars_pass_by_speed.src;

public class Solution {
    public static int solution(String S) {
        int leftCar = 0;
        int numberOfSpeed = 0;
        int finalRresult = 0;
        for (int i = 0; i < S.length(); i++) {

            char c = S.charAt(i);
            if(c == '.'){
                numberOfSpeed += leftCar;
            }
            else if(c == '>'){
                leftCar ++;
            } 
            
            System.out.print(c);
        }

        finalRresult = numberOfSpeed;
        numberOfSpeed = 0;
        int rightCar = 0;
        for (int i = S.length() -1; i >=0 ; i--) {

            char c = S.charAt(i);
            if(c == '.'){
                numberOfSpeed += rightCar;
            }
            else if(c == '<'){
                rightCar ++;
            } 
        }
        finalRresult += numberOfSpeed;

        return finalRresult;
    }

    public static void main(String[] args) {
        System.out.println(solution(".>..."));
        System.out.println(solution(".>.<.>"));
        System.out.println(solution(">>>.<<<"));
        System.out.println(solution("..<"));

    }
}
