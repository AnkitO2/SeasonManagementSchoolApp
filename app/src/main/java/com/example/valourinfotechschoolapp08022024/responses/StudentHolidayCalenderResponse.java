package com.example.valourinfotechschoolapp08022024.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentHolidayCalenderResponse {
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;
    @SerializedName("StudentHolidayCalender")
    @Expose
    private List<StudentHolidayCalender> studentHolidayCalender;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<StudentHolidayCalender> getStudentHolidayCalender() {
        return studentHolidayCalender;
    }

    public void setStudentHolidayCalender(List<StudentHolidayCalender> studentHolidayCalender) {
        this.studentHolidayCalender = studentHolidayCalender;
    }
}
