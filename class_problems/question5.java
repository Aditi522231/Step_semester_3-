package class_problems;

import java.util.Scanner;

public class question5 {

    // Calculates fare based on transport type, distance, and extra parameters
    public static double calculateFare(String transportType, double distance, Scanner scanner) {
        switch (transportType.toUpperCase()) {
            case "BUS":
                // Base fare $2 + $0.10 per km, capped at max fare of $10
                double busFare = 2.0 + (distance * 0.10);
                return Math.min(10.0, busFare);
            case "TRAIN":
                // Base fare $3 + $0.15 per km
                return 3.0 + (distance * 0.15);
            case "METRO":
                // (Base fare $1.50 + $0.20 per km) * PeakHourFactor
                double peakHourFactor = scanner.nextDouble();
                return (1.50 + (distance * 0.20)) * peakHourFactor;
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
        double grandTotalFare = 0.0;

        for (int i = 0; i < n; i++) {
            String transportType = scanner.next();
            double distance = scanner.nextDouble();

            double calculatedFare = calculateFare(transportType, distance, scanner);
            grandTotalFare += calculatedFare;

            System.out.printf("%s: %.2f%n", transportType, calculatedFare);
        }

        System.out.printf("Total: %.2f%n", grandTotalFare);

        scanner.close();
    }
}
