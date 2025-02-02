package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.model.Employee;

public class EmployeeDbConnection {
	public static final String URL = "jdbc:mysql://localhost:3306/E_commerce";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "@1234";

	public void createEmployeeTable() {
		String query = "create table emp( empId int primary key, empName varchar(255) not null, salary decimal(10,2), address varchar(255), dept varchar(255)not null)";
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			Statement stat = con.createStatement();
			stat.execute(query);
			System.out.println("Table created successfully....");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public int insertEmployee(Employee emp) {
		String query = "insert into emp values(?,?,?,?,?) ";

		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, emp.getEmpId());
			pre.setString(2, emp.getEmpName());
			pre.setDouble(3, emp.getSalary());
			pre.setString(4, emp.getAddress());
			pre.setString(5, emp.getDept());

			int result = pre.executeUpdate();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}
}
