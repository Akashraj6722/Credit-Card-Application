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
		String query = "INSERT INTO user_details(first_name,last_name,dob,aadhaar_number,aadhaar_proof,pan_number,pan_proof,email_id,phone_number,password) VALUES(?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pr = connect.prepareStatement(query);

		pr.setString(1, details.getfName());
		pr.setString(2, details.getlName());
		pr.setString(3, details.getDob());
		pr.setString(4, details.getAadhaar());
		pr.setBytes(5, details.getAadhaarProof());
		pr.setString(6, details.getPan());
		pr.setBytes(7, details.getAadhaarProof());
		pr.setString(8, details.getMail());
		pr.setString(9, details.getPhone());
		pr.setString(10, details.getPassword());

		pr.executeUpdate();
		
		System.out.println("signing Up");

	}
	
	
public static boolean check(Details details) throws ClassNotFoundException, SQLException {
		

		Connection connect = ConnectUtil.getConnection();
		String query = "SELECT * FROM user_details WHERE email_id=? AND password=? ";

		PreparedStatement pr = connect.prepareStatement(query);

		pr.setString(1, details.getMail());
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
		String query = "SELECT * FROM user_details WHERE email_id=? AND password=? ";

		PreparedStatement pr = connect.prepareStatement(query);

		pr.setString(1, details.getMail());
		pr.setString(2, details.getPassword());

		ResultSet rs = pr.executeQuery();

		if (rs.next()) {
			
			details.setCustomerID(rs.getInt("id"));
			details.setfName(rs.getString("first_name"));
			details.setlName(rs.getString("last_name"));
			details.setDob(rs.getString("dob"));
			details.setAadhaar(rs.getString("aadhaar_number"));
			details.setPan(rs.getString("pan_number"));
			details.setPhone(rs.getString("phone_number"));
			details.setMail(rs.getString("email_id"));
			
			System.out.println("reading user details");
			
			list.add(details);

			
		}
//		System.out.println("Invalid account");
		return list;
		

	}
public static void readSpecific(Details details) throws ClassNotFoundException, SQLException {
		
       
		Connection connect = ConnectUtil.getConnection();
		String query = "SELECT * FROM user_details WHERE email_id=? AND password=? ";

		PreparedStatement pr = connect.prepareStatement(query);

		pr.setString(1, details.getMail());
		pr.setString(2, details.getPassword());

		

		ResultSet rs = pr.executeQuery();

		if (rs.next()) {
			
			details.setCustomerID(rs.getInt("id"));
			details.setfName(rs.getString("first_name"));
			details.setlName(rs.getString("last_name"));
			details.setDob(rs.getString("dob"));
			details.setAadhaar(rs.getString("aadhaar_number"));
			details.setPan(rs.getString("pan_number"));
			details.setPhone(rs.getString("phone_number"));
			
		

			
		}		
			}

public static String readMail(int id) throws ClassNotFoundException, SQLException {
	
    String mail = "";
	Connection connect = ConnectUtil.getConnection();
	String query = "SELECT email_id FROM user_details WHERE id=? ";

	PreparedStatement pr = connect.prepareStatement(query);

	pr.setInt(1, id);


	ResultSet rs = pr.executeQuery();

	if (rs.next()) {
//		Details details=new Details();
//		
//		details.setMail(rs.getString("email_id"));
		mail=rs.getString("email_id");
		
	}
	return mail;

		}

}
