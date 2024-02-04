package com.example.myapplication.fragments.main;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import com.example.myapplication.R;
import com.example.myapplication.ScheduleManager;

public class Home_Frag extends Fragment {
    // Variables
    private TextView textStatName;
    private TextView textStatNumber;
    private TextView tempText;
    private Handler handler = new Handler(Looper.getMainLooper());
    private final int REFRESH_INTERVAL = 10000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Load Layout
        View view = inflater.inflate(R.layout.home_layout, container, false);
        // Initializers
        textStatName = view.findViewById(R.id.text_Home_StatName);
        textStatNumber = view.findViewById(R.id.text_Home_StatNumber);
        Button btnStatCycle = view.findViewById(R.id.btnStatCycle);
        tempText = view.findViewById(R.id.text_temp);
        // Auto Refresh will be moving to Main Activity
        startAutoRefresh();

        return view;
    }

    // Methods
    // Auto refresh will be moving to main
    private void startAutoRefresh() {
        Runnable refreshRunnable = new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void run() {
                  // Check if schedule is on
                if(ScheduleManager.getIsOn()) {
                    // Calculate the countdown
                    ScheduleManager.refreshTime();
                    // Change text to new countdown result
                    tempText.setText(String.valueOf(ScheduleManager.getMinTilEvent()));
                }
                handler.postDelayed(this, REFRESH_INTERVAL);
            }
        };
        handler.postDelayed(refreshRunnable, REFRESH_INTERVAL);
    }
}
