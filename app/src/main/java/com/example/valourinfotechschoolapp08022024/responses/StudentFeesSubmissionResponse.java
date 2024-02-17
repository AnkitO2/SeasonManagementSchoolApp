package com.example.valourinfotechschoolapp08022024.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentFeesSubmissionResponse {
    @SerializedName("FeeSubmitMessage")
    @Expose
    private String feeSubmitMessage;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;
    @SerializedName("StudentFeesSubmission")
    @Expose
    private StudentFeesSubmission studentFeesSubmission;
    public String getFeeSubmitMessage() {
        return feeSubmitMessage;
    }

    public void setFeeSubmitMessage(String feeSubmitMessage) {
        this.feeSubmitMessage = feeSubmitMessage;
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

    public StudentFeesSubmission getStudentFeesSubmission() {
        return studentFeesSubmission;
    }

    public void setStudentFeesSubmission(StudentFeesSubmission studentFeesSubmission) {
        this.studentFeesSubmission = studentFeesSubmission;
    }
}
