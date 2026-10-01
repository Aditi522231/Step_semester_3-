package assignment_problems;
public class question4 {

    // Normalizes the input: trims spaces and uppercase only the first 3 characters
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }

        String trimmed = raw.trim();

        // If length is less than 3, uppercase what is available
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Uppercase the first 3 characters and keep the rest untouched
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    // Validates the code structure and formats it using StringBuilder
    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check if the first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: non-letter publisher code";
            }
        }

        // Check if the remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract parts
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        // Build output string using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ")
          .append("YEAR: ").append(year).append(" | ")
          .append("CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample test case from table
        String rawInput = " pen2026004251 ";

        String normalized = normalizeCode(rawInput);
        String result = validateAndFormat(normalized);

        System.out.println(result);
    }
}