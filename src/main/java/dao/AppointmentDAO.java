package main.java.dao;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;	
import java.util.ArrayList;
import main.java.entity.VetTimeslot;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import main.java.util.myinterface.*;
import main.java.util.Service;

public class AppointmentDAO {
	private IDbConnector dbConnector;
	
	private void initDbConnector() {
		if (dbConnector == null) {
			dbConnector = Service.getDbConnector();
		}
	}
	
	public void setDbConnector(IDbConnector dbConnector) {
		this.dbConnector = dbConnector;
	}
	
	public ArrayList<VetTimeslot> getAvailableVetTimeslot(String appointmentType) {
		if (dbConnector ==null) {
			initDbConnector();
		}
		
		try (Connection connection = dbConnector.makeConnection()) {
			ArrayList<VetTimeslot> vetTimeslots = new ArrayList<VetTimeslot>();
			
			ResultSet rs = null;
			
			String sqlQuery = "{ CALL prsp_get_avail_appointment(?) }";
			CallableStatement procedure = connection.prepareCall(sqlQuery);
			procedure.setString(1, appointmentType);
			
			rs = procedure.executeQuery();
			
			int count = 0;
			while(rs.next()) {
				int latestVetId = 0;
				if (vetTimeslots.size() != 0) {
					latestVetId = vetTimeslots.get(vetTimeslots.size()-1).get_vetId();
				}
				if (latestVetId != rs.getInt("vetId")) {
					int newVetId = rs.getInt("vetId");
					String newFirstname = rs.getString("firstname");
					String newLastname = rs.getString("lastname");
					vetTimeslots.add(new VetTimeslot(newVetId, newFirstname, newLastname));
					latestVetId = newVetId;
					count++;
				}
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime timeslot = LocalDateTime.parse(rs.getString("timeslot"), formatter);
				vetTimeslots.get(count - 1).addTimeslot(timeslot);
			}
			
			return vetTimeslots;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
