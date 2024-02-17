package com.example.valourinfotechschoolapp08022024.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLoginRequest {
    @SerializedName("StudentId")
    @Expose
    private String studentId;
    @SerializedName("Password")
    @Expose
    private String password;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}