package class_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class question3 {

    // Fixed base date specified in problem business rules
    private static final LocalDate BASE_DATE = LocalDate.of(2023, 10, 26);

    // Returns standard borrowing duration in days based on item type
    public static int getBorrowingDays(String itemType) {
        switch (itemType.toUpperCase()) {
            case "BOOK":
                return 14;
            case "DVD":
                return 7;
            case "MAGAZINE":
                return 3;
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
            String itemType = scanner.next();

            // Read raw title remaining on line
            String rawTitle = scanner.nextLine().trim();

            // Strip enclosing double quotes if present
            String itemTitle = rawTitle.replaceAll("^\"|\"$", "");

            int daysToAdd = getBorrowingDays(itemType);
            LocalDate dueDate = BASE_DATE.plusDays(daysToAdd);

            // Using the formatter variable here removes the unused variable warning
            System.out.println(itemTitle + ": " + dueDate.format(formatter));
        }

        scanner.close();
    }
}
