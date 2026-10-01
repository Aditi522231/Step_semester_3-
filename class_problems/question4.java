package main.java.class_problems;
import java.util.HashMap;
import java.util.Map;

public class question4 {

    // Finds the first character with a frequency of 1
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0'; // Return null character for empty input
        }

        // Map to store character frequencies
        Map<Character, Integer> charCount = new HashMap<>();

        // First pass: Build the frequency map
        for (char ch : text.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        // Second pass: Scan string left-to-right to find the first unique character
        for (char ch : text.toCharArray()) {
            if (charCount.get(ch) == 1) {
                return ch; // Early exit on first unique character found
            }
        }

        return '\0'; // Return null character if no non-repeating character exists
    }

    // Helper method to format output according to the sample table
    public static void printFirstNonRepeatingChar(String text) {
        char result = findFirstNonRepeatingChar(text);

        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        // Test cases from the sample input/output table
        printFirstNonRepeatingChar("swiss");
        printFirstNonRepeatingChar("aabbcc");
    }
}