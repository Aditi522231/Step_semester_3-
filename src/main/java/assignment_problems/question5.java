package assignment_problems;

public class question5 {

    public static void classifyWordLengths(String review) {
        // Handle empty or null input
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split the review into words by whitespace
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        // Categorize each word based on length
        for (String word : words) {
            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        // Output matching the sample format
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        // Sample input test case
        String sampleInput = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(sampleInput);
    }
}
