package main.java.entity;
import main.java.util.Spiecies;
import main.java.util.PetGender;

import java.sql.Timestamp;
import java.util.Date;

public class Pet {
    private int id;
    private int ownerId;
    private Date dateOfBirth;
    private Spiecies spiecies;
    private String name;
    private PetGender gender;
    private boolean desexed;
    private Timestamp registeredAt;
    private String councilRegistrationNumber;
    private boolean isDeceased;
    private boolean isStray;
   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Spiecies getSpiecies() {
		return spiecies;
	}
	public void setSpiecies(Spiecies spiecies) {
		this.spiecies = spiecies;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PetGender getGender() {
		return gender;
	}
	public void setGender(PetGender gender) {
		this.gender = gender;
	}
	public boolean isDesexed() {
		return desexed;
	}
	public void setDesexed(boolean desexed) {
		this.desexed = desexed;
	}
	public Timestamp getRegisteredAt() {
		return registeredAt;
	}
	public void setRegisteredAt(Timestamp registeredAt) {
		this.registeredAt = registeredAt;
	}
	public String getCouncilRegistrationNumber() {
		return councilRegistrationNumber;
	}
	public void setCouncilRegistrationNumber(String councilRegistrationNumber) {
		this.councilRegistrationNumber = councilRegistrationNumber;
	}
	public boolean isDeceased() {
		return isDeceased;
	}
	public void setDeceased(boolean isDeceased) {
		this.isDeceased = isDeceased;
	}
	public boolean isStray() {
		return isStray;
	}
	public void setStray(boolean isStray) {
		this.isStray = isStray;
	}
	
	public Pet(int id, int ownerId, Date dateOfBirth, Spiecies spiecies, String name, PetGender gender, boolean desexed,
			Timestamp registeredAt, String councilRegistrationNumber, boolean isDeceased, boolean isStray) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.dateOfBirth = dateOfBirth;
		this.spiecies = spiecies;
		this.name = name;
		this.gender = gender;
		this.desexed = desexed;
		this.registeredAt = registeredAt;
		this.councilRegistrationNumber = councilRegistrationNumber;
		this.isDeceased = isDeceased;
		this.isStray = isStray;
	}

}
