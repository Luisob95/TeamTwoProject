package com.example.myapplication.activity.plan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class Plan_Menu_Frag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plan_layout, container, false);

        TextView btnRandomize = view.findViewById(R.id.btn_Text_Randomizer);

        btnRandomize.setOnClickListener(v -> {

            Fragment randomizeFragment = new Plan_Rand_Frag();
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentSpot, randomizeFragment)
                    .addToBackStack(null)
                    .commit();
        });
        return view;
    }
}

