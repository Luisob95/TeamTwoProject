package com.example.myapplication.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.activity.MainActivity;
import com.example.myapplication.R;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            // Page Layout Setter
            setContentView(R.layout.login_layout);

            //Initializers
            Button loginBtn = findViewById(R.id.btnLogin);
            EditText usernameEditText = findViewById(R.id.username_EditText);
            EditText passwordEditText = findViewById(R.id.password_EditText);

            // Login Button Click
            loginBtn.setOnClickListener(v -> {
                // Password Check
                if ("admin".equals(usernameEditText.getText().toString()) &&
                     "admin".equals(passwordEditText.getText().toString())) {
                    // Set User Log In to True
                    UserManager.setUserLoggedIn(true);
                    // Change Activity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
         }
    }

