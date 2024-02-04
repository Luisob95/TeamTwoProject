package com.example.myapplication.fragments.main;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import com.example.myapplication.R;
import com.example.myapplication.ScheduleManager;
import com.example.myapplication.Settings;

public class Plan_Frag extends Fragment {
    // Variables
    private TextView durationText;
    private TextView perHour;
    private SeekBar seekFreq;
    private SeekBar seekDur;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Initializers
        View view = inflater.inflate(R.layout.plan_layout, container, false);
        durationText = view.findViewById(R.id.labelTextDuration);
        perHour = view.findViewById(R.id.labelTextperHour);
        ToggleButton togRandom = view.findViewById(R.id.toggle_btn);
        ToggleButton togRecovery = view.findViewById(R.id.tog_ExerciseType_Recovery);
        ToggleButton togMental = view.findViewById(R.id.tog_ExerciseType_Mental);
        ToggleButton togEndurance = view.findViewById(R.id.tog_ExerciseType_Endurance);
        seekFreq = view.findViewById(R.id.timePerHour);
        seekDur = view.findViewById(R.id.duration);
        ToggleButton togStart = view.findViewById(R.id.startTog);
        // Initial values print to screen Might Be unnecessary if I put the Default text to chose your Break time or somthing
        seekSaver(seekFreq, seekDur, durationText, perHour);
        // Listeners
        // Not Sure what to do with this yet it might be if the user wants a random time generator for a spontaneous break
        togRandom.setOnClickListener(v -> {/* Check Value if statement on boolean*/});
        togRecovery.setOnClickListener(v -> { /* Going to put an if statement in her to turn off the toggle */});
        togMental.setOnClickListener(v -> { /* Going to put an if statement in her to turn off the toggle */ });
        togEndurance.setOnClickListener(v -> { /* Going to put an if statement in her to turn off the toggle */ });
        SeekBar.OnSeekBarChangeListener seekBarChangeListener = createSeekBarChangeListener();
        seekFreq.setOnSeekBarChangeListener(seekBarChangeListener);
        seekDur.setOnSeekBarChangeListener(seekBarChangeListener);
        // Start up or shutdown
        togStart.setOnClickListener(v -> {
            // if is on
                if(togStart.isChecked()) {
                    // check and save settings
                    if(settingSaver(togRandom,togRecovery,togMental,togEndurance)){
                        ScheduleManager.startScheduler();
                    }//failed check turn off
                    else{
                        togStart.setChecked(false);
                    }
                }else{// if toggle is on turn off
                    ScheduleManager.stopScheduler();
                }
        });
        return view;
    }
    // Methods
    // May not need this if we use defualt text value it will move to the listener method
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void seekSaver(SeekBar freq, SeekBar dur, TextView durationText, TextView perHour) {
        durationText.setText("Breaks are " +dur.getProgress() + " minutes");
        perHour.setText("Break every "+ freq.getProgress() + " minutes");
    }
    private SeekBar.OnSeekBarChangeListener createSeekBarChangeListener() {
        return new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            // on progress change this will be where the seekSaver code will be
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekSaver(seekFreq, seekDur, durationText, perHour);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        };
    }
    // Settings error checker and saver
    private boolean settingSaver(ToggleButton togRandom, ToggleButton togRecovery, ToggleButton togMental, ToggleButton togEndurance){
        // Error Checker
        boolean isGood = false;
        // if at least one is checked save and return true
        if(togRecovery.isChecked()==true||togMental.isChecked()==true||togEndurance.isChecked()==true) {

            Settings.setRecovery(togRecovery.isChecked());
            Settings.setEndurance(togEndurance.isChecked());
            Settings.setMental(togMental.isChecked());
            Settings.setFrequency(seekFreq.getProgress());
            Settings.setDuration(seekDur.getProgress());
            isGood= true;
        }
        else { // error message
            Toast.makeText(getActivity(), "Select at least one focus", Toast.LENGTH_LONG).show();
        }
        return isGood;
    }
}
// Hold down Function tha makes pop up scroll view of the vector corresponding to the toggle