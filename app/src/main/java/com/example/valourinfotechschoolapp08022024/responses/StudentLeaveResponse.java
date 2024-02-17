package com.example.valourinfotechschoolapp08022024.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentLeaveResponse {
    @SerializedName("ApplicationMessage")
    @Expose
    private String applicationMessage;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;
    @SerializedName("StudentLeaveApplication")
    @Expose
    private StudentLeaveDetails studentLeaveDetails;


    public String getApplicationMessage() {
        return applicationMessage;
    }

    public void setApplicationMessage(String applicationMessage) {
        this.applicationMessage = applicationMessage;
    }

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

    public StudentLeaveDetails getStudentLeaveDetails() {
        return studentLeaveDetails;
    }

    public void setStudentLeaveApplication(StudentLeaveDetails studentLeaveDetails) {
        this.studentLeaveDetails = studentLeaveDetails;
    }
}
