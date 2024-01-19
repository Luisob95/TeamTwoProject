package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        {
            setContentView(R.layout.page_login);
            Button loginBtn = findViewById(R.id.btnLogin);
            EditText usernameEditText = findViewById(R.id.username_EditText);
            EditText passwordEditText = findViewById(R.id.password_EditText);
            loginBtn.setOnClickListener(v -> {
                if ("admin".equals(usernameEditText.getText().toString()) &&
                        "admin".equals(passwordEditText.getText().toString())) {
                    setContentView(R.layout.page_home);
                }
                else {}
            });
            /*
            boolean loggedIn = false;
            if (!loggedIn) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }
        setContentView(R.layout.page_home);
        */

        }
    }
}