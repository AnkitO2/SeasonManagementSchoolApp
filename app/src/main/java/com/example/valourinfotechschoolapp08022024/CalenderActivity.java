package com.example.valourinfotechschoolapp08022024;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.valourinfotechschoolapp08022024.databinding.ActivityCalenderBinding;
import com.example.valourinfotechschoolapp08022024.requests.StudentHolidayCalenderRequest;
import com.example.valourinfotechschoolapp08022024.responses.StudentHolidayCalender;
import com.example.valourinfotechschoolapp08022024.responses.StudentHolidayCalenderResponse;
import com.example.valourinfotechschoolapp08022024.retrofit.RetrofitClient;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalenderActivity extends AppCompatActivity {
private ActivityCalenderBinding binding;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.menubaar,menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.item1){
            Intent intent = new Intent(CalenderActivity.this,LeaveActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        }
        else if (id==R.id.item2) {
            Intent intent = new Intent(CalenderActivity.this,MainActivity.class);
             intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
             HolidayCalender();
            startActivity(intent);
        }
        else if (id == R.id.item3) {
            Intent intent = new Intent(CalenderActivity.this,SubmissionActivity.class);
             startActivity(intent);
          intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        } else if (id ==R.id.item4) {
            Intent intent = new Intent(CalenderActivity.this,AttendenceActivity.class);
             intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        } else if (id==R.id.item5) {
            Intent intent = new Intent(CalenderActivity.this, LoginActitiy.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalenderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        binding.studentId.setText(""+getIntent().getStringExtra("UserId"));
        HolidayCalender();
    }
    private void HolidayCalender(){
        StudentHolidayCalenderRequest studentHolidayCalenderRequest = new StudentHolidayCalenderRequest();
        studentHolidayCalenderRequest.setStudentId(getIntent().getStringExtra("UserId"));
        studentHolidayCalenderRequest.setFinYear("2021");

        RetrofitClient.getClient().StudentHolidayCall(studentHolidayCalenderRequest).enqueue(new Callback<StudentHolidayCalenderResponse>() {
            @Override
            public void onResponse(Call<StudentHolidayCalenderResponse> call, Response<StudentHolidayCalenderResponse> response) {
                if (response.isSuccessful()){
                    Log.d("Response", "Body: " + response.body().toString());
                    List<StudentHolidayCalender>list = response.body().getStudentHolidayCalender();
                    binding.studentId.setText(""+getIntent().getStringExtra("UserId"));
                    binding.HolidayDate1.setText(list.get(1).getHolidayDate());
                    binding.HolidayName1.setText(list.get(2).getHolidayName());
                    binding.HolidayDate2.setText(list.get(3).getHolidayDate());
                    binding.HolidayName2.setText(list.get(4).getHolidayName());
                    binding.HolidayDate3.setText(list.get(5).getHolidayDate());
                    binding.HolidayName3.setText(list.get(6).getHolidayName());
                    binding.HolidayDate4.setText(list.get(7).getHolidayDate());
                    binding.HolidayName4.setText(list.get(8).getHolidayName());
                    binding.HolidayDate5.setText(list.get(9).getHolidayDate());
                    binding.HolidayName5.setText(list.get(10).getHolidayName());
                    binding.HolidayDate6.setText(list.get(11).getHolidayDate());
                    binding.HolidayName6.setText(list.get(12).getHolidayName());
                    binding.HolidayDate7.setText(list.get(13).getHolidayDate());
                    binding.HolidayName7.setText(list.get(14).getHolidayName());
                    binding.HolidayDate8.setText(list.get(15).getHolidayDate());
                    binding.HolidayName8.setText(list.get(16).getHolidayName());
                    binding.HolidayDate9.setText(list.get(17).getHolidayDate());
                    binding.HolidayName9.setText(list.get(18).getHolidayName());
                    binding.HolidayDate10.setText(list.get(19).getHolidayDate());
                    binding.HolidayName10.setText(list.get(20).getHolidayName());
                }
                else {
                    Toast.makeText(CalenderActivity.this, "response is not successfully", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<StudentHolidayCalenderResponse> call, Throwable t) {
            Toast.makeText(CalenderActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}