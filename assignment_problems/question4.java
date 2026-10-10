package assignment_problems;

import java.util.Scanner;

public class question4 {

    // Interface representing night service capability for cabs that support it
    public interface NightServiceable {
        double applyNightSurcharge(double fare);
    }

    // Base abstract class for all cab types enforcing minimum fare rules
    public static abstract class Cab {
        protected double km;
        protected String time;

        public Cab(double km, String time) {
            this.km = km;
            this.time = time.toUpperCase();
        }

        public abstract double getRatePerKm();

        // Calculates base fare and enforces the minimum cap of 100
        public double calculateFare() {
            double rawFare = km * getRatePerKm();
            double baseFare = Math.max(100.0, rawFare);

            if ("NIGHT".equals(time)) {
                if (this instanceof NightServiceable) {
                    return ((NightServiceable) this).applyNightSurcharge(baseFare);
                } else {
                    return -1.0; // Indicates night service not available
                }
            }
            return baseFare;
        }
    }

    public static class MiniCab extends Cab {
        public MiniCab(double km, String time) {
            super(km, time);
        }

        @Override
        public double getRatePerKm() {
            return 10.0;
        }
    }

    public static class SedanCab extends Cab implements NightServiceable {
        public SedanCab(double km, String time) {
            super(km, time);
        }

        @Override
        public double getRatePerKm() {
            return 14.0;
        }

        @Override
        public double applyNightSurcharge(double fare) {
            return fare * 1.20; // Adds 20% to the fare
        }
    }

    public static class SuvCab extends Cab implements NightServiceable {
        public SuvCab(double km, String time) {
            super(km, time);
        }

        @Override
        public double getRatePerKm() {
            return 18.0;
        }

        @Override
        public double applyNightSurcharge(double fare) {
            return fare * 1.20; // Adds 20% to the fare
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            Cab cab = null;

            switch (cabType.toUpperCase()) {
                case "MINI":
                    cab = new MiniCab(km, time);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km, time);
                    break;
                case "SUV":
                    cab = new SuvCab(km, time);
                    break;
            }

            if (cab != null) {
                double fare = cab.calculateFare();
                if (fare < 0) {
                    System.out.println(cabType.toUpperCase() + ": night service not available");
                } else {
                    totalCollected += fare;
                    System.out.printf("%s: %.2f%n", cabType.toUpperCase(), fare);
                }
            }
        }

        System.out.printf("Total: %.2f%n", totalCollected);

        scanner.close();
    }
}