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
