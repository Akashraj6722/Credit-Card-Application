package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.model.CreditCardDetails;

public class ApprovalRecords {
	
	public static void approve(CreditCardDetails card) throws ClassNotFoundException, SQLException {
		Connection connect=ConnectUtil.getConnection(); 
		String query="UPDATE credit_card_details SET credit_card_approval='Approved',credit_card_status='Active' WHERE customer_id=? ";
		
		try(PreparedStatement pr=connect.prepareStatement(query);){
		pr.setInt(1, card.getId());
		
		pr.executeUpdate();
		
		
	}
	}
	public static void reject(CreditCardDetails card) throws ClassNotFoundException, SQLException {
		Connection connect=ConnectUtil.getConnection(); 
		String query="UPDATE credit_card_details SET credit_card_approval='Rejected',credit_card_status='Not active' WHERE customer_id=? ";
		
		try(PreparedStatement pr=connect.prepareStatement(query);){
		pr.setInt(1, card.getId());
		
		pr.executeUpdate();
		
		
	}
	}

	private ApprovalRecords() {
		super();
	}
	
}
