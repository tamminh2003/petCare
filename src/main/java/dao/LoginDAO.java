package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.java.util.MySqlDBConnector;

public class LoginDAO {
	public boolean checkUserByPasswordAndUsername(String username, String password) {
		boolean loginSuccessful = false;
		Connection connection = MySqlDBConnector.makeConnection();
		System.out.println(connection);
		ResultSet rs = null;
		PreparedStatement ps = null;

		String sqlQuery = "SELECT * FROM Customer WHERE email = ? AND password = ?";
		
		try {
			ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			System.out.println(rs);
			if (rs.next() == true) {  
				loginSuccessful = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
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

		return loginSuccessful;
	}
}
