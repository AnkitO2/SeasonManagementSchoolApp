package com.example.valourinfotechschoolapp08022024.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentDashBoard {
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;
    @SerializedName("StudentHomePageAndDashboard")
    @Expose
    private StudentHomePageAndDashboard studentHomePageAndDashboard;

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

    public StudentHomePageAndDashboard getStudentHomePageAndDashboard() {
        return studentHomePageAndDashboard;
    }

    public void setStudentHomePageAndDashboard(StudentHomePageAndDashboard studentHomePageAndDashboard) {
        this.studentHomePageAndDashboard = studentHomePageAndDashboard;
    }

}

