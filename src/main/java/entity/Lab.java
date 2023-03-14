package main.java.entity;

public class Lab {
    private int id;
    private String name;
    private String location;
    private String supportContact;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSupportContact() {
		return supportContact;
	}

	public void setSupportContact(String supportContact) {
		this.supportContact = supportContact;
	}

	public Lab(int id, String name, String location, String supportContact) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.supportContact = supportContact;
    }

}
