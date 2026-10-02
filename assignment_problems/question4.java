package assignment_problems;

public class question4 {

    // Helper method to compute the average for a single row (match)
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }

        return sum / row.length;
    }

    // Main classification method iterating through all matches
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            // Call rowAverage once per row/match
            double avg = rowAverage(runsPerOver[i]);

            // Classify based on the threshold
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            // Format string output
            result.append("Match ").append(i).append(": ").append(status);

            // Add delimiter for all but the last match
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[][] runsPerOver = {
            {4, 6, 8},      // Avg = 6.0 (Normal)
            {10, 12, 14},   // Avg = 12.0 (Power Surge)
            {2, 3, 1}       // Avg = 2.0 (Normal)
        };
        int threshold = 8;

        System.out.println(classifyMatches(runsPerOver, threshold));
        // Expected Output: "Match 0: Normal | Match 1: Power Surge | Match 2: Normal"
    }
}
