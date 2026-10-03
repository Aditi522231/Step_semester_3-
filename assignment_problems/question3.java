
package assignment_problems;
public class question3 {

    public static void findLongestStreak(String signalLog) {
        // Handle empty or null input
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data provided.");
            return;
        }

        char maxChar = signalLog.charAt(0);
        int maxStreak = 1;

        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;

        // Traverse through the signal log starting from the second character
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentStreak++;
            } else {
                // Reset streak tracking for the new character
                currentChar = signalLog.charAt(i);
                currentStreak = 1;
            }

            // Update the maximum streak if the current streak is longer
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                maxChar = currentChar;
            }
        }

        // Output matching the sample format
        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        // Test cases from sample input/output
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
