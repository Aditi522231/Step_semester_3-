package class_problems;

import java.util.Arrays;

public class question1{

    public static void curveScores(int[] scores, int bonus) {
        if (scores == null) {
            return;
        }

        // Boost every score directly in place
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[] scores = {70, 85, 60};
        int bonus = 10;

        curveScores(scores, bonus);

        // Print final leaderboard using Arrays.toString() as required
        System.out.println(Arrays.toString(scores));
        // Expected Output: [80, 95, 70]
    }
}
