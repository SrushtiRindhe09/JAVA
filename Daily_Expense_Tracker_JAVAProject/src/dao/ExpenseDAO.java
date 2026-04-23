package dao;

import java.sql.ResultSet;
import model.Expense;
public interface ExpenseDAO {
    void addExpense(Expense e);
    void deleteExpense(int id);
    ResultSet getAllExpenses();
}
