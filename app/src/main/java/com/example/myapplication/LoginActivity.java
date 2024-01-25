package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            // Page Layout Setter
            setContentView(R.layout.page_login);

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

