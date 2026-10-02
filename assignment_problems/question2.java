package assignment_problems;

import java.util.Scanner;

public class question2 {

    // Calculates parking charge based on vehicle type and duration in hours
    public static double calculateParkingCharge(String vehicleType, int hours) {
        switch (vehicleType.toUpperCase()) {
            case "BIKE":
                // ₹10 per hour
                return hours * 10.0;
            case "CAR":
                // ₹30 for the first hour, plus ₹20 for each additional hour
                return 30.0 + (hours - 1) * 20.0;
            case "TRUCK":
                // ₹50 per hour with a minimum charge of ₹100
                return Math.max(100.0, hours * 50.0);
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
            String vehicleType = scanner.next();
            int hours = scanner.nextInt();

            double charge = calculateParkingCharge(vehicleType, hours);
            grandTotal += charge;

            System.out.printf("%s: %.2f%n", vehicleType, charge);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        scanner.close();
    }
}
