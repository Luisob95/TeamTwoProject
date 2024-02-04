package com.example.myapplication.activity.plan;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class Plan_Rand_Frag extends Fragment {
    private Spinner spnDifficulty;
    private EditText textFrequency;
    private EditText textDuration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plan_layout, container, false);
        // Initializers
        ToggleButton togRandom = view.findViewById(R.id.toggle_btn);
        LinearLayout dynamicLayout = view.findViewById(R.id.linearLayout);
        ToggleButton togRecovery = view.findViewById(R.id.tog_ExerciseType_Recovery);
        ToggleButton togMental = view.findViewById(R.id.tog_ExerciseType_Mental);
        ToggleButton togEndurance = view.findViewById(R.id.tog_ExerciseType_Endurance);
        EditText editStartTime = view.findViewById(R.id.editTextStartTime);
        EditText editEndTime = view.findViewById(R.id.editTextEndTime);
        Button btnGenerate = view.findViewById(R.id.btnGenerate);
        spnDifficulty = new Spinner(requireContext());
        textFrequency = new EditText(requireContext());
        textDuration = new EditText(requireContext());
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
        return view;
    }

    public void createDifficultyBtn(LinearLayout btnLayout) {
        // Difficulty Label
        TextView labelDifficulty = new TextView(requireContext());
        labelDifficulty.setText("Difficulty");
        labelDifficulty.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnLayout.addView(labelDifficulty);

        // Drop Down Button
        String[] items = {"Easy", "Medium", "Hard", "Nightmare"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.customspinner, items);
        spnDifficulty.setAdapter(adapter);
        spnDifficulty.setBackgroundResource(R.drawable.rounded_spinner);
        btnLayout.addView(spnDifficulty);
    }

    public void createTimeSettingsButton(LinearLayout btnLayout) {
        // Label Frequency
        TextView labelFrequency = new TextView(requireContext());
        labelFrequency.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        labelFrequency.setText("Frequency");
        btnLayout.addView(labelFrequency);

        // Frequency Number Box
        textFrequency.setInputType(InputType.TYPE_CLASS_NUMBER);
        textFrequency.setBackgroundResource(R.drawable.rounded_spinner);
        btnLayout.addView(textFrequency);

        // Label Duration
        TextView labelDuration = new TextView(requireContext());
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
}



