package assignment_problems;
public class question1 {

    // Validates if the PIN string is exactly 4 digits long using length() and if/else
    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        // Sample test cases from the table
        checkPinLength("482");
        checkPinLength("4820");
    }
}