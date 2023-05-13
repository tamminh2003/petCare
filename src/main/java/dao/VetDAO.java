package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.java.entity.Vet;
import main.java.entity.Vet.Specialization;
import main.java.util.Service;
import main.java.util.myinterface.IDbConnector;

public class VetDAO {
	private IDbConnector dbConnector;
	private static VetDAO instance;

	private VetDAO(IDbConnector dbConnector) {
		this.dbConnector = dbConnector;
	}
	
	private VetDAO() {
		initDbConnector();
	}
	
	public static VetDAO getDAO(IDbConnector dbConnector) {
		if (instance == null) {
			instance = new VetDAO(dbConnector);
		}
		return instance;
	}
	
	public static VetDAO getDAO() {
		if (instance == null) {
			instance = new VetDAO();
		}
		return instance;
	}
	
	private void initDbConnector() {
		if (this.dbConnector == null) {
			this.dbConnector = Service.getDbConnector();
		}
	}

	public Vet selectId(int id) {
		try (Connection connection = dbConnector.makeConnection()) {
			String sqlQuery = "SELECT firstname, lastname, email, phonenumber, specializeType FROM vet WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next() == true) {
				Specialization specialization;
				switch (rs.getString("specializeType")) {
					case "GENERAL":
						specialization = Specialization.GENERAL;
						break;
					case "SURGERY":
						specialization = Specialization.SURGERY;
						break;
					case "DENTISTRY":
						specialization = Specialization.DENTISTRY;
						break;
					default:
						specialization = Specialization.GENERAL;
				}
				return new Vet(id, rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("phoneNumber"), specialization);
			} else {
				throw new Exception("No Customer found with provided Id");
			}
		} catch (Exception e) {
			System.err.println("Error occured during fetching Customer(id);");
			System.err.println(e);
			return null;
		}
	}
}
