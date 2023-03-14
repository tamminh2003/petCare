package main.java.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MedicalService {
    private int id;
    private String medicalServiceCode;
    private String description;
    private Date costValidFrom;
    private BigDecimal cost;
    private Boolean requiresSpecialist;
    private String requiresSpecialistField;
    private int labId;
    private Boolean needsBookingByVet;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMedicalServiceCode() {
		return medicalServiceCode;
	}
	public void setMedicalServiceCode(String medicalServiceCode) {
		this.medicalServiceCode = medicalServiceCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCostValidFrom() {
		return costValidFrom;
	}
	public void setCostValidFrom(Date costValidFrom) {
		this.costValidFrom = costValidFrom;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public Boolean getRequiresSpecialist() {
		return requiresSpecialist;
	}
	public void setRequiresSpecialist(Boolean requiresSpecialist) {
		this.requiresSpecialist = requiresSpecialist;
	}
	public String getRequiresSpecialistField() {
		return requiresSpecialistField;
	}
	public void setRequiresSpecialistField(String requiresSpecialistField) {
		this.requiresSpecialistField = requiresSpecialistField;
	}
	public int getLabId() {
		return labId;
	}
	public void setLabId(int labId) {
		this.labId = labId;
	}
	public Boolean getNeedsBookingByVet() {
		return needsBookingByVet;
	}
	public void setNeedsBookingByVet(Boolean needsBookingByVet) {
		this.needsBookingByVet = needsBookingByVet;
	}
	public MedicalService(int id, String medicalServiceCode, String description, Date costValidFrom,
			BigDecimal cost, Boolean requiresSpecialist, String requiresSpecialistField, int labId,
			Boolean needsBookingByVet) {
		super();
		this.id = id;
		this.medicalServiceCode = medicalServiceCode;
		this.description = description;
		this.costValidFrom = costValidFrom;
		this.cost = cost;
		this.requiresSpecialist = requiresSpecialist;
		this.requiresSpecialistField = requiresSpecialistField;
		this.labId = labId;
		this.needsBookingByVet = needsBookingByVet;
	}
    
    

}
