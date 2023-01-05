import java.sql.Timestamp;

public class MedicalServiceBooked {
    private Integer appointmentID;
    private Integer ServiceID;
    private Integer resultID;

    public Integer getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Integer appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Integer getServiceID() {
        return ServiceID;
    }

    public void setServiceID(Integer serviceID) {
        ServiceID = serviceID;
    }

    public Integer getResultID() {
        return resultID;
    }

    public void setResultID(Integer resultID) {
        this.resultID = resultID;
    }

    public Timestamp getCostAtConfirmedTime() {
        return costAtConfirmedTime;
    }

    public void setCostAtConfirmedTime(Timestamp costAtConfirmedTime) {
        this.costAtConfirmedTime = costAtConfirmedTime;
    }

    private Timestamp costAtConfirmedTime;

    public MedicalServiceBooked() {
    }

    public MedicalServiceBooked(Integer appointmentID, Integer serviceID, Integer resultID, Timestamp costAtConfirmedTime) {
        this.appointmentID = appointmentID;
        ServiceID = serviceID;
        this.resultID = resultID;
        this.costAtConfirmedTime = costAtConfirmedTime;
    }
}
