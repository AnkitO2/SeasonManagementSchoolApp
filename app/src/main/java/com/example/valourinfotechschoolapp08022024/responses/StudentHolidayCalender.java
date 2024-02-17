package com.example.valourinfotechschoolapp08022024.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentHolidayCalender {
    @SerializedName("HolidayDate")
    @Expose
    private String holidayDate;
    @SerializedName("HolidayName")
    @Expose
    private String holidayName;
    private final static long serialVersionUID = -3551402317865623762L;

    public String getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(String holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

}
