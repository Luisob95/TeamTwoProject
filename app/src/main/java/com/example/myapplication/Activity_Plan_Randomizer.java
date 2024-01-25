package com.example.myapplication;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Plan_Randomizer extends AppCompatActivity {

    private Spinner spnDifficulty;
    private EditText textFrequency;
    private EditText textDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_plan_randomizer);

        // Initialization
        ToggleButton togRandom = findViewById(R.id.toggle_btn);
        LinearLayout dynamicLayout = findViewById(R.id.linearLayout);
        ToggleButton togRecovery = findViewById(R.id.tog_ExerciseType_Recovery);
        ToggleButton togMental = findViewById(R.id.tog_ExerciseType_Mental);
        ToggleButton togEndurance = findViewById(R.id.tog_ExerciseType_Endurance);
        EditText editStartTime = findViewById(R.id.editTextStartTime);
        EditText editEndTime = findViewById(R.id.editTextEndTime);
        Button btnGenerate = findViewById(R.id.btnGenerate);
        spnDifficulty = new Spinner(this);
        textFrequency = new EditText(this);
        textDuration = new EditText(this);

        // Create Buttons For All Toggle
        createDifficultyBtn(dynamicLayout);

        // Toggle Button Functionality
        togRandom.setOnCheckedChangeListener((buttonView, isChecked) -> {
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

        btnGenerate.setOnClickListener(v -> {
            randomizerSaver(togRandom, togRecovery, togMental, togEndurance, editStartTime, editEndTime, spnDifficulty, textFrequency, textDuration);
        });
    }


    public void createDifficultyBtn(LinearLayout btnLayout) {
        // Difficulty Label
        TextView labelDifficulty = new TextView(getApplicationContext());
        labelDifficulty.setText("Difficulty");
        labelDifficulty.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnLayout.addView(labelDifficulty);

        // Drop Down Button
        String[] items = {"Easy", "Medium", "Hard", "Nightmare"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.customspinner, items);
        spnDifficulty.setAdapter(adapter);
        spnDifficulty.setBackgroundResource(R.drawable.rounded_spinner);
        btnLayout.addView(spnDifficulty);
    }

    public void createTimeSettingsButton(LinearLayout btnLayout) {
        // Label Frequency
        TextView labelFrequency = new TextView(getApplicationContext());
        labelFrequency.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        labelFrequency.setText("Frequency");
        btnLayout.addView(labelFrequency);

        // Frequency Number Box
        textFrequency.setInputType(InputType.TYPE_CLASS_NUMBER);
        textFrequency.setBackgroundResource(R.drawable.rounded_spinner);
        btnLayout.addView(textFrequency);

        // Label Duration
        TextView labelDuration = new TextView(getApplicationContext());
        labelDuration.setText("Duration");
        btnLayout.addView(labelDuration);

        // Duration Number Box
        textDuration.setInputType(InputType.TYPE_CLASS_NUMBER);
        textDuration.setBackgroundResource(R.drawable.rounded_spinner);
        labelDuration.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnLayout.addView(textDuration);
    }

    public void randomizerSaver(ToggleButton togRandom, ToggleButton togRecovery, ToggleButton togMental, ToggleButton togEndurance, EditText textStartTime, EditText textEndTime, Spinner spnDifficulty, EditText textFrequency, EditText textDuration) {

    }

    // Input error Checker
}
