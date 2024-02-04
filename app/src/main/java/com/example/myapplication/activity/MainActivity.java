package com.example.myapplication.activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.myapplication.R;
import com.example.myapplication.Settings;
import com.example.myapplication.activity.login.Login_Menu_Act;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

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
        // Load Layout
        setContentView(R.layout.main_layout);
        // Configure Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.fragmentSpot);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navHome, R.id.navPlan, R.id.navProfile).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
