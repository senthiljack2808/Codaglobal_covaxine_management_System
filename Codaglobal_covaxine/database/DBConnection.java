package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection con = null;
	
	public static Connection getConnection() {
		
		try {
			if (con != null && !con.isClosed()) 
				return con;

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/covaxine_management",		// mysql url
					"root",		// mysql username
					""		// mysql password
				);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;	
	}
}