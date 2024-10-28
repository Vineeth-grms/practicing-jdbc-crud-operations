package com.example.controller;

import com.example.database.EmployeeDbConnection;

public class CreateEmpTableController {
	public static void main(String[] args) {
		EmployeeDbConnection db = new EmployeeDbConnection();
		db.createEmployeeTable();
		
	}

}
