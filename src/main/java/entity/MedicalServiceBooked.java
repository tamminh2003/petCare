package main.java.entity;

import java.math.BigDecimal;

public class MedicalServiceBooked {
    private int appointmentId;
    private int serviceId;
    private int resultId;
    private BigDecimal costAtConfirmedTime;

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public BigDecimal getCostAtConfirmedTime() {
        return costAtConfirmedTime;
    }

    public void setCostAtConfirmedTime(BigDecimal costAtConfirmedTime) {
        this.costAtConfirmedTime = costAtConfirmedTime;
    }

    public MedicalServiceBooked(int appointmentId, int serviceId, int resultId, BigDecimal costAtConfirmedTime) {
        this.appointmentId = appointmentId;
        this.serviceId = serviceId;
        this.resultId = resultId;
        this.costAtConfirmedTime = costAtConfirmedTime;
    }
}
