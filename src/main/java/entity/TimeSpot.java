package main.java.entity;

import java.sql.Time;

public class TimeSpot {
    private int id;
    private Time startTime;
    private Time endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public TimeSpot(int id, Time startTime, Time endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
