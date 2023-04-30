package main.java.dao;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;	
import java.sql.SQLException;
import main.java.util.MySqlDBConnector;
import java.util.ArrayList;
import main.java.entity.VetTimeslot;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentDAO {
	public ArrayList<VetTimeslot> getAvailableVetTimeslot(String appointmentType) throws SQLException {				
		Connection connection = MySqlDBConnector.makeConnection();
		String sqlQuery = "{ CALL prsp_get_avail_appointment(?) }";
		CallableStatement procedure = connection.prepareCall(sqlQuery);
		procedure.setString(1, appointmentType);
		ArrayList<VetTimeslot> vetTimeslots = new ArrayList<VetTimeslot>();

		ResultSet rs = null;
		try {
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
		} finally {
			connection.close();
		}
		return vetTimeslots;
	}
	
	public static void main(String[] args) {
		AppointmentDAO test = new AppointmentDAO();
		try {
			var temp = test.getAvailableVetTimeslot("GENERAL");
			for(int i = 0; i < temp.size(); i++) {
				var iTemp = temp.get(i);
				var jTemp = iTemp.get_timeslots();
				System.out.println("vetId");
				System.out.println(iTemp.get_vetId());
				System.out.println("timeslots");
				for(int j = 0; j < jTemp.size(); j++) {
					System.out.println(jTemp.get(j));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
