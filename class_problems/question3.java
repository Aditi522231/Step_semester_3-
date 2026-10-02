package class_problems;

// Class representing course details and credit calculation
class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    // 4-argument constructor setting all fields directly
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // 3-argument constructor for theory-only courses, chaining via this(...)
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    // Method calculating total credits
    public int totalCredits() {
        return this.credits + this.labCredits;
    }
}

public class question3 {

    public static void main(String[] args) {
        // Instantiate theory-only course using 3-argument constructor
        Course course1 = new Course("21CSC201J", "Data Structures", 4);

        // Instantiate course with lab component using 4-argument constructor
        Course course2 = new Course("21CSC205L", "DSA Lab", 3, 1);

        // Print total credits for both
        System.out.println(course1.code + " total credits: " + course1.totalCredits());
        System.out.println(course2.code + " total credits: " + course2.totalCredits());
        // Expected Output:
        // 21CSC201J total credits: 4
        // 21CSC205L total credits: 4
    }
}
