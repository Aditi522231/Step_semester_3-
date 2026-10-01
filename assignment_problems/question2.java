package assignment_problems;
public class question2 {

    // Reverses each word in a sentence while keeping the word order intact
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        // Split the sentence into individual words
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        // Loop through each word and reverse it using StringBuilder
        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            result.append(wordBuilder.reverse().toString());

            // Add a space between words (except after the last word)
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample test case
        String input = "hello club";
        String output = reverseEachWord(input);

        System.out.println(output);
    }
}