package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

public class PlanActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set Layout
        setContentView(R.layout.page_plan_menu);
        // Randomize Navigation
        TextView btnRandomize = findViewById(R.id.btn_Text_Randomizer);
        btnRandomize.setOnClickListener(v -> {
            setContentView(R.layout.page_plan_randomizer); //Need to make this an intent to switch activity and move all randomize functional
            // Initialization
            ToggleButton toggleButton = findViewById(R.id.toggle_btn);
            LinearLayout dynamicLayout = findViewById(R.id.linearLayout);
            // Create Buttons For All Toggle
            createDifficultyBtn(dynamicLayout);
            // Toggle Button Functionality
            toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
                // Delete Current Dynamic Buttons
                dynamicLayout.removeAllViews();
                // If All
                if (isChecked) {
                    createDifficultyBtn(dynamicLayout);
                }
                // If Exercise
                else {
                    createTimeSettingsButton(dynamicLayout);
                }
            });
        });
        // Menu Navigation
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
    public void createDifficultyBtn(LinearLayout btnLayout) {
        // Difficulty Label
        TextView labelDifficulty = new TextView(this);
        labelDifficulty.setText("Difficulty");
        labelDifficulty.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnLayout.addView(labelDifficulty);
        // Drop Down Button
        Spinner spnDifficulty = new Spinner(this);
        String[] items = {"Easy", "Medium", "Hard", "Nightmare"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.customspinner, items);
        spnDifficulty.setAdapter(adapter);
        spnDifficulty.setBackgroundResource(R.drawable.rounded_spinner);
        btnLayout.addView(spnDifficulty);
    }
    public void createTimeSettingsButton(LinearLayout btnLayout){
        // Label Frequency
        TextView labelFrequency = new TextView(this);
        labelFrequency.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        labelFrequency.setText("Frequency");
        btnLayout.addView(labelFrequency);
        // Frequency Number Box
        EditText textFrequency = new EditText(this);
        textFrequency.setInputType(InputType.TYPE_CLASS_NUMBER);
        textFrequency.setBackgroundResource(R.drawable.rounded_spinner);
        btnLayout.addView(textFrequency);
        // Label Duration
        TextView labelDuration = new TextView(this);
        labelDuration.setText("Duration");
        btnLayout.addView(labelDuration);
        // Duration Number Box
        EditText textDuration = new EditText(this);
        textDuration.setInputType(InputType.TYPE_CLASS_NUMBER);
        textDuration.setBackgroundResource(R.drawable.rounded_spinner);
        labelDuration.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnLayout.addView(textDuration);
    }
}
