import javax.swing.*;
import java.awt.event.*;

public class StudentForm extends JFrame implements ActionListener, ItemListener {

    // Components
    JLabel nameLabel, genderLabel, courseLabel, resultLabel;
    JTextField nameField;
    JRadioButton male, female;
    ButtonGroup genderGroup;
    JComboBox<String> courseBox;
    JButton submitBtn;

    String gender = "";

    public StudentForm() {

        // Frame settings
        setTitle("Student Information Form");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 150, 25);
        add(nameField);

        // Gender
        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 70, 100, 25);
        add(genderLabel);

        male = new JRadioButton("Male");
        male.setBounds(150, 70, 70, 25);
        female = new JRadioButton("Female");
        female.setBounds(220, 70, 80, 25);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        add(male);
        add(female);

        // Add ItemListener
        male.addItemListener(this);
        female.addItemListener(this);

        // Course
        courseLabel = new JLabel("Course:");
        courseLabel.setBounds(30, 110, 100, 25);
        add(courseLabel);

        String courses[] = {"B.Tech", "BCA", "MCA", "MBA"};
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(150, 110, 150, 25);
        add(courseBox);

        // Submit Button
        submitBtn = new JButton("Submit");
        submitBtn.setBounds(150, 150, 100, 30);
        add(submitBtn);

        // Result Label
        resultLabel = new JLabel("");
        resultLabel.setBounds(30, 200, 350, 25);
        add(resultLabel);

        // Add ActionListener
        submitBtn.addActionListener(this);

        setVisible(true);
    }

    // Button Click Event
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String course = courseBox.getSelectedItem().toString();

        resultLabel.setText("Name: " + name + ", Gender: " + gender + ", Course: " + course);
    }

    // Radio Button Selection Event
    public void itemStateChanged(ItemEvent e) {
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}