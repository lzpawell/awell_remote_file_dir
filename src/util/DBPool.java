package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBPool {

	private static final String userName = "lzp";
	private static final String password = "chuyin12345";
	private static final String PORT = "3306";
	private static final String IP = "39.108.65.230";
	private static final String DBName = "";
	
	public DBPool() {
		// TODO Auto-generated constructor stub
	}
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getDBConnection() throws SQLException{
		String target = "jdbc:mysql://" + IP + ":" + PORT + "/" + DBName;
		
		return DriverManager.getConnection(target,userName, password);
	}

}
