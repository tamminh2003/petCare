package main.java.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Appointment {
    enum PetType {
        DOG,
        CAT,
        BIRD
    }
    
    enum AppointmentType {
        CONSULTATION,
        DENTISTRY,
        SURGERY,
        DESEXING,
        MICROCHIPING,
        IMAGING
    }


    private int id;
    private int customerId;
    private int vetId;
    private Date appointmentDate;
    private String startTime;
    private String description;
    private AppointmentType appointmentType;
    private PetType petType;
    private double totalCost;
    private boolean isPaid;
    
	public Appointment(int id, int customerId, int vetId, Date appointmentDate, String startTime, String description,
			AppointmentType appointmentType, PetType petType, double totalCost, boolean isPaid) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.vetId = vetId;
		this.appointmentDate = appointmentDate;
		this.startTime = startTime;
		this.description = description;
		this.appointmentType = appointmentType;
		this.petType = petType;
		this.totalCost = totalCost;
		this.isPaid = isPaid;
	}
	
	public Appointment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getVetId() {
		return vetId;
	}

	public void setVetId(int vetId) {
		this.vetId = vetId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	
	
	
    
    
    

    

}
