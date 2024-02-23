package com.example.valourinfotechschoolapp08022024.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class  StudentAttendenceDetail {
    @SerializedName("AttDated")
    @Expose
    private String attDated;
    @SerializedName("AttStatus")
    @Expose
    private String attStatus;

    public String getAttDated() {
        return attDated;
    }

    public void setAttDated(String attDated) {
        this.attDated = attDated;
    }

    public String getAttStatus() {
        return attStatus;
    }

    public void setAttStatus(String attStatus) {
        this.attStatus = attStatus;
    }
}
