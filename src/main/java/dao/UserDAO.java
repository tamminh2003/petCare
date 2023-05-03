package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.java.util.Service;
import main.java.util.myinterface.IDbConnector;

// Deprecated package

public class UserDAO {
	private IDbConnector dbConnector;
	private static UserDAO instance;

	private UserDAO(IDbConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	private UserDAO() {
		initDbConnector();
	}

	private void initDbConnector() {
		if (dbConnector == null) {
			dbConnector = Service.getDbConnector();
		}
	}

	public UserDAO getDAO(IDbConnector dbConnector) {
		if (instance == null) {
			instance = new UserDAO(dbConnector);
		}
		return instance;
	}

	public UserDAO getDAO() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public boolean checkUserByPasswordAndUsername(String username, String password) {
		boolean loginSuccessful = false;
		try (Connection connection = dbConnector.makeConnection()) {
			PreparedStatement ps = connection
					.prepareStatement("SELECT id FROM Customer WHERE email = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			if (rs.next() == true) {
				loginSuccessful = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginSuccessful;
	}

	public boolean createNewUser(String firstname, String lastname, String phoneNumber, String email, String password) {
		boolean createNewUserSuccessful = false;
		try (Connection connection = dbConnector.makeConnection()) {
			String sqlQuery = "INSERT INTO Customer(firstname, lastname, phoneNumber, email, password) VALUES (?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
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
		} 
		return createNewUserSuccessful;
	}

	public boolean checkUserExisted(String email) {
		boolean userExisted = false;
		try(Connection connection = dbConnector.makeConnection()) {
			PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM Customer WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if (count > 0) {
				userExisted = true; // User already exists, return true
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return userExisted;
	}
}
