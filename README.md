# Java CIA Programs

### 1. Write a java program to find whether the given number is Armstrong or not.
```java
// ArmstrongNumber.java
import java.io.DataInputStream;
import java.io.IOException;

public class ArmstrongNumber {
    public static void main(String[] args) {
        DataInputStream ds = new DataInputStream(System.in);
        int number=0;

        // Input the number from the user
        System.out.print("Enter a number: ");
        try {
            number = Integer.parseInt(ds.readLine());
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        int originalNumber = number;
        int result = 0;
        int numberOfDigits = String.valueOf(number).length();

        // Calculate the sum of the digits raised to the power of the number of digits
        while (number != 0) {
            int digit = number % 10;
            result += Math.pow(digit, numberOfDigits);
            number /= 10;
        }

        // Check if the result equals the original number
        if (result == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
    }
}
```

### 2. Define three classes namely Customer (Name, Customer Number), Address(House Number, street, place and city), Purchase (Item name, Item Number, Amount per quantity). Write a java program to display the customer information. (Use Multilevel Inheritance).
```java
// CustomerInfo.java
class Customer {
    String name;
    int customerNumber;

    // Constructor for Customer class
    public Customer(String name, int customerNumber) {
        this.name = name;
        this.customerNumber = customerNumber;
    }

    // Method to display customer information
    public void displayCustomerInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Customer Number: " + customerNumber);
    }
}

// Derived class from Customer
class Address extends Customer {
    String houseNumber;
    String street;
    String place;
    String city;

    // Constructor for Address class
    public Address(String name, int customerNumber, String houseNumber, String street, String place, String city) {
        super(name, customerNumber); // Call the base class constructor
        this.houseNumber = houseNumber;
        this.street = street;
        this.place = place;
        this.city = city;
    }

    // Method to display address information
    public void displayAddressInfo() {
        System.out.println("House Number: " + houseNumber);
        System.out.println("Street: " + street);
        System.out.println("Place: " + place);
        System.out.println("City: " + city);
    }
}

// Derived class from Address
class Purchase extends Address {
    String itemName;
    int itemNumber;
    double amountPerQuantity;

    // Constructor for Purchase class
    public Purchase(String name, int customerNumber, String houseNumber, String street, String place, String city, 
                    String itemName, int itemNumber, double amountPerQuantity) {
        super(name, customerNumber, houseNumber, street, place, city); // Call the Address class constructor
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.amountPerQuantity = amountPerQuantity;
    }

    // Method to display purchase information
    public void displayPurchaseInfo() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Number: " + itemNumber);
        System.out.println("Amount per Quantity: " + amountPerQuantity);
    }
}

// Main class
public class CustomerInfo {
    public static void main(String[] args) {
        // Create a Purchase object and display all the information
        Purchase purchase = new Purchase("John Doe", 12345, "12A", "Maple Street", "Downtown", "New York",
                                         "Laptop", 101, 799.99);

        // Display all information
        System.out.println("Customer Information:");
        purchase.displayCustomerInfo();
        System.out.println("\nAddress Information:");
        purchase.displayAddressInfo();
        System.out.println("\nPurchase Information:");
        purchase.displayPurchaseInfo();
    }
}
```

### 3. Write a java program to find the factorial of the given number.
```java
import java.io.DataInputStream;
import java.io.IOException;

public class Factorial {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);

        try {
            // Input the number from the user
            System.out.print("Enter a number: ");
            int number = Integer.parseInt(input.readLine());
            long factorial = 1;

            // Calculate factorial
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            // Output the result
            System.out.println("Factorial of " + number + " is: " + factorial);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}
```

