package com.example.android1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals("admin") && password.equals("1234")) {
                    Toast.makeText(LoginActivity.this, "خوش آمدید", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "نام کاربری یا رمز عبور اشتباه است", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
