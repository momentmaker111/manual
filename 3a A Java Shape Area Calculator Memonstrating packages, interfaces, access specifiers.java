import java.util.Scanner;

// ---------- Abstract Class ----------
abstract class Shape {

    // Abstract method
    public abstract double calculateArea();

    // Concrete method
    public void displayArea() {
        System.out.println("Area = " + calculateArea());
    }
}

// ---------- Circle ----------
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// ---------- Rectangle ----------
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// ---------- Triangle ----------
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// ---------- Main Class ----------
public class ShapeAreaCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Shape Area Calculator =====");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.print("
