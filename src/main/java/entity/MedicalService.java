package entity;

import java.math.BigDecimal;
import java.util.Date;

public class MedicalService {
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
    private String name;
    private String description;
    private String imageURL;
    private Date costValidFrom;
    private BigDecimal cost;
    private Boolean requiresSpecialist;
    private String requiresSpecialistField;
    private Integer labID;

    public MedicalService(Integer ID, String name, String description, String imageURL, Date costValidFrom, BigDecimal cost, Boolean requiresSpecialist, String requiresSpecialistField, Integer labID) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.costValidFrom = costValidFrom;
        this.cost = cost;
        this.requiresSpecialist = requiresSpecialist;
        this.requiresSpecialistField = requiresSpecialistField;
        this.labID = labID;
    }

    public MedicalService() {
    }

    public MedicalService(Integer ID, String name, String description, String imageURL) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
    }

}
