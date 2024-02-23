package com.example.valourinfotechschoolapp08022024;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.valourinfotechschoolapp08022024.databinding.ActivityLeaveBinding;
import com.example.valourinfotechschoolapp08022024.responses.StudentLeaveRequest;
import com.example.valourinfotechschoolapp08022024.responses.StudentLeaveResponse;
import com.example.valourinfotechschoolapp08022024.retrofit.RetrofitClient;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaveActivity extends AppCompatActivity {
    final Calendar myCalendar = Calendar.getInstance();
private ActivityLeaveBinding binding;
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
            Intent intent = new Intent(LeaveActivity.this,MainActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            StudentLeaveDetails();
            startActivity(intent);
        } else if (id ==R.id.item2) {
            Intent intent =new Intent(LeaveActivity.this,CalenderActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        } else if (id==R.id.item3) {
            Intent intent = new Intent(LeaveActivity.this,SubmissionActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        } else if (id==R.id.item4) {
            Intent intent =new Intent(LeaveActivity.this,AttendenceActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        } else if (id==R.id.item5) {
            Intent intent = new Intent(LeaveActivity.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLeaveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        binding.studentId.setText(""+getIntent().getStringExtra("UserId"));

    binding.SubmitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Integer.parseInt(binding.EditLeaveDays.getText().toString())<=2){
                StudentLeaveDetails();
            }
            else {
                Toast.makeText( LeaveActivity.this, "Leave Not Allowed For more Than Two Days", Toast.LENGTH_SHORT).show();
            }
        }
    });
        DatePickerDialog.OnDateSetListener Fromdate =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateFromDATE();
            }
        };
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
              updateToDATE();
            }
        };
        binding.editFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(LeaveActivity.this,Fromdate,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//                String myFormat="MM/dd/yy";
//                SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
//                binding.editFromDate.setText(dateFormat.format(myCalendar.getTime()));
            }
        });
        binding.editToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(LeaveActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//                String myFormat="MM/dd/yy";
//                SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
//                binding.editToDate.setText(dateFormat.format(myCalendar.getTime()));
            }
        });
    }

    private void updateFromDATE(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        binding.editFromDate.setText(dateFormat.format(myCalendar.getTime()));
    }
    private void updateToDATE(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        binding.editToDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void StudentLeaveDetails(){
        StudentLeaveRequest studentLeaveRequest =new StudentLeaveRequest();
        studentLeaveRequest.setStudentId(getIntent().getStringExtra("UserId"));
        studentLeaveRequest.setStudentId(binding.studentId.getText().toString());
        studentLeaveRequest.setLeaveReason(binding.EditLeaveReason.getText().toString());
        studentLeaveRequest.setLeaveDays(binding.EditLeaveDays.getText().toString());
        studentLeaveRequest.setFromDate(binding.editFromDate.getText().toString());
        studentLeaveRequest.setToDate(binding.editToDate.getText().toString());

        RetrofitClient.getClient().StudentLeaveCall(studentLeaveRequest).enqueue(new Callback<StudentLeaveResponse>() {
            @Override
            public void onResponse(Call<StudentLeaveResponse> call, Response<StudentLeaveResponse> response) {
                if (response.isSuccessful()){
                    Log.d("Response", "Body: " + response.body().toString());

                    //binding.studentId.setText(response.body().getStudentLeaveDetails().getStudentId());

                    binding.studentIdId.setText("Student Id : "+response.body().getStudentLeaveDetails().getStudentId()+"\n");
                    binding.LeaveDays.setText("Leave Days : "+ response.body().getStudentLeaveDetails().getLeaveDays()+"\n" );
                    binding.LeaveReason.setText("Leave Reason  : "+response.body().getStudentLeaveDetails().getLeaveReason());
                    binding.rFromDate.setText("From Date : "+response.body().getStudentLeaveDetails().getFromDate());
                    binding.rToDate.setText("To Date : "+response.body().getStudentLeaveDetails().getToDate());
                    binding.leaveStatus.setText(response.body().getApplicationMessage());

                    //binding.studentIdId.setText(response.body().getStudentLeaveDetails().getStudentId());
                    //binding.LeaveDays.setText(response.body().getStudentLeaveDetails().getLeaveDays());
                    // binding.LeaveReason.setText(response.body().getStudentLeaveDetails().getLeaveReason());
                    // binding.rFromDate.setText(response.body().getStudentLeaveDetails().getFromDate());
                    // binding.rToDate.setText(response.body().getStudentLeaveDetails().getToDate());
                    //binding.txtEdit.setText("Gurdian Name :"+response.body().getStudentHomePageAndDashboard().getCategory()+"\n");
                } else {
                    Toast.makeText(LeaveActivity.this, "response is not successfully", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<StudentLeaveResponse> call, Throwable t) {
            Toast.makeText(LeaveActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
