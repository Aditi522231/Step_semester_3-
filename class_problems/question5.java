package class_problems;
public class question5 {

    // Normalizes the input: trims spaces and converts the first 3 characters to uppercase
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        
        // Trim leading and trailing spaces
        String trimmed = raw.trim();
        
        // If the string length is less than 3, uppercase the whole string
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        
        // Uppercase only the first 3 characters using substring() + concatenation
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    // Validates the normalized reference and formats or returns an error message
    public static String validateAndFormat(String reference) {
        if (reference == null) {
            return "Invalid: Input is null";
        }

        // 1. Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length (expected 14, got " + reference.length() + ")";
        }

        // 2. Validate first 3 characters are letters using Character.isLetter() in a loop
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: non-letter bank code";
            }
        }

        // 3. Validate remaining 11 characters are digits using Character.isDigit() in a loop
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract components for formatted display
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String sequence = reference.substring(9, 14);

        // Build formatted display line with StringBuilder: "[BANKCODE] DATE: dd/MM/yy | SEQ: 12345"
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ")
          .append("DATE: ").append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(sequence);

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {
            "  sbi15102612345  ", // Valid case with lowercase and spaces
            "  icici15102612345 ", // Invalid length
            "  12A15102612345 ",   // Non-letter bank code
            "  HDF15102X12345  "   // Non-digit body
        };

        for (String rawInput : testInputs) {
            String normalized = normalizeReference(rawInput);
            String result = validateAndFormat(normalized);
            
            System.out.println("Raw Input: \"" + rawInput + "\"");
            System.out.println("Normalized: \"" + normalized + "\"");
            System.out.println("Result    : " + result);
            System.out.println("-".repeat(50));
        }
    }
}