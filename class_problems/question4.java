package class_problems;

public class question4 {

    // Helper method to compute the average for a single row
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int score : row) {
            sum += score;
        }

        return sum / row.length;
    }

    // Main classification method iterating through all rows
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            // Call rowAverage once per row
            double avg = rowAverage(seatingScores[i]);

            // Classify based on the threshold
            String status = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";

            // Format string output
            result.append("Row ").append(i).append(": ").append(status);

            // Add delimiter for all but the last row
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[][] seatingScores = {
            {40, 50, 45},   // Avg = 45.0 (< 60 -> Quiet Zone)
            {85, 90, 95},   // Avg = 90.0 (>= 60 -> Buzzing Zone)
            {30, 20, 25}    // Avg = 25.0 (< 60 -> Quiet Zone)
        };
        int threshold = 60;

        System.out.println(classifyRows(seatingScores, threshold));
        // Expected Output: "Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone"
    }
}
