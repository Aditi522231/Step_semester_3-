package class_problems;

// Class encapsulating savings logic for a piggy bank
class PiggyBank {
    private final String id;
    private double savings;

    // Constructor initializing final ID and setting initial savings to 0
    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    // Deposits positive amount into savings
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be greater than 0");
        } else {
            this.savings += amount;
        }
    }

    // Withdraws amount if valid and sufficient savings exist
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be greater than 0");
        } else if (amount > this.savings) {
            System.out.println("rejected, savings stays " + (int) this.savings);
        } else {
            this.savings -= amount;
        }
    }

    // Read-only getter for current savings
    public double getSavings() {
        return this.savings;
    }

    // Read-only getter for piggy bank ID
    public String getId() {
        return this.id;
    }
}

public class question1 {

    public static void main(String[] args) {
        // Instantiate PiggyBank with fixed ID
        PiggyBank pb = new PiggyBank("PB-1");

        // Deposit 100 -> savings = 100
        pb.deposit(100);
        System.out.println("pb.deposit(100) -> savings = " + (int) pb.getSavings());

        // Withdraw 30 -> savings = 70
        pb.withdraw(30);
        System.out.println("pb.withdraw(30) -> savings = " + (int) pb.getSavings());

        // Withdraw 500 -> rejected, savings stays 70
        System.out.print("pb.withdraw(500) -> ");
        pb.withdraw(500);
    }
}
