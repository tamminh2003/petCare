package util;

import java.math.BigDecimal;
import java.util.Date;

public class MedicalService {
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public Integer getLabID() {
        return labID;
    }

    public void setLabID(Integer labID) {
        this.labID = labID;
    }

    private Integer ID;
    private String description;
    private Date costValidFrom;
    private BigDecimal cost;
    private Boolean requiresSpecialist;
    private String requiresSpecialistField;
    private Integer labID;

    public MedicalService(Integer ID, String description, Date costValidFrom, BigDecimal cost, Boolean requiresSpecialist, String requiresSpecialistField, Integer labID) {
        this.ID = ID;
        this.description = description;
        this.costValidFrom = costValidFrom;
        this.cost = cost;
        this.requiresSpecialist = requiresSpecialist;
        this.requiresSpecialistField = requiresSpecialistField;
        this.labID = labID;
    }

    public MedicalService() {
    }
}
