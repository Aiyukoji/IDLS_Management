import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentDAO {

    // Ajout d'un étudiant
    public void addStudent(Student student) {
        String sql = "INSERT INTO Students (lastName, firstName, Birthdate, Course, Promotion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getlastName());
            pstmt.setString(2, student.getfirstName());
            pstmt.setString(3, student.getBirthdate());
            pstmt.setString(4, student.getCourse());
            pstmt.setString(5, student.getPromotion());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout de l'étudiant : " + ex.getMessage());
        }
    }

    // Modification d'un étudiant
    public void updateStudent(Student student, String oldlastName, String oldfirstName) {
        String sql = "UPDATE Students SET lastName = ?, firstName = ?, Birthdate = ?, Course = ?, Promotion = ? "
                   + "WHERE lastName = ? AND firstName = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getlastName());
            pstmt.setString(2, student.getfirstName());
            pstmt.setString(3, student.getBirthdate());
            pstmt.setString(4, student.getCourse());
            pstmt.setString(5, student.getPromotion());
            pstmt.setString(6, oldlastName);
            pstmt.setString(7, oldfirstName);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour de l'étudiant : " + ex.getMessage());
        }
    }

    // Récupération de tous les étudiants
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Students";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student(
                    rs.getString("lastName"),
                    rs.getString("firstName"),
                    rs.getString("Birthdate"),
                    rs.getString("Course"),
                    rs.getString("Promotion")
                );
                students.add(student);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des étudiants : " + ex.getMessage());
        }
        return students;
    }
}
