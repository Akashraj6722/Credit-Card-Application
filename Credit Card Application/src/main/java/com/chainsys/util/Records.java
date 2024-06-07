package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.model.Details;

public class Records {

	public static void insert(Details details) throws ClassNotFoundException, SQLException {

		Connection connect = ConnectUtil.getConnection();
		String query = "INSERT INTO customer_details(first_name,last_name,dob,aadhaar_number,pan_number,phone_number,annual_income,password) VALUES(?,?,?,?,?,?,?,?)";

		PreparedStatement pr = connect.prepareStatement(query);

		pr.setString(1, details.getfName());
		pr.setString(2, details.getlName());
		pr.setString(3, details.getDob());
		pr.setString(4, details.getAadhaar());
		pr.setString(5, details.getPan());
		pr.setString(6, details.getPhone());
		pr.setLong(7, details.getAnnualIncome());
		pr.setString(8, details.getPassword());

		pr.executeUpdate();

	}
	
	
public static boolean check(Details details) throws ClassNotFoundException, SQLException {
		

		Connection connect = ConnectUtil.getConnection();
		String query = "SELECT * FROM customer_details WHERE phone_number=? AND password=? ";

		PreparedStatement pr = connect.prepareStatement(query);

		pr.setString(1, details.getPhone());
		pr.setString(2, details.getPassword());

		ResultSet rs = pr.executeQuery();

		if (rs.next()) {
			
			

			System.out.println("Login successful!");
			return true;

			
		}
		System.out.println("Invalid account");
		return false;
	
		

	}


	public static ArrayList<Details> read(Details details) throws ClassNotFoundException, SQLException {
		
        ArrayList<Details> list = new ArrayList<>();

		Connection connect = ConnectUtil.getConnection();
		String query = "SELECT * FROM customer_details WHERE phone_number=? AND password=? ";

		PreparedStatement pr = connect.prepareStatement(query);

		pr.setString(1, details.getPhone());
		pr.setString(2, details.getPassword());

		ResultSet rs = pr.executeQuery();

		if (rs.next()) {
			
			details.setCustomerID(rs.getInt("customer_id"));
			details.setfName(rs.getString("first_name"));
			details.setlName(rs.getString("last_name"));
			details.setDob(rs.getString("dob"));
			details.setAadhaar(rs.getString("aadhaar_number"));
			details.setPan(rs.getString("pan_number"));
			details.setPhone(rs.getString("phone_number"));
			Long income=Long.parseLong(rs.getString("annual_income"));
			details.setAnnualIncome(income);
			
			list.add(details);

			
		}
//		System.out.println("Invalid account");
		return list;
		

	}
public static void readSpecific(Details details) throws ClassNotFoundException, SQLException {
		
       
		Connection connect = ConnectUtil.getConnection();
		String query = "SELECT * FROM customer_details WHERE phone_number=? AND password=? ";

		PreparedStatement pr = connect.prepareStatement(query);

		pr.setString(1, details.getPhone());
		pr.setString(2, details.getPassword());

		ResultSet rs = pr.executeQuery();

		if (rs.next()) {
			
			details.setCustomerID(rs.getInt("customer_id"));
			details.setfName(rs.getString("first_name"));
			details.setlName(rs.getString("last_name"));
			details.setDob(rs.getString("dob"));
			details.setAadhaar(rs.getString("aadhaar_number"));
			details.setPan(rs.getString("pan_number"));
			details.setPhone(rs.getString("phone_number"));
			
		

			
		}
//		
		

	}

}
