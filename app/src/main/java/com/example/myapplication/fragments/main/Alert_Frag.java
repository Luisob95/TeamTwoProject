package com.example.myapplication.fragments.main;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.myapplication.PlanGenerator;
import com.example.myapplication.R;
import com.example.myapplication.ScheduleManager;
import java.util.Vector;
public class Alert_Frag extends Fragment {
    private int i;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*                              Initialization
        ------------------------------------------------------------------------------*/
        View view = inflater.inflate(R.layout.popup_workout, container, false);
        TextView exerciseTxt = view.findViewById(R.id.workoutText);
        TextView durationTxt = view.findViewById(R.id.txtDuration_Goal);
        NavController navController = Navigation.findNavController(requireActivity(), R.id.fragmentSpot);
        Button nextStart = view.findViewById(R.id.btnNext);
        Vector<String> plan = PlanGenerator.generatePlan(); // This Might change to a on the spot generated if settings get changed to a always changeable state
        nextStart.setText("Start"); // Need to change the base text to this
        // Listeners
        nextStart.setOnClickListener(v -> {
            // start timer
            ScheduleManager.exeSchedule(5);
            // Check if its the last exercise
            if(i< plan.size()){
                nextStart.setText("Next");
                exerciseTxt.setText(plan.get(i));
                i++;
            }
            else if(i==plan.size()){
                nextStart.setText("End");
                i=0;
                navController.popBackStack();

            }
        });
        return view;
    }
    // Methods
}
