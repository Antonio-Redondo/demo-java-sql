package com.example.demojavasql.dto;


import java.util.Date;

/**
 * Created by arm on 27/01/2018.
 */
public class AccessDTO {




    private String startDateString;

    private String time;

    public String getStartDateString() {
        return startDateString;
    }

    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

    private long duration;

    private long threshold;

    private String message;



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getThreshold() {
        return threshold;
    }

    public void setThreshold(long threshold) {
        this.threshold = threshold;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
