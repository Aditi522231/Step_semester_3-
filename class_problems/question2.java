package class_problems;

import java.util.Scanner;

public class question2 {

    // Base abstract class representing a staff member (cannot be instantiated directly)
    public static abstract class Staff {
        protected String name;

        public Staff(String name) {
            this.name = name;
        }

        public abstract double calculateWeeklyPay();
    }

    public static class FullTimeStaff extends Staff {
        private double weeklySalary;

        public FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        public double calculateWeeklyPay() {
            return weeklySalary;
        }
    }

    public static class HourlyStaff extends Staff {
        private double hours;
        private double rate;

        public HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        public double calculateWeeklyPay() {
            if (hours <= 40) {
                return hours * rate;
            } else {
                // First 40 hours at normal rate, hours above 40 at 1.5 * rate
                return (40 * rate) + ((hours - 40) * (1.5 * rate));
            }
        }
    }

    public static class InternStaff extends Staff {
        private double stipend;

        public InternStaff(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        public double calculateWeeklyPay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        double totalPayroll = 0.0;

        for (int i = 0; i < n; i++) {
            String staffType = scanner.next().toUpperCase();
            String name = scanner.next();

            Staff staff = null;

            switch (staffType) {
                case "FULLTIME":
                    double weeklySalary = scanner.nextDouble();
                    staff = new FullTimeStaff(name, weeklySalary);
                    break;
                case "HOURLY":
                    double hours = scanner.nextDouble();
                    double rate = scanner.nextDouble();
                    staff = new HourlyStaff(name, hours, rate);
                    break;
                case "INTERN":
                    double stipend = scanner.nextDouble();
                    staff = new InternStaff(name, stipend);
                    break;
            }

            if (staff != null) {
                double pay = staff.calculateWeeklyPay();
                totalPayroll += pay;
                System.out.printf("%s: %.2f%n", name, pay);
            }
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);

        scanner.close();
    }
}
