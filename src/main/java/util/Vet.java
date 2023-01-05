package util;

public class Vet {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean isSpecialist;

    public Vet() {
        super();
    }

    public Vet(int id, String firstName, String lastName, String email, String phoneNumber, boolean isSpecialist) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isSpecialist = isSpecialist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public void setSpecialist(boolean specialist) {
        isSpecialist = specialist;
    }
}
