package class_problems;
public class question4 {

    // Validates a 10-digit phone number and returns a masked string format
    public static String formatMaskedPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid Phone Number";
        }

        // Validate that all characters are numeric digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid Phone Number";
            }
        }

        // Extract the last 4 digits
        String lastFour = phone.substring(6);

        // Build the masked format using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX-").append(lastFour);

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(formatMaskedPhoneNumber("9876543210"));
        System.out.println(formatMaskedPhoneNumber("12345"));
        System.out.println(formatMaskedPhoneNumber("987654321A"));
    }
}