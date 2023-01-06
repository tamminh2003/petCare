package util;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Appointment {
    enum Species {
        Dog,
        Cat,
        Other
    }

    enum PaymentMethod {
        Cash,
        Card
    }

    private Integer ID;
    private Integer customerID;
    private Integer petID;
    private Species species;
    private Integer vetID;
    private Integer bookedServiceID;
    private Timestamp confirmAt;
    private Timestamp startTime;
    private Integer durationInMin;
    private String customerPhoneNumber;
    private String customerName;
    private String purposeDescription;
    private String vetNotes;
    private BigDecimal totalPrice;
    private String medicationPrescribed;
    private Boolean isPaid;
    private Timestamp paidAt;
    private PaymentMethod paymentMethod;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getPetID() {
        return petID;
    }

    public void setPetID(Integer petID) {
        this.petID = petID;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Integer getVetID() {
        return vetID;
    }

    public void setVetID(Integer vetID) {
        this.vetID = vetID;
    }

    public Integer getBookedServiceID() {
        return bookedServiceID;
    }

    public void setBookedServiceID(Integer bookedServiceID) {
        this.bookedServiceID = bookedServiceID;
    }

    public Timestamp getConfirmAt() {
        return confirmAt;
    }

    public void setConfirmAt(Timestamp confirmAt) {
        this.confirmAt = confirmAt;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Integer getDurationInMin() {
        return durationInMin;
    }

    public void setDurationInMin(Integer durationInMin) {
        this.durationInMin = durationInMin;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPurposeDescription() {
        return purposeDescription;
    }

    public void setPurposeDescription(String purposeDescription) {
        this.purposeDescription = purposeDescription;
    }

    public String getVetNotes() {
        return vetNotes;
    }

    public void setVetNotes(String vetNotes) {
        this.vetNotes = vetNotes;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMedicationPrescribed() {
        return medicationPrescribed;
    }

    public void setMedicationPrescribed(String medicationPrescribed) {
        this.medicationPrescribed = medicationPrescribed;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Timestamp getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Timestamp paidAt) {
        this.paidAt = paidAt;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Appointment(
            Integer ID,
            Integer customerID,
            Integer petID,
            Species species,
            Integer vetID,
            Integer bookedServiceID,
            Timestamp confirmAt,
            Timestamp startTime,
            Integer durationInMin,
            String customerPhoneNumber,
            String customerName,
            String purposeDescription,
            String vetNotes,
            BigDecimal totalPrice,
            String medicationPrescribed,
            Boolean isPaid,
            Timestamp paidAt,
            PaymentMethod paymentMethod
    ) {
        super();
        this.ID = ID;
        this.customerID = customerID;
        this.petID = petID;
        this.species = species;
        this.vetID = vetID;
        this.bookedServiceID = bookedServiceID;
        this.confirmAt = confirmAt;
        this.startTime = startTime;
        this.durationInMin = durationInMin;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerName = customerName;
        this.purposeDescription = purposeDescription;
        this.vetNotes = vetNotes;
        this.totalPrice = totalPrice;
        this.medicationPrescribed = medicationPrescribed;
        this.isPaid = isPaid;
        this.paidAt = paidAt;
        this.paymentMethod = paymentMethod;
    }

    public Appointment() {
    }
}
