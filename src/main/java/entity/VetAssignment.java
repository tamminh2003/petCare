package main.java.entity;

import java.util.Date;

public class VetAssignment {
    private int id;
    private int vetId;
    private int spotId;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public VetAssignment(int id, int vetId, int spotId, Date date) {
		super();
		this.id = id;
		this.vetId = vetId;
		this.spotId = spotId;
		this.date = date;
	}

}
