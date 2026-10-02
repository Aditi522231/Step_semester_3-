package class_problems;

// Class defining IdCard fields
class IdCard {
    String name;
    int booksIssued;

    // Constructor to initialize name and booksIssued
    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class question4 {

    public static void main(String[] args) {
        // 1. Create one IdCard object for Ravi
        IdCard ravi = new IdCard("Ravi", 0);

        // 2. Assign a second variable to point at that same object reference
        IdCard duplicate = ravi;

        // 3. Through the second variable, modify booksIssued
        duplicate.booksIssued = 3;

        // 4. Print booksIssued accessed via the first variable and reference equality check
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // 5. Create a third, separate IdCard object with identical field values
        IdCard separate = new IdCard("Ravi", 3);

        // 6. Print reference equality check between separate and ravi
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}