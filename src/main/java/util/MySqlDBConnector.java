package main.java.util;

import java.sql.*;
import main.java.util.myinterface.IDbConnector;

public class MySqlDBConnector implements IDbConnector{
	private static final String dbUrl = "jdbc:mysql://localhost:3306/appPetCare?serverTimezone=Australia/Sydney";
	private static final String dbUsername = "root";
	private static final String dbPassword = "PetCare123";
	
	private static MySqlDBConnector instance;
	
	private MySqlDBConnector() {}
	
	public static MySqlDBConnector getDbConnector() {
		if (instance == null) {
			instance = new MySqlDBConnector();
		}
		return instance;
	}

	public Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
}
