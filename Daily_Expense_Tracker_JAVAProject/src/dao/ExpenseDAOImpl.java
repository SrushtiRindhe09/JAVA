package dao;

import java.sql.*;
import model.Expense;
import db.DBConnection;
public class ExpenseDAOImpl implements ExpenseDAO {

    Connection con = DBConnection.getConnection();

    public void addExpense(Expense e) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO expenses(amount, category, date) VALUES (?, ?, ?)"
            );
            ps.setDouble(1, e.getAmount());
            ps.setString(2, e.getCategory());
            ps.setString(3, e.getDate());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteExpense(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM expenses WHERE id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getAllExpenses() {
        try {
            Statement st = con.createStatement();
            return st.executeQuery("SELECT * FROM expenses");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
