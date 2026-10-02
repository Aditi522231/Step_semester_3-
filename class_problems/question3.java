package class_problems;

// Immutable class encapsulating name tag parsing and formatting
class NameTag {
    private final String firstName;
    private final String lastName;

    // Constructor splits the full name once and stores parts in final fields
    public NameTag(String fullName) {
        String[] parts = fullName.trim().split(" ");
        this.firstName = parts[0];
        this.lastName = (parts.length > 1) ? parts[1] : "";
    }

    // Returns formatted nickname (First Name + Last Initial + .)
    public String getNickname() {
        if (!this.lastName.isEmpty()) {
            return this.firstName + " " + this.lastName.charAt(0) + ".";
        }
        return this.firstName;
    }

    // Read-only getter for first name
    public String getFirstName() {
        return this.firstName;
    }

    // Read-only getter for last name
    public String getLastName() {
        return this.lastName;
    }
}

public class question3 {

    public static void main(String[] args) {
        // Instantiate NameTag with sample full name
        NameTag tag = new NameTag("Maria Gomez");

        // Display nickname output matching expected behavior
        System.out.println("tag.getNickname() -> \"" + tag.getNickname() + "\"");
    }
}
