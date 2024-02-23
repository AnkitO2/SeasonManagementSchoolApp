package com.example.valourinfotechschoolapp08022024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.valourinfotechschoolapp08022024.databinding.ActivityLoginBinding;
import com.example.valourinfotechschoolapp08022024.databinding.ActivityMainBinding;
import com.example.valourinfotechschoolapp08022024.requests.UserLoginRequest;
import com.example.valourinfotechschoolapp08022024.responses.StudentDashBoard;
import com.example.valourinfotechschoolapp08022024.responses.UserLoginResponse;
import com.example.valourinfotechschoolapp08022024.retrofit.RetrofitClient;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.year.setText("Student Year :" + getIntent().getStringExtra("Year"));
        binding.studentId.setText("Student Id " + getIntent().getStringExtra("UserId"));

        binding.userDetailsBtn.setOnClickListener(v -> {
            userDashboardData();

        });
    }

    void userDashboardData() {

        JsonObject request = new JsonObject();
        request.addProperty("StudentId", getIntent().getStringExtra("UserId"));
        RetrofitClient.getClient().StudentDashBoard(request).enqueue(new Callback<StudentDashBoard>() {
            @Override
            public void onResponse(Call<StudentDashBoard> call, Response<StudentDashBoard> response) {
                if (response.isSuccessful()) {
                    binding.txt.setText("Student Id  :"+response.body().getStudentHomePageAndDashboard().getStudentId()+"\n"+
                                        "RegistrationDate  :"+response.body().getStudentHomePageAndDashboard().getRegistrationDate()+"\n"+
                                        "ClassName  :"+response.body().getStudentHomePageAndDashboard().getClassName()+"\n"+
                                        "StudentName  :"+response.body().getStudentHomePageAndDashboard().getStudentName()+"\n");
                }
            }

            @Override
            public void onFailure(Call<StudentDashBoard> call, Throwable t) {

            }
        });

    }
}