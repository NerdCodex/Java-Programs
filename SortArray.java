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