### 4. Define two classes namely Student (Student name, Register number), Marks(Five subject marks). Write a java program to display the information’s about a student.
```java
// StudentInfo.java
import java.io.DataInputStream;
import java.io.IOException;

// Class to store student information
class Student {
    String studentName;
    int registerNumber;

    // Constructor for the Student class
    public Student(String studentName, int registerNumber) {
        this.studentName = studentName;
        this.registerNumber = registerNumber;
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Register Number: " + registerNumber);
    }
}

// Class to store marks, which inherits from Student
class Marks extends Student {
    int[] subjectMarks = new int[5];

    // Constructor for the Marks class
    public Marks(String studentName, int registerNumber, int[] subjectMarks) {
        super(studentName, registerNumber); // Call the parent class constructor
        this.subjectMarks = subjectMarks;
    }

    // Method to display marks for the five subjects
    public void displayMarks() {
        System.out.println("Marks in Five Subjects:");
        for (int i = 0; i < subjectMarks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + subjectMarks[i]);
        }
    }
}

// Main class to test the Student and Marks classes
public class StudentInfo {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);

        try {
            // Input student information
            System.out.print("Enter Student Name: ");
            String studentName = input.readLine();
            System.out.print("Enter Register Number: ");
            int registerNumber = Integer.parseInt(input.readLine());

            // Input marks for five subjects
            int[] marks = new int[5];
            for (int i = 0; i < 5; i++) {
                System.out.print("Enter marks for Subject " + (i + 1) + ": ");
                marks[i] = Integer.parseInt(input.readLine());
            }

            // Create a Marks object and display the information
            Marks student = new Marks(studentName, registerNumber, marks);

            // Display student information and marks
            System.out.println("\nStudent Information:");
            student.displayStudentInfo();
            student.displayMarks();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter the correct data types.");
        }
    }
}
```

### 5. Define two classes called Customer (Acc number, customer name, Address, deposit amount), Transact (Withdraw amt). Write a java program to do the following operation.
  ### a.Withdraw amt.
  ### b.Balance Enquiry.
```java
// BankOperations.java
import java.io.DataInputStream;
import java.io.IOException;

// Class to store customer information
class Customer {
    int accountNumber;
    String customerName;
    String address;
    double depositAmount;

    // Constructor for the Customer class
    public Customer(int accountNumber, String customerName, String address, double depositAmount) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.address = address;
        this.depositAmount = depositAmount;
    }

    // Method to display customer information
    public void displayCustomerInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Address: " + address);
        System.out.println("Deposit Amount: " + depositAmount);
    }
}

// Class to handle transactions, inherits from Customer
class Transact extends Customer {

    // Constructor for the Transact class
    public Transact(int accountNumber, String customerName, String address, double depositAmount) {
        super(accountNumber, customerName, address, depositAmount); // Call the parent class constructor
    }

    // Method to withdraw amount
    public void withdrawAmount(double amount) {
        if (amount > depositAmount) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            depositAmount -= amount;
            System.out.println("Withdrawal successful. Amount withdrawn: " + amount);
            System.out.println("Updated Balance: " + depositAmount);
        }
    }

    // Method to display the balance
    public void balanceEnquiry() {
        System.out.println("Current Balance: " + depositAmount);
    }
}

// Main class to test the Customer and Transact classes
public class BankOperations {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);

        try {
            // Input customer information
            System.out.print("Enter Account Number: ");
            int accountNumber = Integer.parseInt(input.readLine());
            System.out.print("Enter Customer Name: ");
            String customerName = input.readLine();
            System.out.print("Enter Address: ");
            String address = input.readLine();
            System.out.print("Enter Deposit Amount: ");
            double depositAmount = Double.parseDouble(input.readLine());

            // Create a Transact object
            Transact customer = new Transact(accountNumber, customerName, address, depositAmount);

            // Display initial customer information
            System.out.println("\nCustomer Information:");
            customer.displayCustomerInfo();

            // Perform operations
            System.out.print("\nEnter amount to withdraw: ");
            double withdrawAmount = Double.parseDouble(input.readLine());
            customer.withdrawAmount(withdrawAmount);

            // Balance enquiry
            System.out.println("\nBalance Enquiry:");
            customer.balanceEnquiry();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter the correct data types.");
        }
    }
}
```

### 6. Write a java program to arrange the string in alphabetical order.
```java
// AlphabeticalOrder.java
import java.io.DataInputStream;
import java.io.IOException;

public class AlphabeticalOrder {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);

        try {
            // Ask the user for the number of words
            System.out.print("Enter the number of words: ");
            int numWords = Integer.parseInt(input.readLine());

            // Create an array to hold the words
            String[] words = new String[numWords];

            // Get each word from the user
            for (int i = 0; i < numWords; i++) {
                System.out.print("Enter word " + (i + 1) + ": ");
                words[i] = input.readLine();
            }

            // Use Bubble Sort to sort the words in alphabetical order
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = 0; j < words.length - i - 1; j++) {
                    if (words[j].compareToIgnoreCase(words[j + 1]) > 0) {
                        // Swap words[j] and words[j + 1]
                        String temp = words[j];
                        words[j] = words[j + 1];
                        words[j + 1] = temp;
                    }
                }
            }

            // Display the sorted words
            System.out.println("The words in alphabetical order are:");
            for (String word : words) {
                System.out.println(word);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter the correct data types.");
        }
    }
}
```

