package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.model.BankDetails;
import com.chainsys.model.CreditCardDetails;
import com.chainsys.model.Details;


public class CardRecords {
	
	
public static void insert(CreditCardDetails card, Details details ,BankDetails bankDetails) throws ClassNotFoundException, SQLException {
		
		Connection connect=ConnectUtil.getConnection();
		
		String query="INSERT INTO credit_card_details(customer_id,account_number,credit_card_number,credit_card_type,credit_card_cvv,credit_card_issue_date,credit_card_valid_till) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement pr =connect.prepareStatement(query);
		
		
		pr.setInt(1,details.getCustomerID());
		pr.setString(2,bankDetails.getAccountNumber());
		pr.setString(3,card.getCardNumber());
		pr.setString(4, card.getCardType());
		pr.setInt(5, card.getCvvNumber());
		pr.setString(6, card.getCardAppliedDate());
		pr.setString(7, card.getValidity());

		

		pr.executeUpdate();
		System.out.println("inserting card details");

		
	}


  public static void update(CreditCardDetails card,Details details) throws ClassNotFoundException, SQLException {
	  Connection connect=ConnectUtil.getConnection();
		
		String query="UPDATE credit_card_details SET credit_card_pin=? WHERE customer_id=? AND credit_card_number=?";
		PreparedStatement pr =connect.prepareStatement(query);
		
		pr.setInt(1, card.getPin());
		pr.setInt(2,details.getCustomerID());
		pr.setString(3, card.getCardNumber());
		
		pr.executeUpdate();
		
		System.out.println("Setting...PIN customer's ID"+details.getCustomerID());

	  
	  
  }
  
  public static ArrayList<CreditCardDetails> read() throws ClassNotFoundException, SQLException {
		
      ArrayList<CreditCardDetails> list = new ArrayList<>();

		Connection connect = ConnectUtil.getConnection();
		String query = "SELECT * FROM credit_card_details ";

		PreparedStatement pr = connect.prepareStatement(query);

		

		ResultSet rs = pr.executeQuery();

		while (rs.next()) {
			
			CreditCardDetails card = new CreditCardDetails();
			card.setId(rs.getInt("customer_id"));
			card.setAccountNumber(rs.getString("account_number"));
			card.setCardNumber(rs.getString("credit_card_number"));
			card.setCardType(rs.getString("credit_card_type"));
			card.setCardApproval(rs.getString("credit_card_approval"));
			card.setCardStatus(rs.getString("credit_card_status"));
			
			list.add(card);

			
		}
		return list;
		

	}
  
  public static boolean check(CreditCardDetails card) throws ClassNotFoundException, SQLException {
	  
	  Connection connect = ConnectUtil.getConnection();
		String query = "SELECT credit_card_number FROM credit_card_details WHERE credit_card_number=? AND credit_card_approval='Approved' ";
			
		PreparedStatement pr = connect.prepareStatement(query);
		pr.setString(1, card.getCardNumber());
		ResultSet rs = pr.executeQuery();

		if (rs.next()) {
			
			System.out.println("success");
			return true;
		}
		return false;
		
	
  }
}
