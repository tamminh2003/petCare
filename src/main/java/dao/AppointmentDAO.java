package main.java.dao;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;	
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import main.java.entity.VetTimeslot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
			
			String sqlQuery = "{CALL get_avail_appointment(?)}";
			CallableStatement procedure = connection.prepareCall(sqlQuery);
			procedure.setString(1, appointmentType);
			
			rs = procedure.executeQuery();
			int count = 0;
			int lastVetId = 0;
			LocalDate lastDate = null;
			HashMap<LocalDate, ArrayList<LocalTime>> timeslotHashmap = null;
			
			while(rs.next()) {
				int vetId = rs.getInt("vetId");
				String vetName = rs.getString("vetName");
				String timeslotString = rs.getString("timeslot");
				String dateString = timeslotString.split(" ")[0];
				String timeString = timeslotString.split(" ")[1];
				
				LocalDate date = LocalDate.parse(dateString);
				LocalTime time = LocalTime.parse(timeString);
				
				if (vetId != lastVetId) {
					count++;
					vetTimeslots.add(
						new VetTimeslot(
								vetId,
								vetName,
								new HashMap<LocalDate, ArrayList<LocalTime>>()
						)
					);
				
					lastDate = null;
			
				
					lastVetId = vetId;
				}
				
				timeslotHashmap = vetTimeslots.get(count-1).getTimeslots();
				System.out.println("date: " + date);
				System.out.println("lastDate: "+lastDate);
				if (!date.equals(lastDate)) {
				
					timeslotHashmap.put(date, new ArrayList<LocalTime>());
					lastDate = date;
					System.out.println("date != date branch is triggered");
				}
				
				timeslotHashmap.get(date).add(time);
			}
			return vetTimeslots;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
