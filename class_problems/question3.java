package class_problems;
public class question3 {

    // Helper method to determine health status classification based on BMI score
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Computes BMI for each individual and displays a structured tabular wellness report
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid input data.");
            return;
        }

        System.out.printf("%-10s | %-10s | %-11s | %-6s | %-11s\n", 
                          "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];

            // Formula: BMI = weight / (height * height)
            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-10.2f | %-11.2f | %-6.2f | %-11s\n", 
                              (i + 1), height, weight, bmi, status);
        }
    }

    public static void main(String[] args) {
        // Sample test cases provided in the assignment description
        double[] heights = {1.75, 1.60};
        double[] weights = {70.0, 90.0};

        printWellnessReport(heights, weights);
    }
}