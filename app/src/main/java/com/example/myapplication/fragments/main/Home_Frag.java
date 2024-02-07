package com.example.myapplication.fragments.main;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.PlanGenerator;
import com.example.myapplication.R;

public class Home_Frag extends Fragment {
    // Variables
    private TextView textStatName;
    private TextView textStatNumber;
    private TextView tempText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Load Layout
        View view = inflater.inflate(R.layout.home_layout, container, false);
        // Initializers
        textStatName = view.findViewById(R.id.text_Home_StatName);
        textStatNumber = view.findViewById(R.id.text_Home_StatNumber);
        Button btnStatCycle = view.findViewById(R.id.btnStatCycle);
        tempText = view.findViewById(R.id.text_temp);
        return view;
    }

    // Methods

}
