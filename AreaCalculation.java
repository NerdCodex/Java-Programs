import java.io.DataInputStream;
import java.io.IOException;

class Rectangle {
    public double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}

class Triangle {
    public double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
}

class Square {
    public double side;

    public Square(double side) {
        this.side = side;
    }
    
}

class AreaCalculator {
    // Method to calculate the area of a rectangle
    public double calculateArea(Rectangle r) {
        return r.length * r.width;
    }

    // Method to calculate the area of a square
    public double calculateArea(Square s) {
        return s.side * s.side;
    }

    // Method to calculate the area of a triangle
    public double calculateArea(Triangle t) {
        return 0.5 * t.base * t.height;
    }
}

public class AreaCalculation {
    public static void main(String[] args) {
        DataInputStream input = new DataInputStream(System.in);
        AreaCalculator areaCalculator = new AreaCalculator();

        try {
            // Calculate area of Rectangle
            System.out.print("Enter length of the rectangle: ");
            double length = Double.parseDouble(input.readLine());
            System.out.print("Enter width of the rectangle: ");
            double width = Double.parseDouble(input.readLine());
            double rectangleArea = areaCalculator.calculateArea(new Rectangle(length, width));
            System.out.println("Area of Rectangle: " + rectangleArea);

            // Calculate area of Square
            System.out.print("Enter side length of the square: ");
            double side = Double.parseDouble(input.readLine());
            double squareArea = areaCalculator.calculateArea(new Square(side));
            System.out.println("Area of Square: " + squareArea);

            // Calculate area of Triangle
            System.out.print("Enter base of the triangle: ");
            double base = Double.parseDouble(input.readLine());
            System.out.print("Enter height of the triangle: ");
            double height = Double.parseDouble(input.readLine());
            double triangleArea = areaCalculator.calculateArea(new Triangle(base, height));
            System.out.println("Area of Triangle: " + triangleArea);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        }
    }
}
