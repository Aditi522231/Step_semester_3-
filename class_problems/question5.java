package class_problems;

// Class encapsulating attendance sheet logic with duplicate checking and hidden full roster
class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    // Constructor setting maximum class capacity
    public AttendanceSheet(int maxCapacity) {
        this.presentStudents = new String[maxCapacity];
        this.count = 0;
    }

    // Marks a student present if not already added and capacity permits
    public void markPresent(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            return;
        }

        // Avoid duplicate entries
        if (isPresent(studentName)) {
            return;
        }

        if (this.count < this.presentStudents.length) {
            this.presentStudents[this.count] = studentName;
            this.count++;
        } else {
            System.out.println("Attendance sheet is full. Cannot add: " + studentName);
        }
    }

    // Checks whether a specific student name is present
    public boolean isPresent(String studentName) {
        if (studentName == null) {
            return false;
        }

        for (int i = 0; i < this.count; i++) {
            if (this.presentStudents[i].equalsIgnoreCase(studentName)) {
                return true;
            }
        }
        return false;
    }

    // Read-only getter for present student count
    public int getPresentCount() {
        return this.count;
    }
}

public class question5 {

    public static void main(String[] args) {
        // Instantiate AttendanceSheet for 30 students
        AttendanceSheet sheet = new AttendanceSheet(30);

        // Mark present with duplicate test
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        // Display results matching sample output
        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}