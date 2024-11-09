package com.example.android1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button openGoogleButton = findViewById(R.id.openGoogleButton);
        Button contactUsButton = findViewById(R.id.contactUsButton);
        Button messageToAdminButton = findViewById(R.id.messageToAdminButton);

        openGoogleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String googleLink = "https://www.google.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleLink));
                startActivity(intent);
            }
        });

        contactUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "123456789";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });

        messageToAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:123456789"));
                intent.putExtra("sms_body", "پیام شما");
                startActivity(intent);
            }
        });
    }
}

