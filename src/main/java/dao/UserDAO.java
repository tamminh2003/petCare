package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.java.util.MySqlDBConnector;

public class UserDAO {
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
	
	public boolean createNewUser(String firstname, String lastname, String phoneNumber, String email, String password) 
	{
		boolean createNewUserSuccessful = false;
		Connection connection = MySqlDBConnector.makeConnection();
		System.out.println(connection);
		PreparedStatement ps = null;


		String sqlQuery = "INSERT INTO Customer(firstname, lastname, phoneNumber, email, password) VALUES (?,?,?,?,?)";
		
		try {
			ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, phoneNumber);
			ps.setString(4, email);
			ps.setString(5, password);

			  int rowsInserted = ps.executeUpdate();
		        if (rowsInserted > 0) {
		            createNewUserSuccessful = true;
		        }

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
		return createNewUserSuccessful;
	}
	
	public boolean checkUserExisted(String email) {
		boolean userExisted = false;
		Connection connection = MySqlDBConnector.makeConnection();
		System.out.println(connection);
		ResultSet rs = null;
		PreparedStatement ps = null;

		String sqlQuery = "SELECT COUNT(*) FROM Customer WHERE email = ?";
		
		try {
			ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, email);
			rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			 if (count > 0) {
		            // User already exists, return true
		            return true;
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

		return userExisted;
	}
}
