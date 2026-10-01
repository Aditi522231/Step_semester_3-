package class_problems;

public class question2 {

    // Parses a CSV student record and prints the formatted output or validation error
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Split the CSV string by comma
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            // Extract and trim fields to format output
            String name = fields[0].trim();
            String rollNo = fields[1].trim();
            String dept = fields[2].trim();

            System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
        }
    }

    public static void main(String[] args) {
        // Sample test case from table
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
    }
}