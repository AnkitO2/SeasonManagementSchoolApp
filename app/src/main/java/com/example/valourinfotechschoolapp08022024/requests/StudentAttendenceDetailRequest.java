package com.example.valourinfotechschoolapp08022024.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentAttendenceDetailRequest {
    @SerializedName("FinYear")
    @Expose
    private String finYear;
    @SerializedName("StudentId")
    @Expose
    private String studentId;
    private final static long serialVersionUID = 7773972750439498434L;

    public String getFinYear() {
        return finYear;
    }

    public void setFinYear(String finYear) {
        this.finYear = finYear;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
