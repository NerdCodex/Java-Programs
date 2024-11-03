import java.io.DataInputStream;
import java.io.IOException;

class Employee {
    private int employeeId;
    private String name;
    private String department;

    // Constructor to initialize employee information
    public Employee(int employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    // Method to display employee information
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}

public class EmployeeConstructor {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);

        try {
            System.out.print("Enter Employee ID: ");
            int employeeId = Integer.parseInt(input.readLine());

            System.out.print("Enter Employee Name: ");
            String name = input.readLine();

            System.out.print("Enter Employee Department: ");
            String department = input.readLine();

            // Create an Employee object using the constructor
            Employee employee = new Employee(employeeId, name, department);

            // Display the employee information
            System.out.println("\nEmployee Information:");
            employee.displayInfo();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid values.");
        }
    }
}
