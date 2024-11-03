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
