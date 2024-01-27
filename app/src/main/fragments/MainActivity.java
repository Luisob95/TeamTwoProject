package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.FragHome;
import com.example.myapplication.FragProfile;
import com.example.myapplication.R;
import com.example.myapplication.UserManager;
import com.example.myapplication.activity.login.LoginActivity;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Login Checker
        Intent intent;
        if (!UserManager.isUserLoggedIn()) {
            intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.main_layout);
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
            bottomNavigationView.setOnItemSelectedListener(navListener);
            setCurrentFragment(new FragHome());
        }
    }
    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentSpot, fragment)
                .commit();
    }

    private NavigationBarView.OnItemSelectedListener navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    Fragment selectedFragment = null;

                    if (item.getItemId() == R.id.btnHome) {
                        selectedFragment = new FragHome();
                    } else if (item.getItemId() == R.id.btnPlan) {
                        selectedFragment = new Plan_Menu_Frag();
                    } else if (item.getItemId() == R.id.btnProfile) {
                        selectedFragment = new FragProfile();
                    }

                    if (selectedFragment != null) {
                        setCurrentFragment(selectedFragment);
                    }
                    return true;
                }
    };
}
