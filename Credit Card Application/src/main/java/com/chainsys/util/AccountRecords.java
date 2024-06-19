package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.BankDetails;
import com.chainsys.model.Details;

public class AccountRecords {
	


	public static void insert(Details details,BankDetails bankDetails) throws ClassNotFoundException, SQLException {
		Connection connect = ConnectUtil.getConnection();
		String query = "INSERT INTO account_details(customer_id,account_number,ifsc_code)VALUES(?,?,?)";

		try(PreparedStatement pr = connect.prepareStatement(query);){
		pr.setInt(1, details.getCustomerID());
		pr.setString(2, bankDetails.getAccountNumber());
		pr.setString(3, bankDetails.getIfsc());
		
		

		pr.executeUpdate();		
	}
	}
	
	public static List<BankDetails> read(Details details,BankDetails bankDetails) throws ClassNotFoundException, SQLException{
		
		ArrayList<BankDetails> list= new ArrayList<>();
		Connection connect = ConnectUtil.getConnection();
		
		String query="SELECT customer_id,account_type,account_number,ifsc_code,account_balance,account_status FROM account_details WHERE customer_id=?";
		try
		(PreparedStatement pr=connect.prepareStatement(query);){
		
		pr.setInt(1,details.getCustomerID());
		
		
		ResultSet rs=pr.executeQuery();
		
		
		if(rs.next()) {
			
			
			details.setCustomerID(rs.getInt("customer_id"));
			bankDetails.setAccountType(rs.getString("account_type"));
			bankDetails.setAccountNumber(rs.getString("account_number"));
			bankDetails.setBalance(rs.getInt("account_balance"));
			bankDetails.setIfsc(rs.getString("ifsc_code"));
			
			list.add(bankDetails);
			
		}
		}
		return list;

		
	}

	private AccountRecords() {
		super();
	}
	

}
