package _00_algorithm_testing_comapny._021_player_with_flashlight;

public class SolutionHint {
    public static int solution(String direction, int radius, int[] x, int[] y) {
        int count = 0;

        for (int i = 0; i < x.length; i++) {
            int enemyX = x[i];
            int enemyY = y[i];

            // Calculate the distance between the player and the enemy
            double distance = Math.sqrt(Math.pow(enemyX, 2) + Math.pow(enemyY, 2));

            // Check if the enemy is within the radius and light field of the flashlight
            if (distance <= radius) {
                if (direction.equals("U") && enemyY > 0 && Math.abs(enemyX) <= enemyY && enemyX >= -enemyY)
                    count++;
                else if (direction.equals("D") && enemyY < 0 && Math.abs(enemyX) <= -enemyY && enemyX <= enemyY)
                    count++;
                else if (direction.equals("L") && enemyX < 0 && Math.abs(enemyY) <= -enemyX && enemyY <= enemyX)
                    count++;
                else if (direction.equals("R") && enemyX > 0 && Math.abs(enemyY) <= enemyX && enemyY >= enemyX)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("U", 5, new int[]{-1, -2, 4, 1, 3, 0}, new int[]{5, 4, 3, 3, 1, -1})); //2
        System.out.println(solution("D", 10, new int[]{0, -3, 2, 0}, new int[]{-10, -3, -7, -5})); //4
        System.out.println(solution("R", 3, new int[]{-2, 3}, new int[]{0, 1})); //0
    }
}

