package class_problems;

import java.util.Scanner;

public class question1 {

    // Calculates adjusted transaction amount after applying processing fee
    public static double calculateAdjustedAmount(String paymentType, double amount) {
        switch (paymentType.toUpperCase()) {
            case "CARD":
                // 2% processing fee
                return amount * 1.02;
            case "WALLET":
                // 1% processing fee
                return amount * 1.01;
            case "BANKTRANSFER":
                // No processing fee
                return amount;
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
            String paymentType = scanner.next();
            double amount = scanner.nextDouble();

            double adjustedAmount = calculateAdjustedAmount(paymentType, amount);
            grandTotal += adjustedAmount;

            System.out.printf("%s: %.2f%n", paymentType, adjustedAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        scanner.close();
    }
}