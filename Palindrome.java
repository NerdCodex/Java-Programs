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
