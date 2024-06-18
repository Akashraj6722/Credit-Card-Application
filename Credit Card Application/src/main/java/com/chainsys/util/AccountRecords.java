package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.model.BankDetails;
import com.chainsys.model.Details;

public class AccountRecords {
	


	public static void insert(Details details,BankDetails bankDetails) throws ClassNotFoundException, SQLException {
		Connection connect = ConnectUtil.getConnection();
		String query = "INSERT INTO account_details(customer_id,account_number,ifsc_code)VALUES(?,?,?)";

		PreparedStatement pr = connect.prepareStatement(query);
		pr.setInt(1, details.getCustomerID());
		pr.setString(2, bankDetails.getAccountNumber());
		pr.setString(3, bankDetails.getIfsc());
		
		System.out.println("accountRecords-Insert"+details.getCustomerID());
		

		pr.executeUpdate();		
	}
	
	public static ArrayList<BankDetails> read(Details details,BankDetails bankDetails) throws ClassNotFoundException, SQLException{
		
		ArrayList<BankDetails> list= new ArrayList<>();
		Connection connect = ConnectUtil.getConnection();
		
		String query="SELECT * FROM account_details WHERE customer_id=?";
		
		PreparedStatement pr=connect.prepareStatement(query);
		
		pr.setInt(1,details.getCustomerID());
		
		System.out.println("ID(account read): "+ details.getCustomerID());
		
		ResultSet rs=pr.executeQuery();
		
		
		if(rs.next()) {
			
			
			details.setCustomerID(rs.getInt("customer_id"));
			bankDetails.setAccountType(rs.getString("account_type"));
			bankDetails.setAccountNumber(rs.getString("account_number"));
			bankDetails.setBalance(rs.getInt("account_balance"));
			bankDetails.setIfsc(rs.getString("ifsc_code"));
			
			list.add(bankDetails);
			
		}
		return list;

		
	}

}
