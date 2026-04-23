it.println("\n===== STUDENT MANAGER =====");
                System.out.println("1. Add Student (Insert)");
                System.out.println("2. View All Students");
                System.out.println("3. Update CGPA");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        insertStudent(con, scanner);
                        break;
                    case 2:
                        viewStudents(con);
                        break;
                    case 3:
                        updateCGPA(con, scanner);
                        break;
                    case 4:
                        deleteStudent(con, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        con.close();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL JDBC Driver not found. Add mysql-connector.jar to lib folder.");
        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
            // Rollback if connection is still alive
            if (con != null) {
                try {
                    con.rollback();
                    System.out.println("Transaction rolled back.");
                } catch (SQLException ex) {
                    System.err.println("Rollback failed: " + ex.getMessage());
                }
            }
        }
    }

    // 1. INSERT with transaction
    private static void insertStudent(Connection con, Scanner scanner) {
        PreparedStatement pstmt = null;
        try {
            // Turn off auto-commit
            con.setAutoCommit(false);

            String sql = "INSERT INTO Student (rollno, name, cgpa) VALUES (?, ?, ?)";
            pstmt = con.prepareStatement(sql);

            System.out.print("Enter roll number: ");
            int rollno = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter CGPA: ");
            double cgpa = scanner.nextDouble();

            pstmt.setInt(1, rollno);
            pstmt.setString(2, name);
            pstmt.setDouble(3, cgpa);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                con.commit();  // commit transaction
                System.out.println("✅ Student inserted successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
            try {
                con.rollback();  // rollback on error
                System.out.println("Transaction rolled back.");
            } catch (SQLException ex) {
                System.err.println("Rollback error: " + ex.getMessage());
            }
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                con.setAutoCommit(true); // reset for next operations
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 2. SELECT all students
    private static void viewStudents(Connection con) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Student");

            System.out.println("\n===== STUDENT LIST =====");
            boolean found = false;
            while (rs.next()) {
                found = true;
                int rollno = rs.getInt("rollno");
                String name = rs.getString("name");
                double cgpa = rs.getDouble("cgpa");
                System.out.primport java.sql.*;
import java.util.Scanner;

public class StudentManager {
    // Database credentials – UPDATE if needed
    private static final String DB_URL = "jdbc:mysql://localhost:3306/school_db";
    private static final String USER = "root";      // your MySQL username
    private static final String PASS = "";          // your MySQL password

    public static void main(String[] args) {
        Connection con = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(" Driver loaded.");
✅
            // 2. Establish connection
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("✅ Connected to school_db.\n");

            // Menu loop
            while (true) {
                System.ountf("Roll: %d | Name: %s | CGPA: %.2f%n", rollno, name, cgpa);
            }
            if (!found) {
                System.out.println("No students found.");
            }
        } catch (SQLException e) {
            System.err.println("View error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 3. UPDATE CGPA with transaction
    private static void updateCGPA(Connection con, Scanner scanner) {
        PreparedStatement pstmt = null;
        try {
            con.setAutoCommit(false);

            String sql = "UPDATE Student SET cgpa = ? WHERE rollno = ?";
            pstmt = con.prepareStatement(sql);

            System.out.print("Enter roll number of student: ");
            int rollno = scanner.nextInt();
            System.out.print("Enter new CGPA: ");
            double newCgpa = scanner.nextDouble();

            pstmt.setDouble(1, newCgpa);
            pstmt.setInt(2, rollno);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                con.commit();
                System.out.println("✅ CGPA updated successfully.");
            } else {
                System.out.println("❌ Student with roll number " + rollno + " not found.");
                con.rollback();
            }
        } catch (SQLException e) {
            System.err.println("Update failed: " + e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                System.err.println("Rollback error: " + ex.getMessage());
            }
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 4. DELETE student (with transaction, as per good practice)
    private static void deleteStudent(Connection con, Scanner scanner) {
        PreparedStatement pstmt = null;
        try {
            con.setAutoCommit(false);

            String sql = "DELETE FROM Student WHERE rollno = ?";
            pstmt = con.prepareStatement(sql);

            System.out.print("Enter roll number to delete: ");
            int rollno = scanner.nextInt();

            pstmt.setInt(1, rollno);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                con.commit();
                System.out.println("✅ Student deleted successfully.");
            } else {
                System.out.println("❌ Student with roll number " + rollno + " not found.");
                con.rollback();
            }
        } catch (SQLException e) {
            System.err.println("Delete failed: " + e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                System.err.println("Rollback error: " + ex.getMessage());
            }
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}