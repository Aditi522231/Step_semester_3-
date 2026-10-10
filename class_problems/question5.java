package class_problems;

import java.util.Scanner;

public class question5 {

    // Single source of truth for the mandatory booking fee
    private static final double BOOKING_FEE = 50.0;

    // Base abstract class representing a travel booking
    public static abstract class TravelBooking {
        protected double distanceKm;

        public TravelBooking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        public abstract double getBaseFare();

        public double calculateTotalFare() {
            return getBaseFare() + BOOKING_FEE;
        }
    }

    public static class BusBooking extends TravelBooking {
        public BusBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        public double getBaseFare() {
            // Bus fare: 2 per km
            return distanceKm * 2.0;
        }
    }

    public static class TrainBooking extends TravelBooking {
        public TrainBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        public double getBaseFare() {
            // Train fare: 1.5 per km
            return distanceKm * 1.5;
        }
    }

    public static class FlightBooking extends TravelBooking {
        public FlightBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        public double getBaseFare() {
            // Flight fare: 2500 plus 4 per km
            return 2500.0 + (distanceKm * 4.0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next().toUpperCase();
            double distanceKm = scanner.nextDouble();

            TravelBooking booking = null;

            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distanceKm);
                    break;
                case "TRAIN":
                    booking = new TrainBooking(distanceKm);
                    break;
                case "FLIGHT":
                    booking = new FlightBooking(distanceKm);
                    break;
            }

            if (booking != null) {
                double total = booking.calculateTotalFare();
                System.out.printf("%s: %.2f%n", mode, total);
            }
        }

        scanner.close();
    }
}
