package com.example.valourinfotechschoolapp08022024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.window.SplashScreen;

import com.example.valourinfotechschoolapp08022024.databinding.ActivitySpashBinding;

public class SpashActivity extends AppCompatActivity {
 private   ActivitySpashBinding binding;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivitySpashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String logiStatus=sharedpreferences.getString("loginStatus", "");
                if (logiStatus.isEmpty()){
                    Intent  intent = new Intent(SpashActivity.this, LoginActitiy.class);
                    startActivity(intent);
                }else {
                    Intent  intent = new Intent(SpashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        },3000);
    }
}