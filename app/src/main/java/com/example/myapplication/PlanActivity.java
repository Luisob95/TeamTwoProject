package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        setContentView(R.layout.page_plan_menu);

        TextView btnRandomize = findViewById(R.id.btn_Text_Randomizer);
        btnRandomize.setOnClickListener(v -> {
            setContentView(R.layout.page_plan_randomizer);
            LinearLayout layoutDifficulty = findViewById(R.id.linearLayout);
            createSpinnerButton(layoutDifficulty);
            ToggleButton toggleButton = findViewById(R.id.toggle_btn);
            toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
                layoutDifficulty.removeAllViews();
                if (isChecked) {
                    createSpinnerButton(layoutDifficulty);

                } else {

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
    // Difficulty
    public void createSpinnerButton(LinearLayout btnLayout) {
        TextView labelDifficulty = new TextView(this);
        labelDifficulty.setText("Difficulty");
        Spinner spnDifficulty = new Spinner(this);
        String[] items = {"Easy", "Medium", "Hard", "Nightmare"};
        labelDifficulty.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.customspinner, items);

        spnDifficulty.setAdapter(adapter);
        spnDifficulty.setBackgroundResource(R.drawable.rounded_spinner);
        btnLayout.addView(labelDifficulty);
        btnLayout.addView(spnDifficulty);
    }
    public void createNumberSliders(LinearLayout btnLayout) {

    }
}
