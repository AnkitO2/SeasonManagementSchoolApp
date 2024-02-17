package com.example.valourinfotechschoolapp08022024;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.valourinfotechschoolapp08022024.databinding.ActivityLoginBinding;
import com.example.valourinfotechschoolapp08022024.databinding.ActivityMainBinding;
import com.example.valourinfotechschoolapp08022024.requests.UserLoginRequest;
import com.example.valourinfotechschoolapp08022024.responses.StudentDashBoard;
import com.example.valourinfotechschoolapp08022024.responses.StudentLeaveRequest;
import com.example.valourinfotechschoolapp08022024.responses.UserLoginResponse;
import com.example.valourinfotechschoolapp08022024.retrofit.RetrofitClient;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String Username="";
     String Classname="";
     SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        binding.year.setText("Student Year :" + getIntent().getStringExtra("Year"));
        binding.studentId.setText("Student Id " + getIntent().getStringExtra("UserId"));
        userDashboardData();
        binding.userDetailsBtn.setOnClickListener(v -> {
            userDashboardData();
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.menubaar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.item1){
            Intent intent = new Intent(MainActivity.this,LeaveActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        }
        else if (id==R.id.item2) {
            Intent intent = new Intent(MainActivity.this,CalenderActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        }
        else if (id == R.id.item3) {
            Intent intent = new Intent(MainActivity.this,SubmissionActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            intent.putExtra("UserName",""+Username);
            intent.putExtra("ClassName",""+Classname);
            startActivity(intent);
        } else if (id ==R.id.item4) {
            Intent intent = new Intent(MainActivity.this,AttendenceActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        } else if (id==R.id.item5) {
            Intent intent = new Intent(MainActivity.this,LoginActitiy.class);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("loginStatus","");
            editor.apply();
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    void userDashboardData() {
        JsonObject request = new JsonObject();
        if (sharedpreferences.getString("userId","").isEmpty()){
            request.addProperty("StudentId", getIntent().getStringExtra("UserId"));
        }else {
            request.addProperty("StudentId", sharedpreferences.getString("userId",""));
        }

        RetrofitClient.getClient().StudentDashBoard(request).enqueue(new Callback<StudentDashBoard>() {
            @Override
            public void onResponse(Call<StudentDashBoard> call, Response<StudentDashBoard> response) {
                if (response.isSuccessful()) {
                    //First Method
                    binding.txtId1.setText(response.body().getStudentHomePageAndDashboard().getStudentId());
                    binding.txtId2.setText(response.body().getStudentHomePageAndDashboard().getRegistrationDate());
                    binding.txtId3.setText(response.body().getStudentHomePageAndDashboard().getClassName());
                    binding.txtId4.setText(response.body().getStudentHomePageAndDashboard().getStudentName());
                    //Second Method
                    binding.txt.setText("Student Id  :"+response.body().getStudentHomePageAndDashboard().getStudentId()+"\n"+
                                        "RegistrationDate  :"+response.body().getStudentHomePageAndDashboard().getRegistrationDate()+"\n"+
                                        "ClassName  :"+response.body().getStudentHomePageAndDashboard().getClassName()+"\n"+
                                        "StudentName  :"+response.body().getStudentHomePageAndDashboard().getStudentName()+"\n"+
                                        "Gurdian Name  :"+response.body().getStudentHomePageAndDashboard().getGuardianName() +"\n"+
                                        "Gender  :"+response.body().getStudentHomePageAndDashboard().getGender() +"\n"+
                                        "Category  :"+response.body().getStudentHomePageAndDashboard().getCategory() +"\n");
                                        Username=response.body().getStudentHomePageAndDashboard().getStudentName();
                                        Classname=response.body().getStudentHomePageAndDashboard().getClassName();
                } else{
                    Toast.makeText(MainActivity.this, "response is not successfully"+response.body(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<StudentDashBoard> call, Throwable t) {
            Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }

}