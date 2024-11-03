
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
