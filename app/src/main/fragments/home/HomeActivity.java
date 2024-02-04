package com.example.myapplication.activity.home;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class HomeActivity extends AppCompatActivity {

    // Variables
    private int index = 0;
    private TextView textStatName;
    private TextView textStatNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set Layout
        setContentView(R.layout.page_home);

        // Initializer
        textStatName = findViewById(R.id.text_Home_StatName);
        textStatNumber = findViewById(R.id.text_Home_StatNumber);
        Button btnStatCycle = findViewById(R.id.btnStatCycle);
        ImageButton btnRocket = findViewById(R.id.icon_rocket);
        ImageButton btnProfile = findViewById(R.id.icon_Profile);

        // Initial Text Update
        updateStatValues();

        // Stat Changer Button
        btnStatCycle.setOnClickListener(v -> {
            ++index;
            // Bounds Check
            if (index < UserManager.getCurrentStat().length) {
                updateStatValues();
                // Loop
            } else {
                index = 0;
                updateStatValues();
            }
        });
        // Rocket Page Button
        btnRocket.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Activity_Plan_Menu.class);
            startActivity(intent);
        });
        // Profile Page Button
        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
    // Stat Text Box Updater
    private void updateStatValues() {
        String statName = (String) UserManager.getCurrentStat()[index][0];
        String statNumber = String.valueOf(UserManager.getCurrentStat()[index][1]);
        textStatName.setText(statName);
        textStatNumber.setText(statNumber);
    }
}