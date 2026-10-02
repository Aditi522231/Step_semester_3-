package assignment_problems;

// Class definition representing a single book entry
class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    // Constructor initializing all three fields
    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Instance method printing one formatted line
    public void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }
}

public class question1 {

    public static void main(String[] args) {
        // Create four BookInventory objects
        BookInventory[] inventory = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        // Print each book entry in a loop
        for (BookInventory book : inventory) {
            book.printEntry();
        }
    }
}
