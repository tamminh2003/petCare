package main.java.util;

import java.sql.*;

public class MySqlDBConnector {
	private static final String dbUrl = "jdbc:mysql://database-1.c3uetrh9pjdr.ap-southeast-2.rds.amazonaws.com/appPetCare";
	private static final String dbUsername = "admin";
	private static final String dbPassword = "PetCare123";

	public static Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("Test database connection");
		try {
			Connection con = makeConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from information_schema.tables limit 1");
			while (rs.next()) {
				System.out.println(rs.getString("table_name"));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Database connection test success");
	}
}
