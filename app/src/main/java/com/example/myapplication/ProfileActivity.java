package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_profile);

        ImageButton btnHome = findViewById(R.id.home_icon);
        ImageButton btnRocket = findViewById(R.id.icon_rocket);

        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
            startActivity(intent);
        });
        btnRocket.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, Activity_Plan_Menu.class);
            startActivity(intent);
        });
    }
}
