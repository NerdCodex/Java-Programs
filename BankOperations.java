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
