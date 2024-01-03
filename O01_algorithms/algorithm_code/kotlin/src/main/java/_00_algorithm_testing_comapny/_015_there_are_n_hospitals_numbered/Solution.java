package _00_algorithm_testing_comapny._015_there_are_n_hospitals_numbered;

import java.util.*;

public class Solution {
    public static int solution(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        Map<Integer, Set<Integer>> doctorToHospitals = new HashMap<>();

        // Find hospitals for each doctor
        for (int hospital = 0; hospital < N; hospital++) {
            for (int day = 0; day < M; day++) {
                int doctorId = A[hospital][day];
                if (!doctorToHospitals.containsKey(doctorId)) {
                    doctorToHospitals.put(doctorId, new HashSet<>());
                }
                doctorToHospitals.get(doctorId).add(hospital);
            }
        }

        // Count the doctors working at more than one hospital
        int doctorsWithMultipleHospitals = 0;
        for (Set<Integer> hospitals : doctorToHospitals.values()) {
            if (hospitals.size() > 1) {
                doctorsWithMultipleHospitals++;
            }
        }

        return doctorsWithMultipleHospitals;
    }

    public static void main(String[] args) {
        int[][] A1 = {{1, 2, 2}, {3, 1, 4}};
        System.out.println(solution(A1)); // Output: 1

        int[][] A2 = {{1, 1, 5, 2, 3}, {4, 5, 6, 4, 3}, {9, 4, 4, 1, 5}};
        System.out.println(solution(A2)); // Output: 4

        int[][] A3 = {{4, 3}, {5, 5}, {6, 2}};
        System.out.println(solution(A3)); // Output: 0
    }
}
