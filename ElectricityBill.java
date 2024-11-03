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
