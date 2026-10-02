package assignment_problems;

import java.util.Scanner;

public class question1 {

    // Calculates final bill amount based on customer type
    public static double calculateFinalAmount(String customerType, double amount) {
        switch (customerType.toUpperCase()) {
            case "STUDENT":
                return amount * 0.90; // 10% discount
            case "STAFF":
                return amount * 0.95; // 5% discount
            case "GUEST":
                return amount + 10.0; // ₹10 service charge
            default:
                return amount;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String customerType = scanner.next();
            double amount = scanner.nextDouble();

            double finalAmount = calculateFinalAmount(customerType, amount);
            grandTotal += finalAmount;

            System.out.printf("%s: %.2f%n", customerType, finalAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        scanner.close();
    }
}