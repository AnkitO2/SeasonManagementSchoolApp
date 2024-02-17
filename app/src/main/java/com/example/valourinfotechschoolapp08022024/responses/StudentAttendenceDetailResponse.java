package com.example.valourinfotechschoolapp08022024.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentAttendenceDetailResponse {
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;
    @SerializedName("StudentAttendenceDetail")
    @Expose
    private List<StudentAttendenceDetail> studentAttendenceDetail;

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

    public List<StudentAttendenceDetail> getStudentAttendenceDetail() {
        return studentAttendenceDetail;
    }

    public void setStudentAttendenceDetail(List<StudentAttendenceDetail> studentAttendenceDetail) {
        this.studentAttendenceDetail = studentAttendenceDetail;
    }
}
