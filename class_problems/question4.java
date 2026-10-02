package class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class question4 {

    // Helper method to parse quoted strings and trailing tokens from a single line
    private static List<String> parseLineTokens(String line) {
        List<String> tokens = new ArrayList<>();
        // Matches quoted strings OR non-whitespace tokens
        Matcher matcher = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                tokens.add(matcher.group(1)); // Quoted string content
            } else {
                tokens.add(matcher.group(2)); // Unquoted word/number
            }
        }
        return tokens;
    }

    // Calculates question score based on question type and answers
    public static double evaluateQuestionScore(String type, String correctAnswer, String studentAnswer, double maxPoints) {
        switch (type.toUpperCase()) {
            case "MCQ":
            case "TF":
                // Exact match yields full points
                if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
                    return maxPoints;
                }
                return 0.0;

            case "ESSAY":
                // Split comma-separated keywords
                String[] keywords = correctAnswer.split(",");
                int matchedCount = 0;
                String lowerStudentAns = studentAnswer.toLowerCase();

                for (String kw : keywords) {
                    String trimmedKw = kw.trim().toLowerCase();
                    if (!trimmedKw.isEmpty() && lowerStudentAns.contains(trimmedKw)) {
                        matchedCount++;
                    }
                }

                if (matchedCount >= 2) {
                    return maxPoints * 0.75; // 75% for 2 or more keywords
                } else if (matchedCount == 1) {
                    return maxPoints * 0.50; // 50% for 1 keyword
                } else {
                    return 0.0; // 0 points
                }

            default:
                return 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        scanner.nextLine(); // Consume remaining newline after N

        double totalScore = 0.0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            while (line.isEmpty()) {
                line = scanner.nextLine().trim();
            }

            List<String> tokens = parseLineTokens(line);

            // Structure: QuestionType, QuestionText, CorrectAnswer, StudentAnswer, Points
            String type = tokens.get(0);
            // Index 1 (questionText) is intentionally skipped as it isn't required for scoring
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            double maxPoints = Double.parseDouble(tokens.get(4));

            double score = evaluateQuestionScore(type, correctAnswer, studentAnswer, maxPoints);
            totalScore += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        scanner.close();
    }
}