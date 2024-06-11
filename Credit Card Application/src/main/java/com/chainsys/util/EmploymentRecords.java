package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.model.Details;
import com.chainsys.model.EmploymentDetails;

public class EmploymentRecords {
	
	
	public static void insert(EmploymentDetails employment, Details details ) throws ClassNotFoundException, SQLException {
		
		Connection connect=ConnectUtil.getConnection();
		
		String query="INSERT INTO employment_details(customer_occupation,customer_company_name,customer_designation,customer_annual_income)  VALUES(?,?,?,?)";
		PreparedStatement pr =connect.prepareStatement(query);
		
		
		
//		pr.setInt(1, details.getCustomerID());
		
		pr.setString(1, employment.getOccupation());
		pr.setString(2, employment.getCompanyname());
		pr.setString(3, employment.getDesignation());
		pr.setLong(4, employment.getIncome());
		pr.executeUpdate();
		System.out.println("HIIII");

		
	}

}
