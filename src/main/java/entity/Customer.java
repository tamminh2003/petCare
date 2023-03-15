package main.java.entity;

import java.sql.Timestamp;

public class Customer {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private Timestamp createdAt;
	private String password;

	public Customer(int id, String firstname, String lastname, String email, Timestamp createdAt, String password) {
		super(); // not really needed as java implicitly inherit Object class
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.createdAt = createdAt;
		this.password = password;
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	// TODO: Usually we don't modify createdAt information.
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	// TODO: This need to be encrypted
	public String getPassword() {
		return password;
	}

	// TODO: THis need to be encrypted
	public void setPassword(String password) {
		this.password = password;
	}
}
