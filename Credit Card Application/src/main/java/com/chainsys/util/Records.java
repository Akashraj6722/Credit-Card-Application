package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.Details;

public class Records {

	public static void insert(Details details) throws ClassNotFoundException, SQLException {

		Connection connect = ConnectUtil.getConnection();
		String query = "INSERT INTO user_details(first_name,last_name,dob,aadhaar_number,aadhaar_proof,pan_number,pan_proof,email_id,phone_number,password) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try(PreparedStatement pr = connect.prepareStatement(query);){

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
		

	}
	}
	
	
public static boolean check(Details details) throws ClassNotFoundException, SQLException {
		

		Connection connect = ConnectUtil.getConnection();
		String query = "SELECT email_id,password FROM user_details WHERE email_id=? AND password=? ";

		try(PreparedStatement pr = connect.prepareStatement(query);){

		pr.setString(1, details.getMail());
		pr.setString(2, details.getPassword());

		ResultSet rs = pr.executeQuery();

		while (rs.next()) {
			
			

			return true;

			
		}
		return false;
	
		

	}
}


	public static List<Details> read(Details details) throws ClassNotFoundException, SQLException {
		
        ArrayList<Details> list = new ArrayList<>();

		Connection connect = ConnectUtil.getConnection();
		String query = "SELECT id,first_name,last_name,dob,aadhaar_number,pan_number,phone_number,email_id FROM user_details WHERE email_id=? AND password=? ";

		try(PreparedStatement pr = connect.prepareStatement(query);){

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
			
			
			list.add(details);

			
		}
		return list;
		
		}
	}
public static void readSpecific(Details details) throws ClassNotFoundException, SQLException {
		
       
		Connection connect = ConnectUtil.getConnection();
		String query = "SELECT id,first_name,last_name,dob,aadhaar_number,pan_number,phone_number FROM user_details WHERE email_id=? AND password=? ";

		try(PreparedStatement pr = connect.prepareStatement(query);){

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
			}

public static String readMail(int id) throws ClassNotFoundException, SQLException {
	
    String mail = "";
	Connection connect = ConnectUtil.getConnection();
	String query = "SELECT email_id FROM user_details WHERE id=? ";

	try(PreparedStatement pr = connect.prepareStatement(query);){

	pr.setInt(1, id);


	ResultSet rs = pr.executeQuery();

	if (rs.next()) {

		mail=rs.getString("email_id");
		
	}
	return mail;

		}
}


private Records() {
	super();
}

}
