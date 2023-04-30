package main.java.entity;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class VetTimeslot {
	private int _vetId;
	private String _firstName;
	private String _lastName;
	private ArrayList<LocalDateTime> _timeslots; // Available timeslots
	
	public VetTimeslot(int _vetId, String _firstName, String _lastName) {
		super();
		this._vetId = _vetId;
		this._firstName = _firstName;
		this._lastName = _lastName;
		this._timeslots = new ArrayList<LocalDateTime>();
	}
	
	public int get_vetId() {
		return _vetId;
	}
	
	public String get_firstName() {
		return _firstName;
	}
	
	public String get_lastName() {
		return _lastName;
	}
	
	public ArrayList<LocalDateTime> get_timeslots() {
		return _timeslots;
	}
	
	public ArrayList<LocalDateTime> addTimeslot(LocalDateTime timeslot) {
		_timeslots.add(timeslot);
		return _timeslots;
	}
}
