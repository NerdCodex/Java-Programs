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
