package com.example.valourinfotechschoolapp08022024.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLoginResponse {
    @SerializedName("LoginMessage")
    @Expose
    private String loginMessage;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;
    @SerializedName("StudentLoginWithIDAndPassword")
    @Expose
    private UserIdDetails userIdDetails;

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
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

    public UserIdDetails getUserIdDetails() {
        return userIdDetails;
    }

    public void setStudentLoginWithIDAndPassword(UserIdDetails getUserIdDetails) {
        this.userIdDetails = getUserIdDetails;
    }
}
