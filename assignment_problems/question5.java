package assignment_problems;

import java.util.Scanner;

public class question5 {

    // Interface representing saver mode capability for appliances that support it
    public interface EnergySaver {
        double applySaverMode(double units);
    }

    // Base abstract class for all home appliances
    public static abstract class Appliance {
        protected double hours;
        protected boolean requestSaver;

        public Appliance(double hours, boolean requestSaver) {
            this.hours = hours;
            this.requestSaver = requestSaver;
        }

        public abstract double getPowerRatingWatts();

        // Calculates energy units (kWh) and applies saver mode if requested and supported
        public double calculateUnits() {
            double baseUnits = (getPowerRatingWatts() * hours) / 1000.0;

            if (requestSaver) {
                if (this instanceof EnergySaver) {
                    return ((EnergySaver) this).applySaverMode(baseUnits);
                } else {
                    return -1.0; // Indicates saver mode not supported
                }
            }
            return baseUnits;
        }
    }

    public static class Fridge extends Appliance {
        public Fridge(double hours, boolean requestSaver) {
            super(hours, requestSaver);
        }

        @Override
        public double getPowerRatingWatts() {
            return 150.0;
        }
    }

    public static class AcAppliance extends Appliance implements EnergySaver {
        public AcAppliance(double hours, boolean requestSaver) {
            super(hours, requestSaver);
        }

        @Override
        public double getPowerRatingWatts() {
            return 1500.0;
        }

        @Override
        public double applySaverMode(double units) {
            return units * 0.75; // Reduces energy use by 25%
        }
    }

    public static class Tv extends Appliance {
        public Tv(double hours, boolean requestSaver) {
            super(hours, requestSaver);
        }

        @Override
        public double getPowerRatingWatts() {
            return 100.0;
        }
    }

    public static class Washer extends Appliance implements EnergySaver {
        public Washer(double hours, boolean requestSaver) {
            super(hours, requestSaver);
        }

        @Override
        public double getPowerRatingWatts() {
            return 500.0;
        }

        @Override
        public double applySaverMode(double units) {
            return units * 0.75; // Reduces energy use by 25%
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String applianceType = scanner.next().toUpperCase();
            double hours = scanner.nextDouble();

            boolean requestSaver = false;
            // Check if there is an additional "SAVER" token on the same line
            if (scanner.hasNext("[a-zA-Z]+")) {
                String nextToken = scanner.next();
                if ("SAVER".equalsIgnoreCase(nextToken)) {
                    requestSaver = true;
                }
            }

            Appliance appliance = null;

            switch (applianceType) {
                case "FRIDGE":
                    appliance = new Fridge(hours, requestSaver);
                    break;
                case "AC":
                    appliance = new AcAppliance(hours, requestSaver);
                    break;
                case "TV":
                    appliance = new Tv(hours, requestSaver);
                    break;
                case "WASHER":
                    appliance = new Washer(hours, requestSaver);
                    break;
            }

            if (appliance != null) {
                double units = appliance.calculateUnits();
                if (units < 0) {
                    System.out.println(applianceType + ": saver mode not supported");
                } else {
                    double cost = units * 8.0;
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f%n", applianceType, units, cost);
                }
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        scanner.close();
    }
}