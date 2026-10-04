package assignment_problems;

import java.util.Scanner;

public class question46_class {

    // Single source of truth for the mandatory convenience fee
    private static final double CONVENIENCE_FEE = 20.0;

    // Abstract base class representing a ticket (cannot be instantiated directly)
    public static abstract class Ticket {
        protected int count;

        public Ticket(int count) {
            this.count = count;
        }

        // Returns base price per seat (implemented by subclass)
        public abstract double getBasePrice();

        // Calculates total cost including convenience fee per ticket
        public double calculateTotalAmount() {
            return (getBasePrice() + CONVENIENCE_FEE) * count;
        }
    }

    public static class RegularTicket extends Ticket {
        public RegularTicket(int count) {
            super(count);
        }

        @Override
        public double getBasePrice() {
            return 150.0;
        }
    }

    public static class PremiumTicket extends Ticket {
        public PremiumTicket(int count) {
            super(count);
        }

        @Override
        public double getBasePrice() {
            return 250.0;
        }
    }

    public static class ReclinerTicket extends Ticket {
        public ReclinerTicket(int count) {
            super(count);
        }

        @Override
        public double getBasePrice() {
            return 400.0;
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
            String seatType = scanner.next();
            int count = scanner.nextInt();

            Ticket ticket = null;

            switch (seatType.toUpperCase()) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
            }

            if (ticket != null) {
                double bookingAmount = ticket.calculateTotalAmount();
                totalCollected += bookingAmount;
                System.out.printf("%s: %.2f%n", seatType, bookingAmount);
            }
        }

        System.out.printf("Total: %.2f%n", totalCollected);

        scanner.close();
    }
}
