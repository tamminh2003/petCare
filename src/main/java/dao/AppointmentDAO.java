package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;	
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import main.java.entity.Customer;
import main.java.entity.VetTimeslot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import main.java.util.myinterface.*;
import main.java.util.Service;

import java.sql.Time;
import java.sql.Date;

public class AppointmentDAO {
	private IDbConnector dbConnector;
	private static AppointmentDAO instance;
	
	private AppointmentDAO(IDbConnector dbConnector) {
		this.dbConnector = dbConnector;
	}
	
	private AppointmentDAO() {
		initDbConnector();
	}
	
	public static AppointmentDAO getDAO(IDbConnector dbConnector) {
		if (instance == null) {
			instance = new AppointmentDAO(dbConnector);
		}
		return instance;
	}
	
	public static AppointmentDAO getDAO() {
		if (instance == null) {
			instance = new AppointmentDAO();
		}
		return instance;
	}
	
	private void initDbConnector() {
		if (dbConnector == null) {
			dbConnector = Service.getDbConnector();
		}
	}
		
	public void setDbConnector(IDbConnector dbConnector) {
		this.dbConnector = dbConnector;
	}
	
	public ArrayList<VetTimeslot> getAvailableVetTimeslot(String appointmentType) {
		if (dbConnector == null) {
			initDbConnector();
		}
		
		try (Connection connection = dbConnector.makeConnection()) {
			ArrayList<VetTimeslot> vetTimeslots = new ArrayList<VetTimeslot>();
			String sqlQuery = "{CALL get_avail_appointment(?)}";
			CallableStatement procedure = connection.prepareCall(sqlQuery);
			procedure.setString(1, appointmentType);
			
			ResultSet rs = procedure.executeQuery();
			int count = 0;
			int lastVetId = 0;
			LocalDate lastDate = null;
			TreeMap<LocalDate, ArrayList<LocalTime>> timeslotMap = null;
			
			while(rs.next()) {
				int vetId = rs.getInt("vetId");
				String vetName = rs.getString("vetName");
				String timeslotString = rs.getString("timeslot");
				String dateString = timeslotString.split(" ")[0];
				String timeString = timeslotString.split(" ")[1];
				
				LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				LocalTime time = LocalTime.parse(timeString);
				
				if (vetId != lastVetId) {
					count++;
					vetTimeslots.add(
						new VetTimeslot(
								vetId,
								vetName,
								new TreeMap<LocalDate, ArrayList<LocalTime>>()
						)
					);
					lastDate = null;
					lastVetId = vetId;
				}
				
				timeslotMap = vetTimeslots.get(count-1).getTimeslots();
				if (!date.equals(lastDate)) {
				
					timeslotMap.put(date, new ArrayList<LocalTime>());
					lastDate = date;
				}
				
				timeslotMap.get(date).add(time);
			}
			return vetTimeslots;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Boolean bookAppointment(int customerId, int vetId, LocalDate appointmentDate, LocalTime startTime, String description, String appointmentType, String petType, double totalCost) {
		if (dbConnector == null) {
			initDbConnector();
		}
		
		try (Connection connection = dbConnector.makeConnection()) {
			String sqlQuery = "INSERT INTO appointment (customerId, vetid, appointmentDate, startTime, description, appointmentType, petType, totalCost, isPaid) VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, customerId);
			ps.setInt(2, vetId);
			ps.setDate(3, Date.valueOf(appointmentDate));
			ps.setTime(4, Time.valueOf(startTime));
			ps.setString(5, description);
			ps.setString(6, appointmentType);
			ps.setString(7, petType);
			ps.setDouble(8, totalCost);
			ps.setBoolean(9, false);
			int rs = ps.executeUpdate();
			if (rs != 0) {  
				return true;
			} else {
				throw new Exception("No Appointment insertted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
