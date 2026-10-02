package assignment_problems;

import java.util.Scanner;

public class question3 {

    // Calculates electricity bill amount based on room type and additional parameters
    public static double calculateElectricityBill(String roomType, double units, Scanner scanner) {
        switch (roomType.toUpperCase()) {
            case "SINGLE":
                // ₹8 per unit
                return units * 8.0;
            case "SHARED":
                // ₹6 per unit divided equally by number of occupants
                int occupants = scanner.nextInt();
                return (units * 6.0) / occupants;
            case "AC":
                // ₹10 per unit plus a fixed charge of ₹200
                return (units * 10.0) + 200.0;
            default:
                return 0.0;
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
            String roomType = scanner.next();
            double units = scanner.nextDouble();

            double billAmount = calculateElectricityBill(roomType, units, scanner);
            grandTotal += billAmount;

            System.out.printf("%s: %.2f%n", roomType, billAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        scanner.close();
    }
}