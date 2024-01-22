package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_plan);

        ImageButton btnHome = findViewById(R.id.home_icon);
        ImageButton btnProfile = findViewById(R.id.icon_Profile);

        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(PlanActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(PlanActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}
