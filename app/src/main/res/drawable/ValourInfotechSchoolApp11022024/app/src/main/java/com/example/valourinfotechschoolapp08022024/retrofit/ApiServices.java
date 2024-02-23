package com.example.valourinfotechschoolapp08022024.retrofit;

import android.view.PixelCopy;

import com.example.valourinfotechschoolapp08022024.requests.UserLoginRequest;
import com.example.valourinfotechschoolapp08022024.responses.StudentDashBoard;
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
}
