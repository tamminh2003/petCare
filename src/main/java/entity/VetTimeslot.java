package main.java.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.*;

public class VetTimeslot {
	private int vetId;
	private String vetName;
	private HashMap<LocalDate, ArrayList<LocalTime>> timeslots; 
	
	public VetTimeslot(int vetId, String vetName, HashMap<LocalDate, ArrayList<LocalTime>> timeslots) {
		super();
		this.vetId = vetId;
		this.vetName = vetName;
		this.timeslots = timeslots;
	}

	public int getVetId() {
		return vetId;
	}

	public void setVetId(int vetId) {
		this.vetId = vetId;
	}

	public String getVetName() {
		return vetName;
	}

	public void setVetName(String vetName) {
		this.vetName = vetName;
	}

	public HashMap<LocalDate, ArrayList<LocalTime>> getTimeslots() {
		return timeslots;
	}

	public void setTimeslots(HashMap<LocalDate, ArrayList<LocalTime>> timeslots) {
		this.timeslots = timeslots;
	}
	
	
	

}
