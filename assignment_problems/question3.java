package assignment_problems;

// Class encapsulating password strength evaluation without exposing sensitive text
class PasswordChecker {
    private final String password;

    // Constructor accepting password and storing it immutably
    public PasswordChecker(String password) {
        this.password = (password != null) ? password : "";
    }

    // Evaluates and returns password strength label without returning the password itself
    public String getStrength() {
        int length = this.password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class question3 {

    public static void main(String[] args) {
        // Sample Test Case
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("pc.getStrength() -> \"" + pc1.getStrength() + "\"");

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("pc2.getStrength() -> \"" + pc2.getStrength() + "\"");
    }
}