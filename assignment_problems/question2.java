package assignment_problems;

import java.util.Scanner;

public class question2 {

    // Interface representing insurability for parcels that support insurance
    public interface Insurable {
        double calculateInsurance();
    }

    // Base abstract class for all parcel types
    public static abstract class Parcel {
        protected double weightKg;
        protected double declaredValue;

        public Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        public abstract double calculateBaseCharge();

        public double getInsuranceAmount() {
            if (this instanceof Insurable) {
                return ((Insurable) this).calculateInsurance();
            }
            return 0.0;
        }

        public double calculateTotal() {
            return calculateBaseCharge() + getInsuranceAmount();
        }
    }

    public static class StandardParcel extends Parcel {
        public StandardParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        public double calculateBaseCharge() {
            return 40.0 + (10.0 * weightKg);
        }
    }

    public static class ExpressParcel extends Parcel implements Insurable {
        public ExpressParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        public double calculateBaseCharge() {
            return 80.0 + (15.0 * weightKg);
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }
    }

    public static class FragileParcel extends Parcel implements Insurable {
        public FragileParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        public double calculateBaseCharge() {
            // Standard charge (40 + 10 per kg) plus a handling fee of 50
            return (40.0 + (10.0 * weightKg)) + 50.0;
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
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
            String type = scanner.next();
            double weightKg = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            Parcel parcel = null;

            switch (type.toUpperCase()) {
                case "STANDARD":
                    parcel = new StandardParcel(weightKg, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weightKg, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weightKg, declaredValue);
                    break;
            }

            if (parcel != null) {
                double charge = parcel.calculateBaseCharge();
                double insurance = parcel.getInsuranceAmount();
                double total = parcel.calculateTotal();

                grandTotal += total;

                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                        type, charge, insurance, total);
            }
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        scanner.close();
    }
}