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
    private ToggleButton togRecovery;
    private ToggleButton togEndurance;
    private ToggleButton togMental;
    private ToggleButton togStart;

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Initializers
        View view = inflater.inflate(R.layout.plan_layout, container, false);
        durationText = view.findViewById(R.id.labelTextDuration);
        perHour = view.findViewById(R.id.labelTextperHour);
        ToggleButton togRandom = view.findViewById(R.id.toggle_btn);
        togRecovery = view.findViewById(R.id.tog_ExerciseType_Recovery);
        togMental = view.findViewById(R.id.tog_ExerciseType_Mental);
        togEndurance = view.findViewById(R.id.tog_ExerciseType_Endurance);
        seekFreq = view.findViewById(R.id.timePerHour);
        seekDur = view.findViewById(R.id.duration);
        togStart = view.findViewById(R.id.startTog);
        // Listeners
        // Not Sure what to do with this yet it might be if the user wants a random time generator for a spontaneous break
        togRandom.setOnClickListener(v -> {});
        togRecovery.setOnClickListener(v -> {});
        togMental.setOnClickListener(v -> {});
        togEndurance.setOnClickListener(v -> {});
        SeekBar.OnSeekBarChangeListener seekBarChangeListener = createSeekBarChangeListener();
        seekFreq.setOnSeekBarChangeListener(seekBarChangeListener);
        seekDur.setOnSeekBarChangeListener(seekBarChangeListener);

        // Start up or shutdown
        togStart.setOnClickListener(v -> {
            // if is on
                if(togStart.isChecked()) {
                    // check and save settings
                    if(settingSaver()){
                        ScheduleManager.startScheduler();
                    }//failed check turn off
                    else{
                        togStart.setChecked(false);
                    }
                }else{// if toggle is on turn off
                    ScheduleManager.stopScheduler();
                    // turn on all settings
                    enableDisableBtn(true);
                }
        });
        return view;
    }
    // Methods
    public void  enableDisableBtn(boolean onoff){
        togEndurance.setEnabled(onoff);
        togMental.setEnabled(onoff);
        togRecovery.setEnabled(onoff);
        seekDur.setEnabled(onoff);
        seekFreq.setEnabled(onoff);
    }
    private SeekBar.OnSeekBarChangeListener createSeekBarChangeListener() {
        return new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            // on progress change this will be where the seekSaver code will be
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                durationText.setText("Breaks are " +seekDur.getProgress() + " minutes");
                perHour.setText("Break every "+ seekFreq.getProgress() + " minutes");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        };
    }
    // Settings error checker and saver
    @RequiresApi(api = Build.VERSION_CODES.S)
    private boolean settingSaver(){
        // Error Checker
        boolean isGood = false;
        // if at least one is checked save and return true
        if(togRecovery.isChecked()||togMental.isChecked()||togEndurance.isChecked()) {
// After you Save the setting disable the toggle.
            Settings.setRecovery(togRecovery.isChecked());
            Settings.setEndurance(togEndurance.isChecked());
            Settings.setMental(togMental.isChecked());
            Settings.setFrequency(seekFreq.getProgress());
            Settings.setDuration(seekDur.getProgress());
            enableDisableBtn(false);
            isGood= true;
        }
        else { // error message
            Toast.makeText(getActivity(), "Select at least one focus", Toast.LENGTH_LONG).show();
        }
        return isGood;
    }
    @Override
    public void onResume() {
        super.onResume();
        if(togStart.isChecked()) {
            enableDisableBtn(false);
        }
    }

}
// Hold down Function tha makes pop up scroll view of the vector corresponding to the toggle
//Bugs switching off and on to the tab re enables the buttons