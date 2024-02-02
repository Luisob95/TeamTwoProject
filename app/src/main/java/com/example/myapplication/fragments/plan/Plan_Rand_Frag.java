package com.example.myapplication.fragments.plan;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.Fragment;
import com.example.myapplication.R;
import com.example.myapplication.RandomizerSettings;

public class Plan_Rand_Frag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Initializers
        View view = inflater.inflate(R.layout.plan_rand_layout, container, false);
        TextView durationText = view.findViewById(R.id.labelTextDuration);
        TextView perHour = view.findViewById(R.id.labelTextperHour);
        ToggleButton togRandom = view.findViewById(R.id.toggle_btn);
        ToggleButton togRecovery = view.findViewById(R.id.tog_ExerciseType_Recovery);
        ToggleButton togMental = view.findViewById(R.id.tog_ExerciseType_Mental);
        ToggleButton togEndurance = view.findViewById(R.id.tog_ExerciseType_Endurance);
        SeekBar seekFreq = view.findViewById(R.id.timePerHour);
        SeekBar seekDur = view.findViewById(R.id.duration);
        // Listeners
        // Have no Idea what to do may just make this menu the only thing on the randomizer
        togRandom.setOnClickListener(v -> {/* Check Value if statement on boolean*/});
        // Recovery Toggle
        togRecovery.setOnClickListener(v -> { RandomizerSettings.setRecovery(togRecovery.isChecked()); });
        // Mental Toggle
        togMental.setOnClickListener(v -> { RandomizerSettings.setMental(togMental.isChecked()); });
        // Endurance Toggle
        togEndurance.setOnClickListener(v -> { RandomizerSettings.setEndurance(togEndurance.isChecked()); });
        seekFreq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(seekFreq.getProgress() != 0 || seekDur.getProgress() != 0) {
                    seekImpossible(seekFreq, seekDur);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekSaver(seekFreq,seekDur,durationText,perHour);
            }
        });
        seekDur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(seekDur.getProgress() != 0 || seekFreq.getProgress() != 0) {
                    seekImpossible(seekDur, seekFreq);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekSaver(seekFreq,seekDur,durationText,perHour);

            }
        });


        return view;

    }
    // Methods
    public void seekImpossible(SeekBar moved, SeekBar notMoved) {
        while (moved.getProgress() * notMoved.getProgress() > 60) {
            notMoved.setProgress(notMoved.getProgress() - 1);
        }
    }
    public void seekSaver(SeekBar freq, SeekBar dur, TextView durationText, TextView perHour){
        RandomizerSettings.setFrequency(freq.getProgress());
        RandomizerSettings.setDuration(dur.getProgress());
        durationText.setText(dur.getProgress() + " Minutes per break");
        perHour.setText(freq.getProgress() + " Breaks per hour");
    }
}

