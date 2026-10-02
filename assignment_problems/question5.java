package assignment_problems;

class Employee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class question5 {

    public static void main(String[] args) {
        // Instantiate three Employee objects directly without storing unread variables
        new Employee("Aarav", 50000);
        new Employee("Diya", 60000);
        new Employee("Rohan", 55000);

        // Call printCompanyInfo through the class name directly
        Employee.printCompanyInfo();
    }
}