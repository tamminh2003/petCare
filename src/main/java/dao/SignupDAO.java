package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.java.util.MySqlDBConnector;

public class SignupDAO {
	public void createNewUser(String firstname, String lastname, String phoneNumber, String email, String password) {
		boolean loginSuccessful = false;
		Connection connection = MySqlDBConnector.makeConnection();
		System.out.println(connection);
		ResultSet rs = null;
		PreparedStatement ps = null;

		String sqlQuery = "INSERT INTO Customer(firstname, lastname, phoneNumber, email, password) VALUES (?,?,?,?,?)";
		
		try {
			ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(2, phoneNumber);
			ps.setString(2, email);
			ps.setString(2, password);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
