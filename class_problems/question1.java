package class_problems;
public class question1 {

    // Counts vowels and consonants in a given string, ignoring spaces
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowelCount = 0;
        int consonantCount = 0;

        // Convert to lowercase for case-insensitive comparison
        String lowerText = text.toLowerCase();

        // Loop through each character using charAt()
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);

            // Ignore spaces and non-letter characters
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        // Print output matching sample format
        System.out.println("Vowels: " + vowelCount + " | Consonants: " + consonantCount);
    }

    public static void main(String[] args) {
        // Sample test case from table
        countVowelsAndConsonants("Java Programming");
    }
}