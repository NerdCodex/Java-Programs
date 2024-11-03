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
