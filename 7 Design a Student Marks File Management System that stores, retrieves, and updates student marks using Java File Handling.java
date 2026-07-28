public class Student {

    private int id;
    private String name;
    private int age;
    private String course;
    private String email;
    private double marks;

    public Student() {
    }

    public Student(String name, int age, String course, String email, double marks) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
        this.marks = marks;
    }

    public Student(int id, String name, int age, String course, String email, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
        this.marks = marks;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %-4d | Name: %-20s | Age: %-3d | Course: %-20s | Email: %-25s | Marks: %.2f",
            id, name, age, course, email, marks
        );
    }
}
