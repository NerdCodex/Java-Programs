import java.io.DataInputStream;
import java.io.IOException;

class Employee {
    // Attributes of the Employee class
    private String name;
    private int employeeId;
    private String designation;
    private double salary;

    // Method to read employee information
    public void readEmployeeInfo(DataInputStream input) throws IOException {
        System.out.print("Enter Employee Name: ");
        this.name = input.readLine();
        
        System.out.print("Enter Employee ID: ");
        this.employeeId = Integer.parseInt(input.readLine());
        
        System.out.print("Enter Designation: ");
        this.designation = input.readLine();
        
        System.out.print("Enter Salary: ");
        this.salary = Double.parseDouble(input.readLine());
    }

    // Method to display employee information
    public void displayEmployeeInfo() {
        System.out.println("\nEmployee Information:");
        System.out.println("Name: " + this.name);
        System.out.println("Employee ID: " + this.employeeId);
        System.out.println("Designation: " + this.designation);
        System.out.println("Salary: " + this.salary);
    }
}

// Main class to test the Employee class
public class EmployeeInfo {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);
        Employee employee = new Employee();

        try {
            // Read employee information
            employee.readEmployeeInfo(input);

            // Display employee information
            employee.displayEmployeeInfo();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter the correct data types.");
        }
    }
}
