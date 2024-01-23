package com.example.myapplication;

public class UserManager {
    private static boolean userLoggedIn = true;
    private static Object[][] userStats= {
            {"Push-ups", 25},
            {"Calories", 34},
            {"Sit-ups", 23},
            {"Breaks", 5},
            {"Meditation",3}
    };
    public static boolean isUserLoggedIn(){
        return userLoggedIn;
    }
    public static void setUserLoggedIn(boolean  loggedIn)
    {
        userLoggedIn = loggedIn;
    }
    public static Object[][] getCurrentStat(){
        return userStats;
    }
}
