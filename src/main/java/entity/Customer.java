package main.java.entity;

public class Customer {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String phoneNumber;
	private String password;
	
	static final String DEFAULT_FIRST_NAME = "";
	static final String DEFAULT_LAST_NAME = "";
	static final String DEFAULT_EMAIL = "";
	static final String DEFAULT_PHONE_NUMBER = "";
	static final String DEFAULT_PASSWORD = "";

	public Customer(int id, String firstname, String lastname, String email, String phoneNumber, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	public Customer(int id, String firstname, String lastname, String email, String phoneNumber) {
		this(id, firstname, lastname, email, phoneNumber, DEFAULT_PASSWORD);
	}
	
	public Customer(int id, String firstname, String lastname, String email) {
		this(id, firstname, lastname, email, DEFAULT_PHONE_NUMBER);
	}
	
	public Customer(int id, String firstname, String lastname) {
		this(id, firstname, lastname, DEFAULT_EMAIL);
	}
	
	public Customer(int id, String firstname) {
		this(id, firstname, DEFAULT_LAST_NAME);
	}
	
	public Customer(int id) {
		this(id, DEFAULT_FIRST_NAME);
	}
	
	public Customer() {
		this(-1);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
