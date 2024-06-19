package com.chainsys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {
	
	public static Connection getConnection () throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3308/bank","root","root");
		return connect;
	}

	private ConnectUtil() {
		super();
	}

}
