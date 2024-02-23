package com.example.valourinfotechschoolapp08022024;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.valourinfotechschoolapp08022024.databinding.ActivityImageBinding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageActivity extends AppCompatActivity {
private ActivityImageBinding binding;
    String sImage;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.menubaar,menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.item6){
            Intent intent = new Intent(ImageActivity.this,MainActivity.class);
            intent.putExtra("UserId",""+getIntent().getStringExtra("UserId"));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);


        // Code for Encode button
        binding.btnEncode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // check condition
                // check condition
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                    // Check condition
                    if (Environment.isExternalStorageManager()) {
                        // When permission is already granted
                        // or the app has All Files Access
                        // Call method
                        selectImage();
                    } else {
                        // When permission is not granted
                        // Request permission
                        Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                        startActivity(intent);
                    }
                } else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                    // For Android 10 and above
                    // Check condition
                    if (ContextCompat.checkSelfPermission(ImageActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {
                        // When permission is not granted
                        // Request permission
                        ActivityCompat.requestPermissions(ImageActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
                    }
                }
            }

        });

        // Code for Decode button
        binding.btnDecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // decode base64 string
                byte[] bytes= Base64.decode(sImage,Base64.DEFAULT);
                // Initialize bitmap
                Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                // set bitmap on imageView
                binding.imageView.setImageBitmap(bitmap);
            }
        });
    }
    private void selectImage() {
        // clear previous data
        binding.textView.setText("");
        binding.imageView.setImageBitmap(null);
        // Initialize intent
        Intent intent=new Intent(Intent.ACTION_PICK);
        // set type
        intent.setType("image/*");
        // start activity result
        startActivityForResult(Intent.createChooser(intent,"Select Image"),100);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // check condition
        if (requestCode==100 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            // when permission
            // is granted
            // call method
            selectImage();
        }
        else
        {
            // when permission is denied
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check condition
        if (requestCode==100 && resultCode==RESULT_OK && data!=null)
        {
            // when result is ok
            // initialize uri
            Uri uri=data.getData();
            // Initialize bitmap
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                // initialize byte stream
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                // compress Bitmap
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
                // Initialize byte array
                byte[] bytes=stream.toByteArray();
                // get base64 encoded string

                sImage= Base64.encodeToString(bytes,Base64.DEFAULT);
                // set encoded text on textview

                binding.textView.setText(sImage);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     }
}