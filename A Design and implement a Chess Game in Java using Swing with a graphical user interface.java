private static void viewStudentById() {

    System.out.println("\n-- View Student by ID --");

    int id = readInt("Enter student ID: ");
    Student student = studentDAO.getStudentById(id);

    if (student != null) {
        System.out.println(student);
    } else {
        System.out.println("No student found with ID: " + id);
    }
}

private static void searchStudentsByName() {

    System.out.println("\n-- Search Students by Name --");

    String name = readString("Enter name (or part of it): ");
    List<Student> results = studentDAO.searchByName(name);

    if (results.isEmpty()) {
        System.out.println("No matching students found.");
    } else {
        for (Student s : results) {
            System.out.println(s);
        }
    }
}

private static void updateStudent() {

    System.out.println("\n-- Update Student --");

    int id = readInt("Enter ID of student to update: ");

    Student existing = studentDAO.getStudentById(id);

    if (existing == null) {
        System.out.println("No student found with ID: " + id);
        return;
    }

    System.out.println("Current record: " + existing);
    System.out.println("Enter new values (leave blank to keep current value):");

    String name = readOptionalString("Name [" + existing.getName() + "]: ",
            existing.getName());

    int age = readOptionalInt("Age [" + existing.getAge() + "]: ",
            existing.getAge());

    String course = readOptionalString("Course [" + existing.getCourse() + "]: ",
            existing.getCourse());

    String email = readOptionalString("Email [" + existing.getEmail() + "]: ",
            existing.getEmail());

    double marks = readOptionalDouble("Marks [" + existing.getMarks() + "]: ",
            existing.getMarks());

    existing.setName(name);
    existing.setAge(age);
    existing.setCourse(course);
    existing.setEmail(email);
    existing.setMarks(marks);

    boolean success = studentDAO.updateStudent(existing);

    System.out.println(success
            ? "Student updated successfully."
            : "Failed to update student.");
}

private static void deleteStudent() {

    System.out.println("\n-- Delete Student --");

    int id = readInt("Enter ID of student to delete: ");

    Student existing = studentDAO.getStudentById(id);

    if (existing == null) {
        System.out.println("No student found with ID: " + id);
        return;
    }

    System.out.println("About to delete: " + existing);

    String confirm = readString("Are you sure? (y/n): ");

    if (confirm.equalsIgnoreCase("y")) {
        boolean success = studentDAO.deleteStudent(id);
