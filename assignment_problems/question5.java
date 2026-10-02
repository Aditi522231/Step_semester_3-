package assignment_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class question5{

    // Returns validity period in days based on subscription plan type
    public static int getPlanValidityDays(String planType) {
        switch (planType.toUpperCase()) {
            case "BASIC":
                return 30;
            case "STANDARD":
                return 90;
            case "PREMIUM":
                return 365;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String planType = scanner.next();
            String name = scanner.next();
            String startDateStr = scanner.next();

            LocalDate startDate = LocalDate.parse(startDateStr, formatter);
            int daysToAdd = getPlanValidityDays(planType);
            LocalDate renewalDate = startDate.plusDays(daysToAdd);

            System.out.println(name + ": " + renewalDate.format(formatter));
        }

        scanner.close();
    }
}
