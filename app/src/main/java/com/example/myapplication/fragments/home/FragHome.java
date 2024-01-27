package com.example.myapplication.fragments.home;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.myapplication.R;
import com.example.myapplication.UserManager;
public class FragHome extends Fragment {
    // Variables
    private int index = 0;
    private TextView textStatName;
    private TextView textStatNumber;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Load Layout
        View view = inflater.inflate(R.layout.frag_home_layout, container, false);
        // Initializers
        textStatName = view.findViewById(R.id.text_Home_StatName);
        textStatNumber = view.findViewById(R.id.text_Home_StatNumber);
        Button btnStatCycle = view.findViewById(R.id.btnStatCycle);
        // Set Starting Stat View
        updateStatValues();
        // Listeners
        // Cycle Menu
        btnStatCycle.setOnClickListener(v -> {
            ++index;
            if (index < UserManager.getCurrentStat().length) {
                updateStatValues();
                // Endless Cycling
            } else {
                index = 0;
                updateStatValues();
            }
        });
        return view;
    }
    // Methods
    //This takes an array index cast it into a string to then show on screen
    private void updateStatValues() {
        String statName = (String) UserManager.getCurrentStat()[index][0];
        String statNumber = String.valueOf(UserManager.getCurrentStat()[index][1]);
        textStatName.setText(statName);
        textStatNumber.setText(statNumber);
    }
}
