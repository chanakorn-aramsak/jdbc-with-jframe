package Views;

import javax.swing.*;

import Controller.AppController;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppView extends JFrame {

    private AppController controller;

    private JTextField empNoField;
    private JTextField fNameField;
    private JTextField lNameField;
    private JTextField sexField;
    private JTextField salaryField;
    private JTextField deptCodeField;
    private JComboBox<String> deptCodeCombo;
    public AppView() {
        controller = new AppController();
        
        setTitle("Employee Form");
        setSize(300, 300);
        setLayout(new FlowLayout());

        empNoField = new JTextField(15);
        fNameField = new JTextField(15);
        lNameField = new JTextField(15);
        sexField = new JTextField(5);
        salaryField = new JTextField(10);
        deptCodeField = new JTextField(5);

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update Salary");
        JButton deleteButton = new JButton("Delete");
        deptCodeCombo = new JComboBox<>();
        List<String> deptCodes = controller.getDepartmentCodes();
        for(String code : deptCodes) {
            deptCodeCombo.addItem(code);
        }
        add(new JLabel("Dept Code:"));
        add(deptCodeCombo);
        add(new JLabel("Emp No:"));
        add(empNoField);
        add(new JLabel("First Name:"));
        add(fNameField);
        add(new JLabel("Last Name:"));
        add(lNameField);
        add(new JLabel("Sex:"));
        add(sexField);
        add(new JLabel("Salary:"));
        add(salaryField);
        add(new JLabel("Dept Code:"));
        add(deptCodeField);
        
        add(addButton);
        add(updateButton);
        add(deleteButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.addEmployee(empNoField.getText(), fNameField.getText(), lNameField.getText(), sexField.getText(), Double.parseDouble(salaryField.getText()), deptCodeField.getText());
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.updateEmployeeSalary(empNoField.getText(), Double.parseDouble(salaryField.getText()));
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.deleteEmployee(empNoField.getText());
            }
        });
    }

    public static void main(String[] args) {
        new AppView().setVisible(true);
    }
}
