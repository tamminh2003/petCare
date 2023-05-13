package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import main.java.dao.exception.CustomerDAOException;
import main.java.entity.Customer;
import main.java.util.Service;
import main.java.util.myinterface.IDbConnector;

public class CustomerDAO {
	private IDbConnector dbConnector;
	private HashMap<Integer, Customer> customerCache = new HashMap<Integer, Customer>();
	private static CustomerDAO instance;

	private CustomerDAO(IDbConnector dbConnector) {
		this.dbConnector = dbConnector;
	}
	
	private CustomerDAO() {
		initDbConnector();
	}
	
	public static CustomerDAO getDAO(IDbConnector dbConnector) {
		if (instance == null) {
			instance = new CustomerDAO(dbConnector);
		}
		return instance;
	}
	
	public static CustomerDAO getDAO() {
		if (instance == null) {
			instance = new CustomerDAO();
		}
		return instance;
	}
	
	private void initDbConnector() {
		if (this.dbConnector == null) {
			this.dbConnector = Service.getDbConnector();
		}
	}
	
	public Customer selectId(int id) {
		Customer customer = this.customerCache.get(id);
		if (customer == null) {
			try(Connection connection = dbConnector.makeConnection()) {
				String sqlQuery = "SELECT firstname, lastname, email, phonenumber FROM Customer WHERE id = ?";
				PreparedStatement ps = connection.prepareStatement(sqlQuery);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next() == true) {  
					customer = new Customer(id, rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("phoneNumber"));
				} else {
					throw new Exception("No Customer found with provided Id");
				}
				if (rs.next() == true) { // More than one row returned, duplication
					System.out.println("WARNING: Customer duplication found."); // We should log this some where to notify the devs or database admin
				}
				customerCache.put(1, customer);
			} catch (Exception e) {
				System.err.println("Error occured during fetching Customer(id);");
				System.err.println(e);
			}
		}
		return customer;
	}
	
	public Customer selectLogIn(String email, String password) {
		Customer customer = null;
		try (Connection connection = dbConnector.makeConnection()) {
			ResultSet rs = null;
			PreparedStatement ps = null;
			String sqlQuery = "SELECT id, firstname, lastname, email, phoneNumber FROM Customer WHERE email = ? AND password = ?";
			ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next() == true) {
				customer = new Customer(
							rs.getInt("id"),
							rs.getString("firstname"),
							rs.getString("lastname"),
							email,
							rs.getString("phoneNumber")
						);
				customerCache.put(customer.getId(), customer);
			} else {
				throw new Exception("Either no customer found or password does not match.");
			}
			if (rs.next() == true) { // More than one row returned, duplication
				System.out.println("WARNING: Customer duplication found."); // We should log this some where to notify the devs or database admin
			}
		} catch (Exception e) {
			System.err.println("Error occured during fetching Customer(email,password);");
			System.err.println(e);
		}
		return customer;
	}
	
	public boolean insert(Customer customer) throws CustomerDAOException {
		try (Connection connection = dbConnector.makeConnection()) {
			PreparedStatement ps = connection.prepareStatement("SELECT email FROM Customer WHERE email = ?");
			ps.setString(1, customer.getEmail());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				throw new CustomerDAOException("Email is already existed.");
			}
			ps = connection.prepareStatement("INSERT INTO Customer (firstname, lastname, email, phoneNumber, password) Values (?, ?, ?, ? ,?)");
			ps.setString(1, customer.getFirstname());
			ps.setString(2, customer.getLastname());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPhoneNumber());
			ps.setString(5, customer.getPassword());
			int row = ps.executeUpdate();
			if (row > 0) return true;
		} catch (CustomerDAOException e) {
			throw e;
		} catch (Exception e) {
			System.err.println("Error occured during creating Customer;");
			System.err.println(e);
		}
		return false;
	}
}
