package class_problems;

import java.util.Scanner;

public class question3 {

    // Base abstract class representing a library item with late fine logic
    public static abstract class LibraryItem {
        protected String title;
        protected int daysLate;

        public LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        public abstract double calculateFine();
    }

    public static class BookItem extends LibraryItem {
        public BookItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            // Books: 2 per day late
            return daysLate * 2.0;
        }
    }

    public static class DvdItem extends LibraryItem {
        public DvdItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            // DVDs: 5 per day late, up to a maximum of 50
            double fine = daysLate * 5.0;
            return Math.min(50.0, fine);
        }
    }

    public static class MagazineItem extends LibraryItem {
        public MagazineItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            // Magazines: 1 per day late
            return daysLate * 1.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        double totalFines = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next().toUpperCase();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            LibraryItem item = null;

            switch (type) {
                case "BOOK":
                    item = new BookItem(title, daysLate);
                    break;
                case "DVD":
                    item = new DvdItem(title, daysLate);
                    break;
                case "MAGAZINE":
                    item = new MagazineItem(title, daysLate);
                    break;
            }

            if (item != null) {
                double fine = item.calculateFine();
                totalFines += fine;
                System.out.printf("%s: %.2f%n", title, fine);
            }
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);

        scanner.close();
    }
}
