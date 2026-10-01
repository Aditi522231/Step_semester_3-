package assignment_problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class question5 {

    // Analyzes word frequencies in feedback after filtering out stop words and punctuation
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Define fixed set of stop words
        Set<String> stopWords = new HashSet<>(Arrays.asList(
            "the", "was", "and", "a", "is", "of", "in"
        ));

        // Normalize text: convert to lowercase and strip punctuation (periods and commas)
        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");

        // Split into words by whitespace
        String[] words = cleanedText.trim().split("\\s+");

        // Map to count frequencies of meaningful words
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            // Skip stop words
            if (stopWords.contains(word)) {
                continue;
            }
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Convert map entries to list for sorting by frequency in descending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCounts.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Print output matching sample format
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Sample input test case
        String sampleInput = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(sampleInput);
    }
}