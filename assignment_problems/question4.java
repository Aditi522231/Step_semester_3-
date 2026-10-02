package assignment_problems;

// Class defining HallTicket fields
class HallTicket {
    String studentName;
    int seatNumber;

    // Constructor to initialize studentName and seatNumber
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class question4 {

    public static void main(String[] args) {
        // 1. Create one HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);

        // 2. Assign a second variable to point at the exact same object reference
        HallTicket copy = priya;

        // 3. Through the second variable, modify seatNumber
        copy.seatNumber = 45;

        // 4. Print seatNumber accessed via the first variable and reference equality check
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        // 5. Create a third, separate HallTicket object with identical field values
        HallTicket separate = new HallTicket("Priya", 45);

        // 6. Print reference equality check between separate and priya
        System.out.println("separate == priya: " + (separate == priya));
    }
}
