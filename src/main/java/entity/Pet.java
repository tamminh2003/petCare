package entity;

import java.sql.Timestamp;
import java.util.Date;

public class Pet {
    private int id;
    private int ownerId;
    private Date dateOfBirth ;
    private enum Spiecies {
        CAT, DOG, OTHER
    }
    private String name;
    private enum Gender {
        MALE, FEMALE
    }
    private boolean desexed;
    private Timestamp registeredAt;
    private String councilRegistrationNumber;
    private boolean isDeceased;
    private boolean isStray;

    public Pet() {
        super();
    }

    public Pet(int id, int ownerId, Date dateOfBirth, String name, boolean desexed, Timestamp registeredAt, String councilRegistrationNumber, boolean isDeceased, boolean isStray) {
        super();
        this.id = id;
        this.ownerId = ownerId;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.desexed = desexed;
        this.registeredAt = registeredAt;
        this.councilRegistrationNumber = councilRegistrationNumber;
        this.isDeceased = isDeceased;
        this.isStray = isStray;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setDeceased(boolean deceased) {
        isDeceased = deceased;
    }

    public boolean isStray() {
        return isStray;
    }

    public void setStray(boolean stray) {
        isStray = stray;
    }
}
