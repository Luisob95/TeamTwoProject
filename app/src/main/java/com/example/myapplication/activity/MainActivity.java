package com.example.myapplication.activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.myapplication.R;
import com.example.myapplication.ScheduleManager;
import com.example.myapplication.Settings;
import com.example.myapplication.activity.login.Login_Menu_Act;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements ScheduleManager.ScheduleListener {
    private Handler handler = new Handler(Looper.getMainLooper());
    private final int REFRESH_INTERVAL = 1000;
    private ActionBar actionBar;
    private TextView actionText;
    private NavController navController;

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
        /*                              Initialization
        ------------------------------------------------------------------------------*/
        setContentView(R.layout.main_layout);
        // Schedule Listener & Manager
        ScheduleManager scheduleManager = new ScheduleManager();
        scheduleManager.setScheduleListener((ScheduleManager.ScheduleListener) this);
        // Navigation
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSpot);
        navController = navHostFragment.getNavController();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navHome, R.id.navPlan, R.id.navProfile).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        // ActionBar
        initialActionBarsetup();
        // Auto Refresh
        startAutoRefresh();
    }
    // Methods
    private void startAutoRefresh() {
        Runnable refreshRunnable = new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void run() {
                // Changes Actionbar depending on the state
                actionBarDynVisuals();

                handler.postDelayed(this, REFRESH_INTERVAL);
            }
        };
        handler.postDelayed(refreshRunnable, REFRESH_INTERVAL);
    }

    @Override // ScheduleListener trigger
    public void onScheduleEventTriggered() {
        // Navigate to break plan

        MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.boats);
        //music.setLooping(Settings.startSelected);
        music.start();
        navController.navigate(R.id.navBreak);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void actionBarDynVisuals(){
        // Check if schedule is on
        if(ScheduleManager.getIsOn()) {
            // Calculate the countdown
            ScheduleManager.refreshTime();
            // Change text to new countdown result
            Long[] minSec = ScheduleManager.getMinTilEvent();
            Long min = minSec[0];
            Long sec = minSec[1];
            // Set Action to timer
            actionText.setText(String.valueOf(min+":"+sec));
            if(min<3){// Text Color and background changer based on state
                actionText.setTextColor(getColor(R.color.red));
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_black_red));
            }
            else {
                actionText.setTextColor(getColor(R.color.black));
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_white_black));
            }
        }
        else{// MinMax logo
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_minmax));
            actionText.setText(null);// cancel timer text
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void initialActionBarsetup(){
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);//Do not show titles
        actionBar.setDisplayShowCustomEnabled(true);// Allows for Drawable background
        actionBar.setCustomView(R.layout.custom_actionbar);
        actionText = actionBar.getCustomView().findViewById(R.id.action_text);
        actionText.setText(null);// cancel timer text
        actionBarDynVisuals();// Run through the stat base changes
    }
}




// NEW plan dont schedule recurring plans because breaks could take longer than expected so come up with a prompt to start click start
// once start cycle through the first generated if endurance have imput promt clicking enter goes to the next. on end schedule a new event
// count down timer on the break
//
