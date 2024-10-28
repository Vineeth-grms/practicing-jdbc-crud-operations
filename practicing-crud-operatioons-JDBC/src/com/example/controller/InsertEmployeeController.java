package com.example.controller;

import com.example.database.EmployeeDbConnection;
import com.example.model.Employee;

public class InsertEmployeeController {
	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setEmpId(123);
		emp.setEmpName("Virat");
		emp.setSalary(45000);
		emp.setAddress("Delhi");
		emp.setDept("RCB");

		EmployeeDbConnection db = new EmployeeDbConnection();
		int result = db.insertEmployee(emp);

		if (result > 0) {
			System.out.println("Data inserted successfully");
		} else {
			System.out.println("You Got An Error...");
		}
	}

}
