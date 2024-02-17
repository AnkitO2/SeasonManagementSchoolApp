package com.example.valourinfotechschoolapp08022024.retrofit;

import com.example.valourinfotechschoolapp08022024.requests.StudentAttendenceDetailRequest;
import com.example.valourinfotechschoolapp08022024.requests.StudentFeesSubmissionRequest;
import com.example.valourinfotechschoolapp08022024.requests.StudentHolidayCalenderRequest;
import com.example.valourinfotechschoolapp08022024.requests.UserLoginRequest;
import com.example.valourinfotechschoolapp08022024.responses.StudentAttendenceDetailResponse;
import com.example.valourinfotechschoolapp08022024.responses.StudentDashBoard;

import com.example.valourinfotechschoolapp08022024.responses.StudentFeesSubmissionResponse;
import com.example.valourinfotechschoolapp08022024.responses.StudentHolidayCalender;
import com.example.valourinfotechschoolapp08022024.responses.StudentHolidayCalenderResponse;
import com.example.valourinfotechschoolapp08022024.responses.StudentLeaveRequest;
import com.example.valourinfotechschoolapp08022024.responses.StudentLeaveResponse;
import com.example.valourinfotechschoolapp08022024.responses.UserLoginResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {
    @POST("Service/StudentLoginWithIDAndPassword")
    Call<UserLoginResponse>LoginWithIDAndPass(
            @Body UserLoginRequest requestModel
    );
    @POST("Service/StudentHomePageAndDashboard")
    Call<StudentDashBoard>StudentDashBoard(
            @Body JsonObject requestModel
    );
    @POST("Service/StudentLeaveApplication")
    Call<StudentLeaveResponse> StudentLeaveCall(
            @Body StudentLeaveRequest studentLeaveRequest
    );
    @POST("Service/StudentHolidayCalender")
    Call<StudentHolidayCalenderResponse>StudentHolidayCall (
            @Body StudentHolidayCalenderRequest studentHolidayCalenderRequest
            //@Body JsonObject jsonObject
    );
    @POST("Service/StudentFeesSubmission")
    Call<StudentFeesSubmissionResponse> StudentFeesCall(
            @Body StudentFeesSubmissionRequest studentFeesSubmissionRequest
    );
    @POST("Service/StudentAttendenceDetail")
    Call<StudentAttendenceDetailResponse>StudentAttendenceCall(@Body StudentAttendenceDetailRequest studentAttendenceDetailRequest);
}
