package assignment_problems;

import java.util.Scanner;

public class question3 {

    // Base abstract class representing a Student
    public static abstract class Student {
        protected String name;

        public Student(String name) {
            this.name = name;
        }

        public abstract double calculateTotalFee();
    }

    public static class DayScholar extends Student {
        public DayScholar(String name) {
            super(name);
        }

        @Override
        public double calculateTotalFee() {
            // Tuition 40000 + Bus Transport Fee 12000
            return 40000.0 + 12000.0;
        }
    }

    public static class Hosteller extends Student {
        public Hosteller(String name) {
            super(name);
        }

        @Override
        public double calculateTotalFee() {
            // Tuition 40000 + Hostel Fee 60000 (No Bus Fee)
            return 40000.0 + 60000.0;
        }
    }

    public static class Scholar extends Student {
        public Scholar(String name) {
            super(name);
        }

        @Override
        public double calculateTotalFee() {
            // Half Tuition 20000 + Bus Transport Fee 12000
            return 20000.0 + 12000.0;
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
            String type = scanner.next();
            String name = scanner.next();

            Student student = null;

            switch (type.toUpperCase()) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
            }

            if (student != null) {
                double fee = student.calculateTotalFee();
                totalCollected += fee;

                System.out.printf("%s: %.2f%n", name, fee);
            }
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        scanner.close();
    }
}
