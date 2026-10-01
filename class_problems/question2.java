package main.java.class_problems;
public class question2 {

    // Approach 1: Iterative Comparison
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive Check
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        
        // Base case: string of length 0 or 1 is always a palindrome
        if (text.length() <= 1) {
            return true;
        }

        // Compare first and last characters
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        // Recursive call with inner substring
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Array Reversal Check
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        // Reverse the character array manually
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        // Compare original and reversed arrays
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    // Helper method to display output matching sample format
    public static void verifyPalindrome(String text) {
        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        String iterRes = iterative ? "Palindrome" : "Not Palindrome";
        String recurRes = recursive ? "Palindrome" : "Not Palindrome";
        String arrayRes = arrayReversal ? "Palindrome" : "Not Palindrome";

        System.out.println("Iterative: " + iterRes + " | Recursive: " + recurRes + " | Array Reversal: " + arrayRes);
    }

    public static void main(String[] args) {
        // Test cases from the sample table
        verifyPalindrome("madam");
        verifyPalindrome("hello");
    }
}
