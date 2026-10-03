package class_problems;
public class question5 {

    // Reverses a given customer name without modifying the original string
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        // Convert string to character array and build reversed version
        char[] originalChars = customerName.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        for (int i = 0; i < originalChars.length; i++) {
            reversedChars[i] = originalChars[originalChars.length - 1 - i];
        }

        return new String(reversedChars);
    }

    public static void main(String[] args) {
        // Sample input test case
        String name = "Sunil";

        // Call reversal method
        String reversed = reverseCustomerName(name);

        // Display original and reversed names as shown in the sample output
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed);
    }
}