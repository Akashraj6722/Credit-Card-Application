package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.model.BankDetails;
import com.chainsys.model.Details;

public class AccountRecords {
	
	
//	public static void insert(Details details) throws ClassNotFoundException, SQLException {
//
//		Connection connect = ConnectUtil.getConnection();
//		String query = "INSERT INTO account_details(account_type,account_number,ifsc_code)VALUES(?,?,?)";
//
//		PreparedStatement pr = connect.prepareStatement(query);
//
//		pr.setString(1, details.getfName());
//		pr.setString(2, details.getlName());
//		pr.setString(3, details.getDob());
//		pr.setString(4, details.getAadhaar());
//		pr.setString(5, details.getPan());
//		pr.setString(6, details.getPhone());
//		pr.setLong(7, details.getAnnualIncome());
//		pr.setString(8, details.getPassword());
//
//		pr.executeUpdate();
//
//	}

	public static void insert(Details details,BankDetails bankDetails) throws ClassNotFoundException, SQLException {
		Connection connect = ConnectUtil.getConnection();
		String query = "INSERT INTO account_details(id,account_type,account_number,account_balance,ifsc_code)VALUES(?,?,?,1000,?)";

		PreparedStatement pr = connect.prepareStatement(query);
		pr.setInt(1, details.getCustomerID());
		pr.setString(2, bankDetails.getAccountType());
		pr.setString(3, bankDetails.getAccountNumber());
		pr.setString(4, bankDetails.getIfsc());
		
		System.out.println(details.getCustomerID());
		System.out.println(bankDetails.getAccountType());
		

		pr.executeUpdate();		
	}
	
	public static ArrayList<BankDetails> read(Details details,BankDetails bankDetails) throws ClassNotFoundException, SQLException{
		
		ArrayList<BankDetails> list= new ArrayList<>();
		Connection connect = ConnectUtil.getConnection();
		
		String query="SELECT * FROM account_details WHERE id=?";
		
		PreparedStatement pr=connect.prepareStatement(query);
		
		pr.setInt(1,details.getCustomerID());
		
		System.out.println("ID: "+ details.getCustomerID());
		
		ResultSet rs=pr.executeQuery();
		
		
		if(rs.next()) {
			
//			BankDetails bankDetails=new BankDetails();
			
//			details.setCustomerID(rs.getInt("id"));
			bankDetails.setAccountType(rs.getString("account_type"));
			bankDetails.setAccountNumber(rs.getString("account_number"));
			bankDetails.setBalance(rs.getInt("account_balance"));
			bankDetails.setIfsc(rs.getString("ifsc_code"));
			
			list.add(bankDetails);
			
		}
		return list;

		
	}

}
