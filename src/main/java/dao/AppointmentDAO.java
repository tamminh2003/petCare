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
			System.out.println("appointmentType: " + appointmentType);
			ArrayList<VetTimeslot> vetTimeslots = new ArrayList<VetTimeslot>();
			
			ResultSet rs = null;
			
			String sqlQuery = "{CALL get_avail_appointment(?)}";
			CallableStatement procedure = connection.prepareCall(sqlQuery);
			procedure.setString(1, appointmentType);
			
			rs = procedure.executeQuery();
			System.out.println(rs);
			int count = 0;
			int lastVetId = 0;
			LocalDate lastDate = null;
			HashMap<LocalDate, ArrayList<LocalTime>> timeslotHashmap = null;
			
			while(rs.next()) {
				int vetId = rs.getInt("vetId");
				String vetName = rs.getString("vetName");
				String timeslot = rs.getString("timeslot");
				LocalDate date = LocalDate.parse(timeslot);
				LocalTime time = LocalTime.parse(timeslot);
				
				System.out.println("date: " + date);
				System.out.println("time: " + time);
				
				if (vetId != lastVetId) {
					System.out.println("new VetTimeslot");
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
				
				if (date != lastDate) {
					System.out.println("new timeArray");
					timeslotHashmap.put(date, new ArrayList<LocalTime>());
					lastDate = date;
				}
				
				System.out.println("Adding time to timeslots");
				timeslotHashmap.get(date).add(time);
			}
			System.out.println(vetTimeslots);
			return vetTimeslots;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
