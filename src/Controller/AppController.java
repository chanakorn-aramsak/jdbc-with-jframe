package Controller;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import Model.DatabaseModel;
import Views.AppView;

public class AppController {
    private DatabaseModel dbModel;

    public AppController() {
        dbModel = new DatabaseModel();
    }

    public void addEmployee(String empNo, String fName, String lName, String sex, double salary, String deptCode) {
        dbModel.addEmployee(empNo, fName, lName, sex, salary, deptCode);
    }

    public void updateEmployeeSalary(String empNo, double newSalary) {
        dbModel.updateEmployeeSalary(empNo, newSalary);
    }

    public void deleteEmployee(String empNo) {
        dbModel.deleteEmployee(empNo);
    }
    public List<String> getDepartmentCodes() {
        return dbModel.getDepartmentCodes();
    }

}

