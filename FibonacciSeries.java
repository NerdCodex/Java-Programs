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
