package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import dao.ExpenseDAOImpl;
import model.Expense;

public class ExpenseUI extends JFrame {

    JTextField amountField, dateField;
    JComboBox<String> categoryBox;
    JTable table;
    DefaultTableModel model;

    ExpenseDAOImpl dao = new ExpenseDAOImpl();

    public ExpenseUI() {
        setTitle("Expense Tracker");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Amount:");
        l1.setBounds(20, 20, 80, 25);
        add(l1);

        amountField = new JTextField();
        amountField.setBounds(100, 20, 120, 25);
        add(amountField);

        JLabel l2 = new JLabel("Category:");
        l2.setBounds(20, 60, 80, 25);
        add(l2);

        categoryBox = new JComboBox<>(new String[]{"Food", "Travel", "Shopping"});
        categoryBox.setBounds(100, 60, 120, 25);
        add(categoryBox);

        JLabel l3 = new JLabel("Date:");
        l3.setBounds(20, 100, 80, 25);
        add(l3);

        dateField = new JTextField();
        dateField.setBounds(100, 100, 120, 25);
        add(dateField);

        JButton addBtn = new JButton("Add");
        addBtn.setBounds(250, 20, 100, 25);
        add(addBtn);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(250, 60, 100, 25);
        add(deleteBtn);

      

        model = new DefaultTableModel(new String[]{"ID", "Amount", "Category", "Date"}, 0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 150, 540, 200);
        add(sp);

        // ADD BUTTON
        addBtn.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            String category = categoryBox.getSelectedItem().toString();
            String date = dateField.getText();

            Expense exp = new Expense(amount, category, date);
            dao.addExpense(exp);
            loadData();
        });

        // DELETE BUTTON
        deleteBtn.addActionListener(e -> {
    try {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }

        // safer conversion
        int id = Integer.parseInt(model.getValueAt(row, 0).toString());

        dao.deleteExpense(id);
        loadData();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error deleting record!");
    }
});

        // VIEW BUTTON
        

        setVisible(true);
    }

    void loadData() {
        try {
            model.setRowCount(0);
            ResultSet rs = dao.getAllExpenses();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getDouble("amount"),
                        rs.getString("category"),
                        rs.getString("date")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
