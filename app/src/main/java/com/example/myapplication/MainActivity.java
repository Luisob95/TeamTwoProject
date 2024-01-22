package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent;
        if (!UserManager.isUserLoggedIn()) {
            intent = new Intent(MainActivity.this, LoginActivity.class);
        } else {
            intent = new Intent(MainActivity.this, HomeActivity.class);
        }
        startActivity(intent);
    }
}

