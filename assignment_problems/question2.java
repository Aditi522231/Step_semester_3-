package assignment_problems;

// Class defining payroll encapsulation and salary operations
class PayrollAccount {
    private double basicSalary;
    private double bonus;

    // Public constructor initializing opening basic salary with validation
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Negative salary provided. Initializing basic salary to 0.0");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0.0;
    }

    // Credits bonus if amount is strictly positive
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount. Bonus must be greater than 0.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Deducts tax percentage from basicSalary if within range [0, 100]
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage. Must be between 0 and 100.");
        } else {
            this.basicSalary -= this.basicSalary * (percent / 100.0);
            System.out.println("Tax deducted: " + (int) percent + "%");
        }
    }

    // Read-only getter returning computed net salary
    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

public class question2 {

    public static void main(String[] args) {
        // Sample Test Case
        PayrollAccount account = new PayrollAccount(50000);

        account.creditBonus(5000);
        account.deductTax(10);

        System.out.println("Net salary: Rs " + account.getNetSalary());
        // Expected Output:
        // Bonus credited: Rs 5000.0
        // Tax deducted: 10%
        // Net salary: Rs 50000.0
    }
}