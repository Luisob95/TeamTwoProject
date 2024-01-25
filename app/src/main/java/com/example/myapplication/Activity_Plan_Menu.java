package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Plan_Menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set Layout
        setContentView(R.layout.page_plan_menu);

        // Initializer
        TextView btnRandomize = findViewById(R.id.btn_Text_Randomizer);
        ImageButton btnHome = findViewById(R.id.home_icon);
        ImageButton btnProfile = findViewById(R.id.icon_Profile);

        // Plan Navigation
        //Randomize
        btnRandomize.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_Plan_Menu.this, Activity_Plan_Randomizer.class);
            startActivity(intent);
        });
        /*
         TextView btnLoad = findViewById(R.id.btn_Text_Load);
        TextView btnNew = findViewById(R.id.btn_Text_New);
        // Load
        btnLoad.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_Plan_Menu.this, Activity_Plan_Load.class);
            startActivity(intent);
        });
        // New
        btnNew.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_Plan_Menu.this, Activity_Plan_New.class);
            startActivity(intent);
        });

         */
        // Menu Navigation
        // Home
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_Plan_Menu.this, HomeActivity.class);
            startActivity(intent);
        });
        // Profile
        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_Plan_Menu.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}
