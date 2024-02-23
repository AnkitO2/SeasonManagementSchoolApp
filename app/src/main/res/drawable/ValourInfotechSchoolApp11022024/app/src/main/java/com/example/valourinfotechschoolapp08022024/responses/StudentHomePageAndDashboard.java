package com.example.valourinfotechschoolapp08022024.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentHomePageAndDashboard {

    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("ClassName")
    @Expose
    private String className;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("GuardianName")
    @Expose
    private String guardianName;
    @SerializedName("RegistrationDate")
    @Expose
    private String registrationDate;
    @SerializedName("SectionName")
    @Expose
    private String sectionName;
    @SerializedName("StudentAddress")
    @Expose
    private String studentAddress;
    @SerializedName("StudentDOB")
    @Expose
    private String studentDOB;
    @SerializedName("StudentId")
    @Expose
    private String studentId;
    @SerializedName("StudentName")
    @Expose
    private String studentName;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(String studentDOB) {
        this.studentDOB = studentDOB;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}