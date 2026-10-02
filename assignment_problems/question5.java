package assignment_problems;

// Class defining employee instance members and shared static variables
class Employee {
    // Instance fields unique to each object
    String empName;
    double salary;

    // Static fields shared across all instances of the class
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor updating instance state and incrementing global employee count
    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // Increments once every time a new object is instantiated
    }

    // Static method printing class-level company information without referencing instance variables
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class question5 {

    public static void main(String[] args) {
        // Instantiate three Employee objects
        Employee emp1 = new Employee("Aarav", 50000);
        Employee emp2 = new Employee("Diya", 60000);
        Employee emp3 = new Employee("Rohan", 55000);

        // Call printCompanyInfo through the class name directly
        Employee.printCompanyInfo();
    }
}