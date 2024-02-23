package com.example.valourinfotechschoolapp08022024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.valourinfotechschoolapp08022024.databinding.ActivityLoginBinding;
import com.example.valourinfotechschoolapp08022024.requests.UserLoginRequest;
import com.example.valourinfotechschoolapp08022024.responses.UserLoginResponse;
import com.example.valourinfotechschoolapp08022024.retrofit.RetrofitClient;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActitiy extends AppCompatActivity {
    ActivityLoginBinding binding;
    String userId="",password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginBtn.setOnClickListener(v -> {
          if (binding.usernameInputEditText.getText().toString().isEmpty()) {
              Toast.makeText(this, "Please Enter User Id", Toast.LENGTH_SHORT).show();
          } else if (binding.passwordInputEditText.getText().toString().isEmpty()) {
              Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
          }else {
              studentLogin();

          }
        });



    }


    void studentLogin(){
        UserLoginRequest request= new UserLoginRequest();
        request.setStudentId(binding.usernameInputEditText.getText().toString());
        request.setPassword(binding.passwordInputEditText.getText().toString());
        RetrofitClient.getClient().LoginWithIDAndPass(request).enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getLoginMessage().equalsIgnoreCase("Student Login Successfull")){
                        Intent intent = new Intent(LoginActitiy.this,MainActivity.class);
                        intent.putExtra("Year",""+response.body().getUserIdDetails().getFinYear());
                        intent.putExtra("UserId",""+response.body().getUserIdDetails().getStudentId());
                        startActivity(intent);

                    }else {
                        Toast.makeText(LoginActitiy.this, ""+response.body().getLoginMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {

            }
        });
    }


}