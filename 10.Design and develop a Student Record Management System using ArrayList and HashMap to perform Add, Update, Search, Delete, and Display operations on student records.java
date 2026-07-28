import java.util.List;
import java.util.Scanner;

/**
 * StudentDBMSApp.java
 * Console front-end for the Student Database Management System.
 * Presents a menu and delegates all data operations to StudentDAO.
 */
public class StudentDBMSApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {

        boolean running = true;

        System.out.println("=========================================");
        System.out.println(" STUDENT DATABASE MANAGEMENT SYSTEM (JDBC)");
        System.out.println("=========================================");

        while (running) {

            printMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> viewStudentById();
                case 4 -> searchStudentsByName();
                case 5 -> updateStudent();
                case 6 -> deleteStudent();

                case 0 -> {
                    running = false;
                    System.out.println("Exiting. Goodbye!");
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {

        System.out.println("---------------------------------------");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. View Student by ID");
        System.out.println("4. Search Students by Name");
        System.out.println("5. Update Student");
        System.out.println("6. Delete Student");
        System.out.println("0. Exit");
        System.out.println("---------------------------------------");
    }

    // ---------------- Menu Actions ----------------

    private static void addStudent() {

        System.out.println("\n-- Add New Student --");

        String name = readString("Name: ");
        int age = readInt("Age: ");
        String course = readString("Course: ");
        String email = readString("Email: ");
        double marks = readDouble("Marks: ");

        Student student = new Student(name, age, course, email, marks);

        boolean success = studentDAO.addStudent(student);

        if (success) {
            System.out.println("Student added successfully with ID: " + student.getId());
        } else {
            System.out.println("Failed to add student.");
        }
    }

    private static void viewAllStudents() {

        System.out.println("\n-- All Students --");

        List<Student> students = studentDAO.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}
