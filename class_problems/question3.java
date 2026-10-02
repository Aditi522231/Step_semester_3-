package class_problems;

import java.util.Arrays;

public class question3 {

    public static int[] findTopThreeScores(int[] scores) {
        // Track the top three values initialized to minimum integer values
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        // Single pass scan left to right
        for (int score : scores) {
            if (score > first) {
                // Shift all down when a new highest score arrives
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                // Shift second and third
                third = second;
                second = score;
            } else if (score > third) {
                // Update third slot
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(Arrays.toString(findTopThreeScores(scores)));
        // Expected Output: [90, 90, 82]
    }
}
