import java.io.DataInputStream;
import java.io.IOException;

// Class to store student information
class Student {
    String studentName;
    int registerNumber;

    // Constructor for the Student class
    public Student(String studentName, int registerNumber) {
        this.studentName = studentName;
        this.registerNumber = registerNumber;
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Register Number: " + registerNumber);
    }
}

// Class to store marks, which inherits from Student
class Marks extends Student {
    int[] subjectMarks = new int[5];

    // Constructor for the Marks class
    public Marks(String studentName, int registerNumber, int[] subjectMarks) {
        super(studentName, registerNumber); // Call the parent class constructor
        this.subjectMarks = subjectMarks;
    }

    // Method to display marks for the five subjects
    public void displayMarks() {
        System.out.println("Marks in Five Subjects:");
        for (int i = 0; i < subjectMarks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + subjectMarks[i]);
        }
    }
}

// Main class to test the Student and Marks classes
public class StudentInfo {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);

        try {
            // Input student information
            System.out.print("Enter Student Name: ");
            String studentName = input.readLine();
            System.out.print("Enter Register Number: ");
            int registerNumber = Integer.parseInt(input.readLine());

            // Input marks for five subjects
            int[] marks = new int[5];
            for (int i = 0; i < 5; i++) {
                System.out.print("Enter marks for Subject " + (i + 1) + ": ");
                marks[i] = Integer.parseInt(input.readLine());
            }

            // Create a Marks object and display the information
            Marks student = new Marks(studentName, registerNumber, marks);

            // Display student information and marks
            System.out.println("\nStudent Information:");
            student.displayStudentInfo();
            student.displayMarks();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter the correct data types.");
        }
    }
}
