package class_problems;

// Class defining Student instance members and shared static variables
class Student {
    // Instance fields unique to each object
    String name;
    double attendance;

    // Static fields shared across all instances of the class
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor updating instance state and incrementing global student count
    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++; // Increments once every time a new object is instantiated
    }

    // Static method printing class-level college information without referencing instance variables
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class question5 {

    public static void main(String[] args) {
        // Instantiate two Student objects directly
        new Student("Aarav", 85.5);
        new Student("Diya", 92.0);

        // Call printCollegeInfo through the class name directly
        Student.printCollegeInfo();
    }
}