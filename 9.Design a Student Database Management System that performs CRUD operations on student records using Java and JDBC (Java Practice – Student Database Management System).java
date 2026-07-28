// ---------------- UPDATE ----------------
public boolean updateStudent(Student student) {

    String sql = "UPDATE students SET name = ?, age = ?, course = ?, email = ?, marks = ? WHERE id = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setString(3, student.getCourse());
        ps.setString(4, student.getEmail());
        ps.setDouble(5, student.getMarks());
        ps.setInt(6, student.getId());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        System.err.println("Error updating student: " + e.getMessage());
        return false;
    }
}

// ---------------- DELETE ----------------
public boolean deleteStudent(int id) {

    String sql = "DELETE FROM students WHERE id = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, id);
        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        System.err.println("Error deleting student: " + e.getMessage());
        return false;
    }
}

// ---------------- Helper: map ResultSet to Student ----------------
private Student mapRow(ResultSet rs) throws SQLException {

    return new Student(
        rs.getInt("id"),
        rs.getString("name"),
        rs.getInt("age"),
        rs.getString("course"),
        rs.getString("email"),
        rs.getDouble("marks")
    );
}