### 7. Write a java program to find the Fibonacci series for the given number.
```java
// FibonacciSeries.java
import java.io.DataInputStream;
import java.io.IOException;

public class FibonacciSeries {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);

        try {
            // Input the number of terms for the Fibonacci series
            System.out.print("Enter the number of terms for Fibonacci series: ");
            int terms = Integer.parseInt(input.readLine());

            // Initialize the first two terms
            int firstTerm = 0, secondTerm = 1;

            System.out.println("Fibonacci Series up to " + terms + " terms:");

            // Generate the Fibonacci series
            for (int i = 1; i <= terms; i++) {
                System.out.print(firstTerm + " ");

                // Calculate the next term
                int nextTerm = firstTerm + secondTerm;
                firstTerm = secondTerm; // Move to the next term
                secondTerm = nextTerm;   // Update the second term
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
```

### 8. Create a class called Employee for reading and writing the general information’s of an employee. Write a java program to display the Employee information.
```java
// EmployeeInfo.java
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
```

### 9. Write a java program to find the area of Rectangle, Square and Triangle. (Use Method Overloading).
```java
// AreaOperations.java
import java.io.DataInputStream;
import java.io.IOException;

class Rectangle {
    public double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}

class Triangle {
    public double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
}

class Square {
    public double side;

    public Square(double side) {
        this.side = side;
    }
    
}

class AreaCalculator {
    // Method to calculate the area of a rectangle
    public double calculateArea(Rectangle r) {
        return r.length * r.width;
    }

    // Method to calculate the area of a square
    public double calculateArea(Square s) {
        return s.side * s.side;
    }

    // Method to calculate the area of a triangle
    public double calculateArea(Triangle t) {
        return 0.5 * t.base * t.height;
    }
}

public class AreaCalculation {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);
        AreaCalculator areaCalculator = new AreaCalculator();

        try {
            // Calculate area of Rectangle
            System.out.print("Enter length of the rectangle: ");
            double length = Double.parseDouble(input.readLine());
            System.out.print("Enter width of the rectangle: ");
            double width = Double.parseDouble(input.readLine());
            double rectangleArea = areaCalculator.calculateArea(new Rectangle(length, width));
            System.out.println("Area of Rectangle: " + rectangleArea);

            // Calculate area of Square
            System.out.print("Enter side length of the square: ");
            double side = Double.parseDouble(input.readLine());
            double squareArea = areaCalculator.calculateArea(new Square(side));
            System.out.println("Area of Square: " + squareArea);

            // Calculate area of Triangle
            System.out.print("Enter base of the triangle: ");
            double base = Double.parseDouble(input.readLine());
            System.out.print("Enter height of the triangle: ");
            double height = Double.parseDouble(input.readLine());
            double triangleArea = areaCalculator.calculateArea(new Triangle(base, height));
            System.out.println("Area of Triangle: " + triangleArea);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        }
    }
}
```

### 10. Write a java program to read an array of N numbers and arrange it in ascending order.
```java
// ArraySort.java
import java.io.DataInputStream;
import java.io.IOException;

public class SortArray {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);

        try {
            System.out.print("Enter the number of elements in the array: ");
            int n = Integer.parseInt(input.readLine()); // Read number of elements

            int[] array = new int[n]; // Create array of size N

            // Read elements into the array
            System.out.println("Enter " + n + " numbers:");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(input.readLine());
            }

            // Sort the array using Bubble Sort
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        // Swap elements if they are in the wrong order
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }

            // Display the sorted array
            System.out.println("Sorted array in ascending order:");
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        }
    }
}
```

### 11. Create a class called employee for reading and writing the general information’s of an employee. (Use Constructors).
```java
// EmployeeConstructor.java
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
```

