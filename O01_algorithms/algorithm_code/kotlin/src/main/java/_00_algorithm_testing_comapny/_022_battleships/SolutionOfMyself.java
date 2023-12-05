package O01_algorithms.O01_algorithms_022_battleships;

import java.util.Arrays;


public class SolutionOfMyself {

    public static int[] solution(String[] B) {
        var width = B[0].length();
        var height = B.length;
        var result = new int[3];

        for (int x = 0; x < height; x++) {
            var row = B[x];
            for (int y = 0; y < width; y++) {
                char cell = row.charAt(y);
                if (cell == '#') {
                    System.out.print( " " + y + ":" +  cell);
                }
            }

            System.out.println("");
        }


        return result;
    }

    public static void main(String[] args) {
        int[] solution = solution(new String[]{".##.#", "#.#..", "#...#", "#.##."});
        System.out.println(Arrays.toString(solution));
    }
}
