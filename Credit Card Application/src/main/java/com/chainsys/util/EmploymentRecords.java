package com.chainsys.util;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.Details;
import com.chainsys.model.EmploymentDetails;

public class EmploymentRecords {
	
	
	public static void insert(EmploymentDetails employment, Details details ) throws ClassNotFoundException, SQLException {
		
		Connection connect=ConnectUtil.getConnection();
		
		String query="INSERT INTO employment_details(id_number,customer_occupation,customer_company_name,customer_designation,customer_annual_income,income_proof)  VALUES(?,?,?,?,?,?)";
		try 
		(PreparedStatement pr =connect.prepareStatement(query);){
		
		
		
		pr.setInt(1, details.getCustomerID());
		pr.setString(2, employment.getOccupation());
		pr.setString(3, employment.getCompanyname());
		pr.setString(4, employment.getDesignation());
		pr.setLong(5, employment.getIncome());
		pr.setBytes(6, employment.getIncomeProof());
		pr.executeUpdate();

		
	}
	}
	
public static List<byte[]> read() throws ClassNotFoundException, SQLException{
		
	
	ArrayList<byte[]> list=new ArrayList<byte[]>();
	byte[] incomeProof=null;
		Connection connect = ConnectUtil.getConnection();
		
		String query="SELECT income_proof FROM employment_details";
		
		try(PreparedStatement pr=connect.prepareStatement(query);){
		
		
		
		ResultSet rs=pr.executeQuery();
		
		
		while(rs.next()) {
			
			Blob blob=rs.getBlob("income_proof");
			
			incomeProof=blob.getBytes(1, (int)blob.length());
			list.add(incomeProof);
			
            
		}
		return list;
		

		
	}
}
private EmploymentRecords() {
	super();
}


}
