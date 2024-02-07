package com.example.myapplication.activity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.myapplication.R;
import com.example.myapplication.ScheduleManager;
import com.example.myapplication.Settings;
import com.example.myapplication.activity.login.Login_Menu_Act;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Vector;

public class MainActivity extends AppCompatActivity implements ScheduleManager.ScheduleListener {
    private Handler handler = new Handler(Looper.getMainLooper());
    private final int REFRESH_INTERVAL = 10000;
    private ActionBar actionBar;
    private TextView actionText;
    private Vector<String> plan;
    private AlertDialog.Builder builder;
    private NavController navController;

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Check if user is already logged in TEMPORARY FUNCTION
        if (!Settings.getLoggedIn()) {
            Intent intent = new Intent(MainActivity.this, Login_Menu_Act.class);
            startActivity(intent);
            finish();
            return;
        }
        ScheduleManager scheduleManager = new ScheduleManager();
        scheduleManager.setScheduleListener((ScheduleManager.ScheduleListener) this);
        // Load Layout
        setContentView(R.layout.main_layout);
        // Configure Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.fragmentSpot);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navHome, R.id.navPlan, R.id.navProfile).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_fullname_action));
        //actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.black))); Color Change
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_actionbar);
        actionText = actionBar.getCustomView().findViewById(R.id.action_text);
        actionText.setText(null);
        startAutoRefresh();

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
                    long min =ScheduleManager.getMinTilEvent();

                    actionText.setText(String.valueOf(min)+" min");
                    if(min<3){
                        actionText.setTextColor(getColor(R.color.red));
                        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_background_dif));
                    }
                    else {
                        actionText.setTextColor(getColor(R.color.black));
                        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_background));
                    }
                }
                handler.postDelayed(this, REFRESH_INTERVAL);
            }
        };
        handler.postDelayed(refreshRunnable, REFRESH_INTERVAL);
    }

    @Override
    public void onScheduleEventTriggered() {
        navController.navigate(R.id.navBreak);

    }
}




// NEW plan dont schedule reacuring plans because breaks could take longer than expected so come up with a prompt to start click start
// once start cycle through the first generated if endurance have imput promt clicking enter goes to the next. on end schedule a new event
// count down timer on the break
//
