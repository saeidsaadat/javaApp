package com.example.accesspermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACTS_PERMISSION = 1;
    private static final int REQUEST_STORAGE_PERMISSION = 2;
    private boolean isContactsPermissionGranted = false;
    private boolean isStoragePermissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button requestButton = findViewById(R.id.request_button);
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isContactsPermissionGranted) {
                    requestContactsPermission();
                } else if (!isStoragePermissionGranted) {
                    requestStoragePermission();
                } else {
                    Toast.makeText(MainActivity.this, "این مجوز از قبل داده شده", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void requestContactsPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CONTACTS_PERMISSION);
        } else {
            isContactsPermissionGranted = true;
            Toast.makeText(this, "اجازه دادی", Toast.LENGTH_SHORT).show();
        }
    }

    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_STORAGE_PERMISSION);
        } else {
            isStoragePermissionGranted = true;
            Toast.makeText(this, "اجازه دادی", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CONTACTS_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    isContactsPermissionGranted = true;
                    Toast.makeText(this, "اجازه دادی", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "ندادی", Toast.LENGTH_SHORT).show();
                }
                break;

            case REQUEST_STORAGE_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    isStoragePermissionGranted = true;
                    Toast.makeText(this, "اجازه دادی", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "ندادی", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
