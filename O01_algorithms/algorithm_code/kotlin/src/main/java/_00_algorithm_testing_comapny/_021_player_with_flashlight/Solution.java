package _00_algorithm_testing_comapny._021_player_with_flashlight;

public class Solution {
    private static class Direction {
        public static final String UP = "U";
        public static final String DOWN = "D";
        public static final String LEFT = "L";
        public static final String RIGHT = "R";
    }

    public static int solution(String direction, int radius, int[] x, int[] y) {
        int length = x.length;
        int count = 0;
        int startDecrees = -45;

        for (int i = 0; i < length; i++) {
            var enemyX = x[i];
            var enemyY = y[i];

            // Calculate the distance between the player and the enemy
            double distance = Math.sqrt(enemyX * enemyX + enemyY * enemyY);

            if (distance <= radius) {
                var degrees = Math.toDegrees(Math.atan2(enemyX, enemyY));

                if (Direction.UP.equals(direction) && enemyY > 0) {
                    if (degrees >= startDecrees && degrees <= startDecrees + 90) {
                        count++;
                    }
                } else if (Direction.RIGHT.equals(direction) && enemyX > 0) {
                    startDecrees = 45;

                    if (degrees >= startDecrees && degrees <= startDecrees + 90) {
                        count++;
                    }
                } else if (Direction.DOWN.equals(direction) && enemyY < 0) {
                    startDecrees = 135;

                    if (degrees >= startDecrees && degrees <= 180 || degrees <= -startDecrees) {
                        count++;
                    }
                } else if (Direction.LEFT.equals(direction) && enemyY < 0) {
                    startDecrees = -135;
                    if (degrees >= startDecrees && degrees <= startDecrees + 90) {
                        count++;
                    }
                }

            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(solution("U", 5, new int[]{-1, -2, 4, 1, 3, 0}, new int[]{5, 4, 3, 3, 1, -1}));//2
        System.out.println(solution("R", 3, new int[]{-2, 3}, new int[]{0, 1})); //expect result: 0
        System.out.println(solution("R", 4, new int[]{-2, 3}, new int[]{0, 1})); //expect result: 1
        System.out.println(solution("D", 10, new int[]{0, -3, 2, 0}, new int[]{-10, -3, -7, -5})); // expect result: 4
        System.out.println(solution("L", 4, new int[]{-2, -3}, new int[]{0, -1})); //1
    }
}
