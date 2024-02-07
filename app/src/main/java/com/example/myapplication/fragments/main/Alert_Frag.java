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

import java.util.Vector;

public class Alert_Frag extends Fragment {

    private int i;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popup_workout, container, false);
        TextView exerciseTxt = view.findViewById(R.id.workoutText);
        TextView durationTxt = view.findViewById(R.id.txtDuration_Goal);
        Button nextStart = view.findViewById(R.id.btnNext);
        Vector<String> plan = PlanGenerator.generatePlan();
        nextStart.setText("Start");
        nextStart.setOnClickListener(v -> {

            if(i< plan.size()){
                nextStart.setText("Next");
                exerciseTxt.setText(plan.get(i));
                i++;
            }
            else if(i==plan.size()){
                nextStart.setText("End");
                i=0;
            }






            nextStart.setText("End");




        });


        return view;
    }
    // Methods
}
