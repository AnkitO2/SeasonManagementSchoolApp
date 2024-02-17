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
            startActivity(intent);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        } else if (id ==R.id.item4) {
            Intent intent = new Intent(AttendenceActivity.this,MainActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            StudentAttendenceDetail();
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
        binding.studentId.setText(""+getIntent().getStringExtra("UserId"));
        //StudentAttendenceDetail();

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
                    binding.AttDated1.setText(list.get(0).getAttDated());
                    binding.AttStatus1.setText(list.get(1).getAttStatus());
                    binding.AttDated2.setText(list.get(2).getAttDated());
                    binding.AttStatus2.setText(list.get(3).getAttStatus());
                    binding.AttDated3.setText(list.get(4).getAttDated());
                    binding.AttStatus3.setText(list.get(5).getAttStatus());
                    binding.AttDated4.setText(list.get(6).getAttDated());
                    binding.AttStatus4.setText(list.get(7).getAttStatus());
                    binding.AttDated5.setText(list.get(8).getAttDated());
                    binding.AttStatus5.setText(list.get(9).getAttStatus());
                    binding.AttDated6.setText(list.get(10).getAttDated());
                    binding.AttStatus6.setText(list.get(11).getAttStatus());
                    binding.AttDated7.setText(list.get(12).getAttDated());
                    binding.AttStatus7.setText(list.get(13).getAttStatus());
                    binding.AttDated8.setText(list.get(14).getAttDated());
                    binding.AttStatus8.setText(list.get(15).getAttStatus());
                    binding.AttDated9.setText(list.get(16).getAttDated());
                    binding.AttStatus9.setText(list.get(17).getAttStatus());
                    binding.AttDated10.setText(list.get(18).getAttDated());
                    binding.AttStatus10.setText(list.get(19).getAttStatus());
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