### 12. Write a java program to add two matrices.
```java
// MatrixAddition.java
import java.io.DataInputStream;
import java.io.IOException;

public class MatrixAddition {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);

        try {
            System.out.print("Enter the number of rows: ");
            int rows = Integer.parseInt(input.readLine());

            System.out.print("Enter the number of columns: ");
            int cols = Integer.parseInt(input.readLine());

            // Initialize matrices
            int[][] matrixA = new int[rows][cols];
            int[][] matrixB = new int[rows][cols];
            int[][] resultMatrix = new int[rows][cols];

            // Read elements of first matrix
            System.out.println("Enter elements of Matrix A:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    matrixA[i][j] = Integer.parseInt(input.readLine());
                }
            }

            // Read elements of second matrix
            System.out.println("Enter elements of Matrix B:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    matrixB[i][j] = Integer.parseInt(input.readLine());
                }
            }

            // Add the matrices
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }

            // Display the result
            System.out.println("Resulting Matrix after Addition:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(resultMatrix[i][j] + " ");
                }
                System.out.println();
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        }
    }
}
```

### 13. Define two classes called Customer ( Customer number, Customer name, address), Consumption (Old Meter Reading (OMR), Current Meter Reading (CMR)). Write a java program for preparing the electricity bill with the following conditions: (Use Inheritance).
| Units               | Price per Unit  |
|---------------------|------------------|
| <= 50 Units         | Rs. 1.00         |
| 50 < Units <= 150   | Rs. 1.50         |
| > 150 Units         | Rs. 2.60         |

```java
// ElectricityBill.java
import java.io.DataInputStream;
import java.io.IOException;

class Customer {
    private String customerNumber;
    private String customerName;
    private String address;

    // Constructor to initialize customer details
    public Customer(String customerNumber, String customerName, String address) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.address = address;
    }

    // Method to display customer information
    public void displayCustomerInfo() {
        System.out.println("Customer Number: " + customerNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Address: " + address);
    }
}

class Consumption extends Customer {
    private int oldMeterReading;
    private int currentMeterReading;

    // Constructor to initialize consumption details
    public Consumption(String customerNumber, String customerName, String address,
                       int oldMeterReading, int currentMeterReading) {
        super(customerNumber, customerName, address); // Call to Customer constructor
        this.oldMeterReading = oldMeterReading;
        this.currentMeterReading = currentMeterReading;
    }

    // Method to calculate units consumed
    public int calculateUnitsConsumed() {
        return currentMeterReading - oldMeterReading;
    }

    // Method to calculate bill amount based on units consumed
    public double calculateBill() {
        int units = calculateUnitsConsumed();
        double billAmount = 0.0;

        if (units <= 50) {
            billAmount = units * 1.00;
        } else if (units <= 150) {
            billAmount = (50 * 1.00) + ((units - 50) * 1.50);
        } else {
            billAmount = (50 * 1.00) + (100 * 1.50) + ((units - 150) * 2.60);
        }

        return billAmount;
    }

    // Method to display bill details
    public void displayBill() {
        displayCustomerInfo(); // Display customer info
        int units = calculateUnitsConsumed();
        double billAmount = calculateBill();
        System.out.println("Units Consumed: " + units);
        System.out.println("Total Bill Amount: Rs. " + billAmount);
    }
}

public class ElectricityBill {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);

        try {
            // Read customer details
            System.out.print("Enter Customer Number: ");
            String customerNumber = input.readLine();

            System.out.print("Enter Customer Name: ");
            String customerName = input.readLine();

            System.out.print("Enter Address: ");
            String address = input.readLine();

            // Read meter readings
            System.out.print("Enter Old Meter Reading: ");
            int oldMeterReading = Integer.parseInt(input.readLine());

            System.out.print("Enter Current Meter Reading: ");
            int currentMeterReading = Integer.parseInt(input.readLine());

            // Create a Consumption object
            Consumption consumption = new Consumption(customerNumber, customerName, address,
                    oldMeterReading, currentMeterReading);

            // Display the bill
            System.out.println("\nElectricity Bill:");
            consumption.displayBill();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid values.");
        }
    }
}
```

### 14. Write a java program to check whether the given string is palindrome or not.
```java
// Palindrome.java
import java.io.DataInputStream;
import java.io.IOException;

public class Palindrome {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);

        try {
            System.out.print("Enter a word: ");
            String word = input.readLine();

            // Call the function to check if the word is a palindrome
            if (isPalindrome(word)) {
                System.out.println(word + " is a palindrome.");
            } else {
                System.out.println(word + " is not a palindrome.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
        }
    }

    // Function to check if a word is a palindrome
    public static boolean isPalindrome(String word) {
        int left = 0; // Pointer to the start of the word
        int right = word.length() - 1; // Pointer to the end of the word

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }

        return true; // It is a palindrome
    }
}
```
