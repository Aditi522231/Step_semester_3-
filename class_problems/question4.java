package class_problems;

import java.util.Scanner;

public class question4 {

    // Base abstract class representing an electricity connection
    public static abstract class ElectricityConnection {
        protected double units;

        public ElectricityConnection(double units) {
            this.units = units;
        }

        public abstract double calculateBill();
    }

    public static class HomeConnection extends ElectricityConnection {
        public HomeConnection(double units) {
            super(units);
        }

        @Override
        public double calculateBill() {
            // Home: 5 per unit for the first 100 units and 7 per unit after that
            if (units <= 100) {
                return units * 5.0;
            } else {
                return (100 * 5.0) + ((units - 100) * 7.0);
            }
        }
    }

    public static class ShopConnection extends ElectricityConnection {
        public ShopConnection(double units) {
            super(units);
        }

        @Override
        public double calculateBill() {
            // Shop: 8 per unit plus a fixed charge of 100
            return (units * 8.0) + 100.0;
        }
    }

    public static class FactoryConnection extends ElectricityConnection {
        public FactoryConnection(double units) {
            super(units);
        }

        @Override
        public double calculateBill() {
            // Factory: 6 per unit, with a minimum bill of 1000
            double bill = units * 6.0;
            return Math.max(1000.0, bill);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        double totalBilled = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next().toUpperCase();
            double units = scanner.nextDouble();

            ElectricityConnection connection = null;

            switch (type) {
                case "HOME":
                    connection = new HomeConnection(units);
                    break;
                case "SHOP":
                    connection = new ShopConnection(units);
                    break;
                case "FACTORY":
                    connection = new FactoryConnection(units);
                    break;
            }

            if (connection != null) {
                double bill = connection.calculateBill();
                totalBilled += bill;
                System.out.printf("%s: %.2f%n", type, bill);
            }
        }

        System.out.printf("Total: %.2f%n", totalBilled);

        scanner.close();
    }
}