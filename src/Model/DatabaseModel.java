package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseModel {
    private static final String url = "jdbc:sqlite:new.db";
    private static Connection con;

    public DatabaseModel() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addEmployee(String empNo, String fName, String lName, String sex, double salary, String deptCode) {
        String sql = "INSERT INTO Employee(EmpNo, FName, LName, Sex, Salary, DeptCode) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, empNo);
            pstmt.setString(2, fName);
            pstmt.setString(3, lName);
            pstmt.setString(4, sex);
            pstmt.setDouble(5, salary);
            pstmt.setString(6, deptCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getEmployee(String empNo) {
        String sql = "SELECT * FROM Employee WHERE EmpNo = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, empNo);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                // Extract data from result set
                System.out.println("EmpNo: " + rs.getString("EmpNo"));
                System.out.println("FName: " + rs.getString("FName"));
                // ... (and so on for other fields)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployeeSalary(String empNo, double newSalary) {
        String sql = "UPDATE Employee SET Salary = ? WHERE EmpNo = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, newSalary);
            pstmt.setString(2, empNo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(String empNo) {
        String sql = "DELETE FROM Employee WHERE EmpNo = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, empNo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getDepartmentCodes() {
        List<String> deptCodes = new ArrayList<String>();
        String sql = "SELECT DeptCode FROM Department";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                deptCodes.add(rs.getString("DeptCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deptCodes;
    }


}
