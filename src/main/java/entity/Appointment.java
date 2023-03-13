package main.java.entity;

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

    private int id;
    private int customerId;
    private int petId;
    private int vetAssignmentId;
    private Timestamp confirmedAt;
    private String customerPhoneNumber;
	private String customerName;
    private Species species;
    private String purposeDescription;
    private String vetNotes;
    private BigDecimal totalPrice;
    private String medicationPrescribed;
    private Boolean isPaid;
    private Timestamp paidAt;
    private PaymentMethod paymentMethod;
    

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
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getVetAssignmentId() {
		return vetAssignmentId;
	}
	public void setVetAssignmentId(int vetAssignmentId) {
		this.vetAssignmentId = vetAssignmentId;
	}
	public Timestamp getConfirmedAt() {
		return confirmedAt;
	}
	public void setConfirmedAt(Timestamp confirmedAt) {
		this.confirmedAt = confirmedAt;
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
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
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
	public Boolean getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
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
	public Appointment(int id, int customerId, int petId, int vetAssignmentId, Timestamp confirmedAt,
			String customerPhoneNumber, String customerName, Species species, String purposeDescription,
			String vetNotes, BigDecimal totalPrice, String medicationPrescribed, Boolean isPaid, Timestamp paidAt,
			PaymentMethod paymentMethod) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.petId = petId;
		this.vetAssignmentId = vetAssignmentId;
		this.confirmedAt = confirmedAt;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerName = customerName;
		this.species = species;
		this.purposeDescription = purposeDescription;
		this.vetNotes = vetNotes;
		this.totalPrice = totalPrice;
		this.medicationPrescribed = medicationPrescribed;
		this.isPaid = isPaid;
		this.paidAt = paidAt;
		this.paymentMethod = paymentMethod;
	}
}
