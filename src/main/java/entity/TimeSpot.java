package entity;

import java.sql.Time;

public class TimeSpot {
    private int ID;
    private Time startTime;
    private Time endTime;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public TimeSpot(int ID, Time startTime, Time endTime) {
        this.ID = ID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeSpot(Time startTime) {
        this.startTime = startTime;
    }
}
