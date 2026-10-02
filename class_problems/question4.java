package class_problems;

// Class encapsulating locker code security without exposing direct read access
class Locker {
    private final int lockerNumber;
    private String combinationCode;

    // Constructor initializing fixed locker number and initial code
    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    // Changes code only if the current code entered matches the stored combination
    public boolean changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            System.out.println("success");
            return true;
        } else {
            System.out.println("rejected, code is still unchanged");
            return false;
        }
    }

    // Read-only getter for locker number
    public int getLockerNumber() {
        return this.lockerNumber;
    }
}

public class question4 {

    public static void main(String[] args) {
        // Sample Test Case matching example input/output
        Locker l = new Locker(101, "1234");

        System.out.print("l.changeCode(\"1234\", \"5678\") -> ");
        l.changeCode("1234", "5678");

        System.out.print("l.changeCode(\"0000\", \"9999\") -> ");
        l.changeCode("0000", "9999");
    }
}
