package main.java.entity;

public class Vet {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean isSpecialist;
    private String specialistField;
    
	public int getId() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isSpecialist() {
		return isSpecialist;
	}
	public void setSpecialist(boolean isSpecialist) {
		this.isSpecialist = isSpecialist;
	}
	public String getSpecialistField() {
		return specialistField;
	}
	public void setSpecialistField(String specialistField) {
		this.specialistField = specialistField;
	}
	public Vet(int id, String firstName, String middleName, String lastName, String email, String phoneNumber,
			boolean isSpecialist, String specialistField) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isSpecialist = isSpecialist;
		this.specialistField = specialistField;
	}
    

}
