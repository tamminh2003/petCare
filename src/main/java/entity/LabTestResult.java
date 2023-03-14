package main.java.entity;

import java.sql.Timestamp;

public class LabTestResult {
    private int id;
    private Timestamp orderedAt;
    private String result;
    private Timestamp releasedAt;

    public LabTestResult(int id, Timestamp orderedAt, String result, Timestamp releasedAt) {
        super();
        this.id = id;
        this.orderedAt = orderedAt;
        this.result = result;
        this.releasedAt = releasedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Timestamp orderedAt) {
        this.orderedAt = orderedAt;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Timestamp getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(Timestamp releasedAt) {
        this.releasedAt = releasedAt;
    }
}
