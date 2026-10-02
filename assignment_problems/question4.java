package assignment_problems;

import java.util.Scanner;

public class question4 {

    // Calculates festival bonus based on employee type and monthly salary
    public static double calculateBonus(String employeeType, double monthlySalary) {
        switch (employeeType.toUpperCase()) {
            case "FULLTIME":
                // Full-time employees get 10% of their monthly salary
                return monthlySalary * 0.10;
            case "PARTTIME":
                // Part-time employees get 5% of their monthly salary
                return monthlySalary * 0.05;
            case "INTERN":
                // Interns get a fixed bonus of ₹2,000, whatever their salary
                return 2000.0;
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
        double grandTotalBonus = 0.0;

        for (int i = 0; i < n; i++) {
            String employeeType = scanner.next();
            String name = scanner.next();
            double monthlySalary = scanner.nextDouble();

            double bonus = calculateBonus(employeeType, monthlySalary);
            grandTotalBonus += bonus;

            System.out.printf("%s: %.2f%n", name, bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", grandTotalBonus);

        scanner.close();
    }
}