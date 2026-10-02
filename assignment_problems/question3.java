package assignment_problems;

// Class defining employee profile and constructor chaining
class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Overloaded constructor for interns chaining to the 3-argument constructor
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    // Method to print all fields on one line
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class question3 {

    public static void main(String[] args) {
        // Create permanent employee
        Employee emp1 = new Employee("E-101", "Divya", 65000);

        // Create intern employee
        Employee emp2 = new Employee("E-102", "Arjun");

        // Print profiles
        emp1.printProfile();
        emp2.printProfile();
    }
}