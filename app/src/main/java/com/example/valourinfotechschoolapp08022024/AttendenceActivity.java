package com.example.valourinfotechschoolapp08022024;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.valourinfotechschoolapp08022024.databinding.ActivityAttendenceBinding;
import com.example.valourinfotechschoolapp08022024.requests.StudentAttendenceDetailRequest;
import com.example.valourinfotechschoolapp08022024.responses.StudentAttendenceDetail;
import com.example.valourinfotechschoolapp08022024.responses.StudentAttendenceDetailResponse;
import com.example.valourinfotechschoolapp08022024.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendenceActivity extends AppCompatActivity {
private ActivityAttendenceBinding binding;
SharedPreferences sharedPreferences;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.menubaar,menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.item1){
            Intent intent = new Intent(AttendenceActivity.this,LeaveActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        }
        else if (id==R.id.item2) {
            Intent intent = new Intent(AttendenceActivity.this,CalenderActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        }
        else if (id == R.id.item3) {
            Intent intent = new Intent(AttendenceActivity.this,SubmissionActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        } else if (id ==R.id.item4) {
            Intent intent = new Intent(AttendenceActivity.this,MainActivity.class);
           // StudentAttendenceDetail();
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        } else if (id==R.id.item5) {
            Intent intent = new Intent(AttendenceActivity.this, LoginActitiy.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityAttendenceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        //sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        binding.studentId.setText(""+getIntent().getStringExtra("UserId"));
        StudentAttendenceDetail();

    }
    private void StudentAttendenceDetail(){
        StudentAttendenceDetailRequest studentAttendenceDetailRequest = new StudentAttendenceDetailRequest();
        studentAttendenceDetailRequest.setStudentId(getIntent().getStringExtra("UserId"));
        studentAttendenceDetailRequest.setFinYear("2021");
        RetrofitClient.getClient().StudentAttendenceCall(studentAttendenceDetailRequest).enqueue(new Callback<StudentAttendenceDetailResponse>() {
            @Override
            public void onResponse(Call<StudentAttendenceDetailResponse> call, Response<StudentAttendenceDetailResponse> response) {
                if (response.isSuccessful()){
                    Log.d("Response", "Body: " + response.body().toString());
                    List<StudentAttendenceDetail>list = response.body().getStudentAttendenceDetail();

                    binding.studentId.setText(""+getIntent().getStringExtra("UserId"));
                    binding.AttDated1.setText(list.get(0).getAttDated());
                    binding.AttStatus1.setText(list.get(1).getAttStatus());
                    binding.AttDated2.setText(list.get(2).getAttDated());
                    binding.AttStatus2.setText(list.get(3).getAttStatus());

                }
                else {
                    Toast.makeText(AttendenceActivity.this, "response is not successfully", Toast.LENGTH_SHORT);
                }
            }
            @Override
            public void onFailure(Call<StudentAttendenceDetailResponse> call, Throwable t) {
                Toast.makeText(AttendenceActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}