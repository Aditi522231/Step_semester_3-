package class_problems;

// Class encapsulating hostel mess wallet balance and operations
class MessWallet {
    private double balance;

    // Public constructor initializing opening balance with validation
    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Negative opening balance provided. Starting balance set to 0.0");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    // Top up wallet balance if amount > 0
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be greater than 0");
        } else {
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }

    // Deduct amount if sufficient balance exists
    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Deduct rejected: amount must be greater than 0");
        } else {
            this.balance -= amount;
        }
    }

    // Read-only getter for current balance
    public double getBalance() {
        return this.balance;
    }
}

public class question2{

    public static void main(String[] args) {
        // Sample Test Case matching example input/output
        MessWallet wallet = new MessWallet(500);

        wallet.topUp(200);
        wallet.deduct(1000);

        System.out.println("Final balance: " + wallet.getBalance());
        // Expected Output:
        // Balance after top-up: 700.0
        // Deduct rejected: insufficient balance
        // Final balance: 700.0
    }
}
