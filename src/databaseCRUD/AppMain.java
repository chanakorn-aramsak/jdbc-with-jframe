package databaseCRUD;

import javax.swing.*;

import Controller.AppController;
import Model.DatabaseModel;
import Views.AppView;

public class AppMain {
    public static void main(String[] args) {
        // Create a new EmployeeForm instance and make it visible
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AppView form = new AppView();
                form.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                form.setVisible(true);
            }
        });
    }
}

